package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MaxTest {

    @Test
    public void when2and8Then8() {
        int left = 2;
        int right = 8;
        int result = Max.max(left, right);
        int expected = 8;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void when2and8and12Then12() {
        int left = 2;
        int right = 8;
        int three = 12;
        int result = Max.max(left, right, three);
        int expected = 12;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void when2and8and12and61Then61() {
        int left = 2;
        int right = 8;
        int three = 12;
        int four = 61;
        int result = Max.max(left, right, three, four);
        int expected = 61;
        assertThat(result).isEqualTo(expected);
    }
}
