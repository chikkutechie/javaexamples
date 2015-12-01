package com.example.javaexamples;

import rx.Observable;
import rx.functions.Action1;

public class Main {
    public static void main(String[] args) {
        Common.init("Hello RxJava");

        Observable<String> tweets = Observable.just("Hello RxJava!", "RxJava is fun!!", "RxJava rocks!!!");
        tweets.subscribe( (s) -> System.out.println(s));
    }
}

