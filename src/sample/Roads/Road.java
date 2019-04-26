package sample.Roads;

public class Road {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Road() {
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
    }

    public Road(int StartX, int StartY, int EndX, int EndY) {
        this.startX = StartX;
        this.startY = StartY;
        this.endX = EndX;
        this.endY = EndY;
    }

    public int getStartX() {
        return startX;
    }
    public int getStartY() {
        return startY;
    }
    public int getEndX() {
        return endX;
    }
    public int getEndY() {
        return endY;
    }
}
