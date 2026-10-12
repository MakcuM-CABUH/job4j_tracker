package ru.job4j.collection;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task.",
        };
        String[] output = {
                "1. Task.",
                "2. Task.",
                "10. Task.",
        };
        Arrays.sort(input, new LexSort());
        assertThat(input).containsExactly(output);
    }
}
