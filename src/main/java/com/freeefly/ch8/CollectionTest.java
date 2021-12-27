package com.freeefly.ch8;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Map.entry;

public class CollectionTest {
    public static void main(String[] args) {
        Map<String, String> family = Map.ofEntries(
                entry("T", "Star"), entry("C", "James")
        );
        Map<String, String> friend = Map.ofEntries(
                entry("R", "Star"), entry("C", "Matrix")
        );

        friend.forEach((k,v) ->{
            family.merge(k, v, (v1, v2) -> v1 + " & " + v2);
        });

        ConcurrentHashMap<String, Long> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.reduceValues(1, Long::max);

    }
}
