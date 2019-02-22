package com.epam.ankov.sorters;

public abstract class AbstractSorter implements Sorter {

    protected int operationCount;
    protected int[] intData;

    protected void cloneArray(int[] initial) {
        intData = new int[initial.length];
        System.arraycopy(initial, 0, intData, 0, initial.length);
    }

    protected void directPass(int startPos, int endOffset) {
        operationCount = 0;
        int endPos = intData.length - endOffset;
        for (int i = startPos; i < endPos; i++) {
            compareAnsSwapCells(i, i + 1);
        }
    }

   protected void compareAnsSwapCells(int idx1, int idx2) {
        if (intData[idx1] > intData[idx2]) {
            int buffer = intData[idx2];
            intData[idx2] = intData[idx1];
            intData[idx1] = buffer;
            operationCount++;
        }
    }

    protected void showInfo(int pass) {
        showInfo(pass, "");
    }

    protected void showInfo(int pass, String addInfo) {
        if (!addInfo.isEmpty()) {
            addInfo = ", " + addInfo;
        }
        System.out.println("pass = " + pass + ": " + Sorter.ArrayToString(intData)+": Op = " + operationCount + addInfo);
    }

    protected boolean noSwaps() {
        return operationCount == 0;
    }


}
