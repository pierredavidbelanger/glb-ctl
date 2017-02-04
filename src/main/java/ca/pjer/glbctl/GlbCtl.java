package ca.pjer.glbctl;

import java.io.Closeable;
import java.io.IOException;

public interface GlbCtl extends Closeable {

    GlbStat getStat() throws IOException, InterruptedException;

    GlbInfo getInfo() throws IOException, InterruptedException;

    void update(GlbNode node, int weight) throws IOException, InterruptedException;

}
