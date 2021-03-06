package window.main.sorting.algorithms;

import processing.core.PApplet;
import window.config.Complexities;
import window.config.Config;
import window.config.SortingAlgorithms;
import window.main.sorting.SortingAlgorithm;
import window.main.sorting.colors.Color;
import window.main.sorting.colors.Colors;

public class InPlaceMergeSortTwo extends SortingAlgorithm {
    public InPlaceMergeSortTwo(PApplet pApplet, int[] vector, Color[] color) {
        super(pApplet, vector, color, SortingAlgorithms.IN_PLACE_MERGE_SORT_TWO, Complexities.N_2, Complexities.C);
    }

    @Override
    public void run() {
        onAlgorithmStart();

        mergeSort(0, vector.length - 1);

        onAlgorithmStops();
    }

    private void mergeSort(int l, int r) {
        if (stop) {
            return;
        }

        comparisons++;
        if (l < r) {
            int m = l + (r - l) / 2;

            setColor(m, Colors.PIVOT_COLOR);

            mergeSort(l, m);
            mergeSort(m + 1, r);

            merge(l, m, r);

            resetColor(m);
        }
    }

    private void merge(int start, int mid, int end) {
        if (stop) {
            return;
        }

        int start2 = mid + 1;

        arrayAccess += 2;
        comparisons++;
        if (vector[mid] <= vector[start2]) {
            return;
        }

        while (start <= mid && start2 <= end) {
            if (stop) {
                return;
            }

            comparisons++;
            arrayAccess += 2;
            if (vector[start] <= vector[start2]) {
                start++;
            } else {
                int value = vector[start2];
                int index = start2;

                arrayAccess++;

                while (index != start) {
                    vector[index] = vector[index - 1];
                    arrayAccess += 2;
                    index--;
                }

                /* START: ANIMATION */
                setColor(start, Colors.CURRENT_INDEX);
                setColor(start2, Colors.SWAPPING_INDEX);
                playSound(start);
                playSound(start2);

                sleep();

                stopSound();

                while (pause) {
                    if (stop) {
                        return;
                    }
                    sleep(Config.PAUSE_DELAY_TIME);
                }

                resetColor(start);
                resetColor(start2);
                /* END: ANIMATION */

                vector[start] = value;
                arrayAccess++;

                start++;
                mid++;
                start2++;
            }
        }
    }
}
