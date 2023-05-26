package com.github.skeletallove.education.module_1_2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Task1Test {

    @Test
    public void check() {
        Collection<Integer> list = Arrays.asList(6, 1, 4, 6, 8, 1, 100, -100);
        Collection<Integer> list1 = Arrays.asList(3, 8, 76544, -42, 100, 1, 1);
        assertThat(Main.task1(list, list1))
                .containsExactlyInAnyOrder(1, 8, 100)
                .hasSize(3)
                .isEqualTo(Set.of(1, 8, 100)); // Просто показал что так тоже можно
    }
}
