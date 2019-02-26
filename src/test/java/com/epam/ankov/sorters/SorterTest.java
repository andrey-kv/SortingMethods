package com.epam.ankov.sorters;

import com.epam.ankov.sorters.implementation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SorterTest {

    private final int[] initial = { 44, 66, 31, 38, 72, 36, 37, 50, 75, 73, 60, 5, 78, 36, 15, 72,
            14, 58, 82, 21, 43, 19, 17, 24, 77, 31, 36, 74, 78, 13, 43, 92, 88, 16, 95,
            17, 98, 29, 38, 53, 62, 61, 37, 91, 89, 11, 28, 19, 43, 86, 0 };

    @BeforeEach
    void setUp() {
    }

    @Test
    void sortTest() {
        executeTest(new BubbleSorter());
        executeTest(new ShakerSorter());
        executeTest(new HairbrushSorter());
        executeTest(new OddEvenSorter());
        executeTest(new InsertionSorter());
    }

    private void executeTest(Sorter sorter) {
        int[] sortedData;
        sorter.notShowInfo(true);
        sortedData = sorter.sort(initial);

        int[] nativeSorted = new NativeSorter().sort(initial);
        Assertions.assertArrayEquals(nativeSorted, sortedData);
    }

    @Test
    void arrayToString() {
        final int[] initial = { 44, 66, 31, 38, 72, 36 };
        String result = Sorter.ArrayToString(initial);
        Assertions.assertEquals("44, 66, 31, 38, 72, 36", result);
    }
}
