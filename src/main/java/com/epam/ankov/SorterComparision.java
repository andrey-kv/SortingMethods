package com.epam.ankov;

import com.epam.ankov.sorters.*;
import com.epam.ankov.sorters.implementation.*;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Stream;

public class SorterComparision {

    private static final int MAXIMAL_ELEMENT = 100;
    private static final int ELEMENTS_COUNT = 50;
    private static final int BENCHMARK_RUNS_COUNT = 200;
    private static final int HEADER_WIDTH = 120;

    public void run() {
        final int[] initial = new Random().ints(0, MAXIMAL_ELEMENT).limit(ELEMENTS_COUNT).toArray();

        printHeader("Initial data");
        printArray(initial);

        Stream.of(new BubbleSorter(),
                new ShakerSorter(),
                new HairbrushSorter(),
                new OddEvenSorter(),
                new InsertionSorter(),
                new NativeSorter())
                .forEach(s -> execute(initial, s));

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
        sorter.notShowInfo(true);
        long startTime = System.nanoTime();
        for (int i = 0; i < BENCHMARK_RUNS_COUNT; i++) {
            sorter.sort(initial);
        }
        long stopTime = System.nanoTime();
        return (((double) (stopTime - startTime)) / BENCHMARK_RUNS_COUNT) / 1000;
    }

    private void printHeader(String header) {
        int sWidth = (HEADER_WIDTH - header.length() - 2) / 2;
        String s = String.join("", Collections.nCopies(sWidth, "="));
        String bar = s + " " + header + " " + s;
        if (bar.length() < HEADER_WIDTH) {
            bar += "=";
        }
        System.out.println();
        System.out.println(bar);
    }

    private void printArray(int[] sortedData) {
        System.out.println(Sorter.ArrayToString(sortedData));
    }
}
