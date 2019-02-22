package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

public class HairbrushSorter extends AbstractSorter {

    private static final double REDUCE_FACTOR = 1.247;
    private static final String ALGORITHM_NAME = "Hairbrush Sorting";

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        int brushWidth = intData.length;
        int pass = 0;

        do {
            brushWidth = Math.max((int) (brushWidth / REDUCE_FACTOR), 1);
            brushPass(brushWidth);
            showInfo(++pass, "brushWidth = " + brushWidth);
        } while (brushWidth > 1 || operationCount > 0);
        return intData;
    }

    private void brushPass(int brushWidth) {
        operationCount = 0;
        int endPos = intData.length - brushWidth;
        for (int i = 0; i < endPos; i++) {
            int idx2 = i + brushWidth;
            compareAnsSwapCells(i, idx2);
        }
    }

    @Override
    public String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
