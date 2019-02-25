package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

public class InsertionSorter extends AbstractSorter {

    private static final String ALGORITHM_NAME = "Insertion Sorting";

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        for (int i=1; i < intData.length; i++) {
            operationCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (!compareAnsSwapCells(j, j+1)) {
                    break;
                }
            }
            showInfo(i);
        }
        return intData;
    }

    @Override
    public String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
