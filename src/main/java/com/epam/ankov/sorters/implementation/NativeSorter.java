package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

import java.util.Arrays;

public class NativeSorter extends AbstractSorter {

    private static final String ALGORITHM_NAME = "Java Native Sorting";

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        Arrays.sort(intData);
        return intData;
    }

    @Override
    public String getAlgorithmName() {
        return ALGORITHM_NAME;
    }
}
