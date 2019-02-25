package com.epam.ankov;

import com.epam.ankov.sorters.*;
import com.epam.ankov.sorters.implementation.*;

import java.util.Collections;
import java.util.Random;

public class SorterComparision {
    public void run() {
        // final int[] initial = new Random().ints(0, 100).limit(50).toArray();
         final int[] initial = { 44, 66, 31, 38, 72, 36, 37, 50, 75, 73, 60, 5, 78, 36, 15, 72,
              14, 58, 82, 21, 43, 19, 17, 24, 77, 31, 36, 74, 78, 13, 43, 92, 88, 16, 95,
              17, 98, 29, 38, 53, 62, 61, 37, 91, 89, 11, 28, 19, 43, 86, 0 };

                printHeader("Initial data");
        printArray(initial);

//        Stream.of(new BubbleSorter(),
//                new ShakerSorter(),
//                new HairbrushSorter())
//                .forEach(s -> execute(initial, s));

        execute(initial, new BubbleSorter());
        execute(initial, new ShakerSorter());
        execute(initial, new HairbrushSorter());
        execute(initial, new OddEvenSorter());
        execute(initial, new InsertionSorter());
        execute(initial, new NativeSorter());
    }

    private void execute(int[] initial, Sorter sorter) {
        int[] sortedData;
        printHeader(sorter.getAlgorithmName());
        sortedData = sorter.sort(initial);

        System.out.println("Average execution time: "+ measureExecutionTime(initial, sorter)+" ms.");

        printHeader("result");
        printArray(sortedData);
    }

    private double measureExecutionTime(int[] initial, Sorter sorter) {
        sorter.isNotShowInfo(true);
        long startTime = System.nanoTime();
        int runsCount = 200;
        for (int i=0; i < runsCount; i++) {
            sorter.sort(initial);
        }
        long stopTime = System.nanoTime();
        return (((double) (stopTime - startTime)) / runsCount ) / 1000;
    }

    private void printHeader(String header) {
        int width = 120;
        int sWidth = (width - header.length() - 2) / 2;
        String s = String.join("", Collections.nCopies(sWidth, "="));
        String bar = s + " " + header + " " + s;
        if (bar.length() < width) {
            bar += "=";
        }
        System.out.println();
        System.out.println(bar);
    }

    private void printArray(int[] sortedData) {
        System.out.println(Sorter.ArrayToString(sortedData));
    }
}
