package windows;

import processing.core.PApplet;

public abstract class Panel {
    protected final int width;
    protected final int height;
    protected final int x;
    protected final int y;
    protected int panelColor;
    protected final PApplet pApplet;

    public Panel(PApplet pApplet, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.panelColor = pApplet.color(20);
        this.x = x;
        this.y = y;

        this.pApplet = pApplet;
    }

    public abstract void draw();

    public void start() {
        pApplet.registerMethod("draw", this);
    }

    public void stop() {
        pApplet.unregisterMethod("draw", this);
    }

    /* GETTERS AND SETTERS */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setColor(int r, int g, int b) {
        panelColor = pApplet.color(r, g, b);
    }

    public void setColor(int c) {
        panelColor = pApplet.color(c);
    }

    public void mouseReleased() { }
}
