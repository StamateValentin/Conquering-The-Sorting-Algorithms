package windows.main.sorting;

import windows.main.sorting.colors.Color;

public abstract class SortingAlgorithm implements Runnable {

    protected int[] vector;
    protected Color[] color;

    protected boolean pause = false;
    protected boolean stop = false;
    protected int sleepTime = 10;

    protected int comparisons;
    protected int arrayAccess;
    protected final String algorithm;

    public SortingAlgorithm(int[] vector, Color[] color, String algorithm) {
        this.vector = vector;
        this.color = color;
        this.algorithm = algorithm;
    }

    public void start() {
        stop = false;
        pause = false;

        Thread thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        pause = true;
    }

    public void resume() {
        pause = false;
    }

    public void stop() {
        stop = true;
    }

    protected void swap(int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }

    protected void setColor(int i, Color color) {
        this.color[i] = color;
    }

    protected void sleep() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /* GETTERS AND SETTERS */
    public int getComparisons() {
        return comparisons;
    }

    public int getArrayAccess() {
        return arrayAccess;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
