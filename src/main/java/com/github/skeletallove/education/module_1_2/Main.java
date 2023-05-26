package com.github.skeletallove.education.module_1_2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> list = Arrays.asList(6, 1, 4, 6, 8, 1, 100, -100);
        Collection<Integer> list1 = Arrays.asList(3, 8, 76544, -42, 100, 1, 1);
        Collection<Integer> finished = task1(list1, list);
        System.out.println(finished);

        String[] array = {
                "[ }])",
                "([{}])",
                "(",
                "fffsaf",
                " ",
                "",
                ")("
        };
        for (String s : array) {
            System.out.println(s + " - " + task2(s));
        }
    }

    public static Collection<Integer> task1(Collection<Integer> list, Collection<Integer> list1) {
        List<Integer> retained = new ArrayList<>(list1);
        retained.retainAll(list);
        Set<Integer> sorted = new TreeSet<>(retained);
        return sorted;
    }

    public static boolean task2(String text) {
        Deque<Character> stack = new ArrayDeque<>(text.length());
        Set<Character> open = Set.of('(', '{', '[');
        Set<Character> closed = Set.of(')', '}', ']');
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (open.contains(c)){
                stack.add(c);
                continue;
            }
            if (closed.contains(c)){
                if (stack.isEmpty())
                    return false;

                char last = stack.removeLast();
                if (c == ')' && last != '(')
                    return false;
                if (c == ']' && last != '[')
                    return false;
                if (c == '}' && last != '{')
                    return false;
            }
        }

        return stack.size() == 0;
    }
}