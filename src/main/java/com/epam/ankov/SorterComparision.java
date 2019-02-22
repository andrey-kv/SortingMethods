package com.epam.ankov;

import com.epam.ankov.sorters.*;
import com.epam.ankov.sorters.implementation.BubbleSorter;
import com.epam.ankov.sorters.implementation.HairbrushSorter;
import com.epam.ankov.sorters.implementation.OddEvenSorter;
import com.epam.ankov.sorters.implementation.ShakerSorter;

import java.util.Collections;
import java.util.Random;

public class SorterComparision {
    public void run() {
        final int[] initial = new Random().ints(0, 100).limit(25).toArray();
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
    }

    private void execute(int[] initial, Sorter sorter) {
        int[] sortedData;
        printHeader(sorter.getAlgorithmName());
        sortedData = sorter.sort(initial);
        printHeader("result");
        printArray(sortedData);
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
