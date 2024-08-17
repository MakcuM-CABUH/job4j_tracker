package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class PointTest {

    @Test
    void when00To20Then2() {
        double expected = 2.0;
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double rsl = a.distance(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when20To13Then3dot16() {
        double expected = 3.16;
        Point a = new Point(2, 0);
        Point b = new Point(1, 3);
        double rsl = a.distance(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when00To13Then3dot16() {
        double expected = 3.16;
        Point a = new Point(0, 0);
        Point b = new Point(1, 3);
        double rsl = a.distance(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when02To27Then5dot39() {
        double expected = 5.39;
        Point a = new Point(0, 2);
        Point b = new Point(2, 7);
        double rsl = a.distance(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when000To133Then4dot35() {
        double expected = 4.35;
        Point a = new Point(0, 0, 0);
        Point b = new Point(1, 3, 3);
        double rsl = a.distance3d(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when021To033Then2dot23() {
        double expected = 2.23;
        Point a = new Point(0, 2, 1);
        Point b = new Point(0, 3, 3);
        double rsl = a.distance3d(b);
        assertThat(rsl).isEqualTo(expected, withPrecision(0.01));
    }
}
