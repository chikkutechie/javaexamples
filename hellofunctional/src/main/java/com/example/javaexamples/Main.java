package com.example.javaexamples;

import fj.data.List;
import fj.Show;

public class Main {
    public static void main(String[] args) {
        Common.init("Hello Functional Java");

        final List<Integer> a = List.list(1, 2, 3).map(i -> i * i);
        Show.listShow(Show.intShow).println(a);
    }
}

