package windows.main.sorting;

import processing.core.PApplet;
import windows.config.Theme;
import windows.main.sorting.colors.Color;
import windows.main.sorting.colors.Colors;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, "Bubble Sort");
    }

    @Override
    public void run() {
        int n = vector.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    swap(j, j + 1);
                    comparisons++;
                    arrayAccess += 2;

                    setColor(j, Colors.BLUE);
                    setColor(j + 1, Colors.RED);

                    playSound(vector[j]);
                    playSound(vector[j + 1]);
                    sleep();
                    stopSound();

                    setColor(j, Theme.LINE_COLOR);
                    setColor(j + 1, Theme.LINE_COLOR);
                }
            }
        }
    }

}
