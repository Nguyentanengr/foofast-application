package com.swingapplication.foofast.controllers;

import java.util.TreeMap;

public class N22DCCN156_EX11 {
    public static void main(String[] args) {
        TreeMap<String, String> treeMapStudents = new TreeMap<>();

        treeMapStudents.put("S001", "Alice");
        treeMapStudents.put("S003", "Bob");
        treeMapStudents.put("S002", "Charlie");
        treeMapStudents.put("S005", "David");
        treeMapStudents.put("S004", "Eva");

        System.out.println("Keys in treeMapStudents: ");
        for (String key : treeMapStudents.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nValues in treeMapStudents: ");
        for (String value : treeMapStudents.values()) {
            System.out.println(value);
        }

        String firstKey = treeMapStudents.firstKey();
        String lastKey = treeMapStudents.lastKey();

        System.out.println("\nFirst (lowest) key: " + firstKey);
        System.out.println("Last (highest) key: " + lastKey);
    }
}

