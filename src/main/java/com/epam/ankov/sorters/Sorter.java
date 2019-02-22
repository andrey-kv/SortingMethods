package com.epam.ankov.sorters;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public interface Sorter {
    int[] sort(int[] initial);
    String getAlgorithmName();

    static String ArrayToString(int[] array) {
        return Arrays.stream(array).mapToObj(Objects::toString).collect(Collectors.joining(", "));
    }
}
