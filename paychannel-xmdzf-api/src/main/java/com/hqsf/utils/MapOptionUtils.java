package com.hqsf.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapOptionUtils {
    public static<K,T> void add(Map<K,List<T>> map, K key, T item){
        List<T> ts = map.get(key);
        if (null == ts){
            ts = new ArrayList<>();
            map.put(key,ts);
        }
        ts.add(item);
    }
}
