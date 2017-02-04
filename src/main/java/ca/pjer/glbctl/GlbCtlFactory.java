package ca.pjer.glbctl;

import java.io.IOException;

public abstract class GlbCtlFactory {

    public static GlbCtl connect(String host, int port) throws IOException, InterruptedException {
        GlbCtlImpl impl = new GlbCtlImpl(host, port);
        impl.connect();
        return impl;
    }
}
