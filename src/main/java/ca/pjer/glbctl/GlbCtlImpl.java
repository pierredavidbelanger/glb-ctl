package ca.pjer.glbctl;

import java.io.*;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class GlbCtlImpl implements GlbCtl {

    private final String host;
    private final int port;

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public GlbCtlImpl(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public GlbStat getStat() throws IOException, InterruptedException {
        send("getstat");
        String line = receive("in:");
        List<String> cols = Stream.of(line.split("\\s+"))
                .map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
        GlbStat stat = new GlbStat();
        stat.setInBytes(parseInt(cols.get(1)));
        stat.setOutBytes(parseInt(cols.get(3)));
        stat.setRecvBytes(parseInt(cols.get(5)));
        stat.setRecvCount(parseInt(cols.get(7)));
        stat.setSendBytes(parseInt(cols.get(9)));
        stat.setSendCount(parseInt(cols.get(11)));
        stat.setConnCreated(parseInt(cols.get(13)));
        stat.setConnConcurrent(parseInt(cols.get(15)));
        stat.setPollReadCount(parseInt(cols.get(17)));
        stat.setPollWriteCount(parseInt(cols.get(19)));
        stat.setPollCount(parseInt(cols.get(21)));
        stat.setElapsed(parseFloat(cols.get(23)));
        return stat;
    }

    public GlbInfo getInfo() throws IOException, InterruptedException {
        send("getinfo");
        String res = receive("Destinations:");
        GlbInfo info = new GlbInfo(new LinkedHashMap<>(10));
        String[] lines = res.split("\n");
        for (String line : lines) {
            if (line.startsWith("Router:")) {
                // nothing
            } else if (line.startsWith("-----")) {
                // nothing
            } else if (line.startsWith("        Address       :")) {
                // nothing
            } else if (line.startsWith("Destinations:")) {
                // TODO
            } else {
                List<String> cols = Stream.of(line.split("\\s+"))
                        .map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toList());
                String[] hostPort = cols.get(0).split(":");
                GlbNode node = new GlbNode(hostPort[0], parseInt(hostPort[1]));
                GlbNodeInfo nodeInfo = new GlbNodeInfo(parseFloat(cols.get(2)), parseFloat(cols.get(3)), cols.get(4), parseInt(cols.get(5)));
                info.getRouter().put(node, nodeInfo);
            }
        }
        return info;
    }

    public void update(GlbNode node, int weight) throws IOException, InterruptedException {
        send(node.getHost() + ":" + node.getPort() + ":" + weight);
        String line = receive("Ok", "Error");
        // todo
    }

    public void close() throws IOException {
        disconnect();
    }

    void send(String req) {
        writer.println(req);
    }

    int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    float parseFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return Float.NaN;
        }
    }

    String receive(String... prefixes) throws IOException {
        StringBuilder res = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            res.append(line).append("\n");
            for (String prefix : prefixes) {
                if (line.startsWith(prefix)) {
                    return res.toString();
                }
            }
        }
        return res.toString();
    }

    void connect() throws IOException {
        disconnect();
        Socket socket = new Socket(host, port);
        this.socket = socket;
        writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
    }

    void disconnect() throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                // ignore
            }
        }
        socket = null;
        writer = null;
        reader = null;
    }
}
