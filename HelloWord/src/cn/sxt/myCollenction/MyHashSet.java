package cn.sxt.myCollenction;

import java.util.HashMap;

public class MyHashSet<T> {
    HashMap<T, Object> map;
    static final Object o = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    int size() {
        return map.size();
    }

    public void add(T v) {
        map.put(v, o);
    }

    public T remove(T v) {
        if (map.remove(v) == null)
            return null;
        return v;
    }

    public void addAll(MyHashSet<T> m) {
        map.putAll(m.map);
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public void clear() {
        map.clear();
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(T i : map.keySet()){
            s.append(i.toString()+",");
        }
        s.replace(s.length()-1,s.length(),"]");
        return s.toString();
    }
}
