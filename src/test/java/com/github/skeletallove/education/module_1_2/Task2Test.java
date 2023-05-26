package com.github.skeletallove.education.module_1_2;

import com.github.skeletallove.education.module_1_2.Main;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class Task2Test {

    @Test
    public void check() {
        Map<String, Boolean> strings = Map.of(
                "[ }])", false,
                "([{}])", true,
                "(", false,
                "fffsaf", true,
                " ", true,
                "", true,
                ")(", false
        );
        for (Map.Entry<String, Boolean> entry : strings.entrySet()) {
            assertThat(Main.task2(entry.getKey()))
                    .isEqualTo(entry.getValue());
        }
    }

    @ParameterizedTest
    @MethodSource("provideStringsForTest")
    public void check_v2(String text, boolean flag){
        assertThat(Main.task2(text)).isEqualTo(flag);
    }

    private static Stream<Arguments> provideStringsForTest() {
        return Stream.of(
                Arguments.of("i have pooped my pants[uh oh, stinky }that's a real bruh moment if you ask me])", false),
                Arguments.of("([{}])", true),
                Arguments.of("(", false),
                Arguments.of("fffsaf", true),
                Arguments.of(" ", true),
                Arguments.of("", true),
                Arguments.of(")(", false)
        );
    }
}
