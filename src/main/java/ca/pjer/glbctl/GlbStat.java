package ca.pjer.glbctl;

public class GlbStat {

    private long inBytes;
    private long outBytes;

    private long recvBytes;
    private long recvCount;

    private long sendBytes;
    private long sendCount;

    private long connCreated;
    private long connConcurrent;

    private long pollReadCount;
    private long pollWriteCount;
    private long pollCount;

    private float elapsed;

    public long getInBytes() {
        return inBytes;
    }

    public void setInBytes(long inBytes) {
        this.inBytes = inBytes;
    }

    public long getOutBytes() {
        return outBytes;
    }

    public void setOutBytes(long outBytes) {
        this.outBytes = outBytes;
    }

    public long getRecvBytes() {
        return recvBytes;
    }

    public void setRecvBytes(long recvBytes) {
        this.recvBytes = recvBytes;
    }

    public long getRecvCount() {
        return recvCount;
    }

    public void setRecvCount(long recvCount) {
        this.recvCount = recvCount;
    }

    public long getSendBytes() {
        return sendBytes;
    }

    public void setSendBytes(long sendBytes) {
        this.sendBytes = sendBytes;
    }

    public long getSendCount() {
        return sendCount;
    }

    public void setSendCount(long sendCount) {
        this.sendCount = sendCount;
    }

    public long getConnCreated() {
        return connCreated;
    }

    public void setConnCreated(long connCreated) {
        this.connCreated = connCreated;
    }

    public long getConnConcurrent() {
        return connConcurrent;
    }

    public void setConnConcurrent(long connConcurrent) {
        this.connConcurrent = connConcurrent;
    }

    public long getPollReadCount() {
        return pollReadCount;
    }

    public void setPollReadCount(long pollReadCount) {
        this.pollReadCount = pollReadCount;
    }

    public long getPollWriteCount() {
        return pollWriteCount;
    }

    public void setPollWriteCount(long pollWriteCount) {
        this.pollWriteCount = pollWriteCount;
    }

    public long getPollCount() {
        return pollCount;
    }

    public void setPollCount(long pollCount) {
        this.pollCount = pollCount;
    }

    public float getElapsed() {
        return elapsed;
    }

    public void setElapsed(float elapsed) {
        this.elapsed = elapsed;
    }

    @Override
    public String toString() {
        return "GlbStat{" +
                "inBytes=" + inBytes +
                ", outBytes=" + outBytes +
                ", recvBytes=" + recvBytes +
                ", recvCount=" + recvCount +
                ", sendBytes=" + sendBytes +
                ", sendCount=" + sendCount +
                ", connCreated=" + connCreated +
                ", connConcurrent=" + connConcurrent +
                ", pollReadCount=" + pollReadCount +
                ", pollWriteCount=" + pollWriteCount +
                ", pollCount=" + pollCount +
                ", elapsed=" + elapsed +
                '}';
    }
}
