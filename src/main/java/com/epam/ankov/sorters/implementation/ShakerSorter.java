package com.epam.ankov.sorters.implementation;

import com.epam.ankov.sorters.AbstractSorter;

public class ShakerSorter extends AbstractSorter {

    @Override
    public int[] sort(int[] initial) {
        cloneArray(initial);
        for (int i=1; i < intData.length; i++) {
            directPass(i-1, i);
            showInfo(i, "Direct");
            if (noSwaps()) {
                break;
            }

            reversePass(i-1, i+1);
            showInfo(i, "Reverse");
            if (noSwaps()) {
                break;
            }
        }
        return intData;
    }

    private void reversePass(int startPos, int endOffset) {
        operationCount = 0;
        int endPos = intData.length - endOffset;
        for (int i = endPos; i > startPos; i--) {
            compareAnsSwapCells(i - 1, i);
        }
    }

    @Override
    public String getAlgorithmName() {
        return "Shaker Sorting";
    }
}
