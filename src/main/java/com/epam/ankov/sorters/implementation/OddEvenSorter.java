package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

public class OddEvenSorter extends AbstractSorter {

    private static final String ALGORITHM_NAME = "Odd–even Sorting";

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        for (int i = 0; i < intData.length; i++) {
            operationCount = 0;
            for (int j = (i % 2); j < intData.length - 1; j += 2) {
                compareAnsSwapCells(j, j+1);
            }
            showInfo(i, (i % 2) == 0 ? "Odd" : "Even");
            if (noSwaps()) {
                break;
            }
        }
        return intData;
    }

    @Override
    public String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
