package ca.pjer.glbctl;

public class GlbNode {

    private String host;
    private int port;

    public GlbNode() {
    }

    public GlbNode(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlbNode glbNode = (GlbNode) o;
        if (port != glbNode.port) return false;
        return host.equals(glbNode.host);
    }

    @Override
    public int hashCode() {
        int result = host.hashCode();
        result = 31 * result + port;
        return result;
    }

    @Override
    public String toString() {
        return "GlbNode{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
