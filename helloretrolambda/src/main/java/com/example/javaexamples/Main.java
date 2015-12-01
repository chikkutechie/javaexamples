package com.example.javaexamples;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Common.init("Hello Retrolambda");

        String[] months = {"January", "February", "March", "April",
                           "May", "June", "July", "August", "September",
                           "October", "December"};

        // Sort by length of the month
        Arrays.sort(months, (a, b) -> a.length() - b.length());

        for (String i: months) {
            System.out.println(i);
        }
    }
}

