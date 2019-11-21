package com.advenced_java.api.model;

public class Indexes {

    private static int id = 0;

    public static int getId() {
        return ++id;
    }

}