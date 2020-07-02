package cn.sxt.myCollenction;


public class MyHashMap<K,V> {
    private Node<K,V>[] table;
    private int size;

    public MyHashMap(){
        table = new Node[16];
        size = 0;
    }

    public void put(K key,V value){
        Node<K,V> temp = new Node<>(key,value);
        temp.hash = myHash(key.hashCode(),table.length);
        if(table[temp.hash]==null)
            table[temp.hash] = temp;
        else {
            Node<K,V> i = table[temp.hash];
            Node<K,V> last = i;
            while (i!=null){
                if(i.key.equals(key)){
                    i.value = value;
                    break;
                }
                last = i;
                i = i.next;
            }
            if(i == null){
                last.next = temp;
            }
        }
        size++;
    }

    public V get(K key){
        V res = null;
        int hash = myHash(key.hashCode(),table.length);
        Node<K,V> i = table[hash];
        while(i!=null){
            if(i.key.equals(key)){
                res = i.value;
                break;
            }
            i = i.next;
        }
        return res;
    }

    public int myHash(int h,int l){
        return h&(l-1);
    }

    public boolean containsKey(K key){
        for(Node<K,V>i:table){
            while(i!=null){
                if(i.key.equals(key))
                    return true;
                i = i.next;
            }
        }
        return false;
    }

    public boolean containsValue(V value){
        for(Node<K,V>i:table){
            while(i!=null){
                if(i.value.equals(value))
                    return true;
                i = i.next;
            }
        }
        return false;
    }

    public V remove(K key){
        V res = null;
        int hash = myHash(key.hashCode(),table.length);
        Node<K,V> i = table[hash];
        Node<K,V> p = table[hash];
        while(i!=null){
            if(i.key.equals(key)){
                res = i.value;
                if(p == i)
                    table[hash] = null;
                else
                    p.next = i.next;
                break;
            }
            p = i;
            i = i.next;
        }
        return res;
    }

    public String toString(){
        if(size==0)return "[]";
        StringBuilder s = new StringBuilder();
        s.append("[");
        for(Node<K,V> i:table){
            while (i!=null){
                s.append(i.toString()+",");
                i = i.next;
            }
        }
        s.delete(s.length()-1,s.length());
        s.append("]");
        return s.toString();
    }
}



class Node<K,V>{
    int hash;
    K key;
    V value;
    Node<K,V> next;
    public Node(){next = null;}
    public Node(K _key,V _value){
        key = _key;
        value = _value;
        next = null;
    }
    public String toString(){
        return "("+key.toString()+"  "+value.toString()+")";
    }
}