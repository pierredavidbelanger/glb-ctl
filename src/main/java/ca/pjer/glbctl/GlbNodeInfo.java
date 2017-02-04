package ca.pjer.glbctl;

public class GlbNodeInfo {

    private float weight;
    private float usage;
    private String map;
    private int conns;

    public GlbNodeInfo() {
    }

    public GlbNodeInfo(float weight, float usage, String map, int conns) {
        this.weight = weight;
        this.usage = usage;
        this.map = map;
        this.conns = conns;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getUsage() {
        return usage;
    }

    public void setUsage(float usage) {
        this.usage = usage;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public int getConns() {
        return conns;
    }

    public void setConns(int conns) {
        this.conns = conns;
    }

    @Override
    public String toString() {
        return "GlbNodeInfo{" +
                "weight=" + weight +
                ", usage=" + usage +
                ", map='" + map + '\'' +
                ", conns=" + conns +
                '}';
    }
}
