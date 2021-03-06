package com.epam.ankov.sorters;

public abstract class AbstractSorter implements Sorter {

    protected int operationCount;
    protected int[] intData;
    private boolean notShowInfo = false;

    @Override
    public void notShowInfo(boolean notShowInfo) {
        this.notShowInfo = notShowInfo;
    }

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

   protected boolean compareAnsSwapCells(int idx1, int idx2) {
        if (intData[idx1] > intData[idx2]) {
            int buffer = intData[idx2];
            intData[idx2] = intData[idx1];
            intData[idx1] = buffer;
            operationCount++;
            return true;
        }
        return false;
    }

    protected void showInfo(int pass) {
        showInfo(pass, "");
    }

    protected void showInfo(int pass, String addInfo) {
        if (notShowInfo) {
            return;
        }
        if (!addInfo.isEmpty()) {
            addInfo = ", " + addInfo;
        }
        System.out.println("pass = " + pass + ": " + Sorter.ArrayToString(intData)+": Op = " + operationCount + addInfo);
    }

    protected boolean noSwaps() {
        return operationCount == 0;
    }


}
