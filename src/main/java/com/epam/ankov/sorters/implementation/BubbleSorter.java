package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

public class BubbleSorter extends AbstractSorter {

    private static final String ALGORITHM_NAME = "Bubble Sorting";

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        for (int idx=1; idx < intData.length; idx++) {
            directPass(0, idx);
            showInfo(idx);
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
