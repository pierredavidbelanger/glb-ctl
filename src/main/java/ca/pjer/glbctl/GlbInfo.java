package ca.pjer.glbctl;

import java.util.Map;

public class GlbInfo {

    private Map<GlbNode, GlbNodeInfo> router;

    public GlbInfo() {
    }

    public GlbInfo(Map<GlbNode, GlbNodeInfo> router) {
        this.router = router;
    }

    public Map<GlbNode, GlbNodeInfo> getRouter() {
        return router;
    }

    public void setRouter(Map<GlbNode, GlbNodeInfo> router) {
        this.router = router;
    }

    @Override
    public String toString() {
        return "GlbInfo{" +
                "router=" + router +
                '}';
    }
}
