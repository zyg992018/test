package cn.sxt.myCollenction;

import java.util.Arrays;

public class MyArrayList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] obj;

    public MyArrayList(){obj = new Object[DEFAULT_CAPACITY];}
    public MyArrayList(int c){obj = new Object[c];}

    private void checkIndex(int index){
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException("索引越界：index:"+index+"  size:"+size);
    }

    private void expend(int _size){
        if(_size >= obj.length){
            Object[] _obj = new Object[obj.length+(obj.length>>1)];
            System.arraycopy(obj,0,_obj,0,size);
            obj = _obj;
        }
    }

    public void add(E e){
        expend(size+1);
        obj[size++] = e;
    }

    public void add(int index,E e){
        expend(size+1);
        if(index != 0)
            checkIndex(index-1);
        System.arraycopy(obj,index,obj,index+1,size-index);
        size++;
        obj[index] = e;
    }

    public E remove(int index){
        checkIndex(index);
        Object old = obj[index];
        System.arraycopy(obj,index+1,obj,index,size-index-1);
        obj[size--] = null;
        return (E) old;
    }

    public E remove(Object o){
        int index = indexOf(o);
        if(index > -1)
            return remove(index);
        return null;
    }

    public String toString(){
        if(size == 0)return "[]";
        StringBuilder S = new StringBuilder();
        S.append("[");
        for(int i = 0; i < size; i++)
            S.append(obj[i].toString()+",");
        S.delete(S.length()-1,S.length());
        S.append("]");
        return S.toString();
    }

    public E set(int index, E e){
        checkIndex(index);
        E oldValue = (E) obj[index];
        obj[index] = e;
        return oldValue;
    }

    public E get(int index){
        checkIndex(index);
        return (E) obj[index];
    }

    public int size(){ return size; }

    public boolean isEmpty(){ return size == 0; }

    public int indexOf(Object o){
        if(o == null)
            for(int i = 0; i < size; i++){
                if(obj[i] == null)
                    return i;
            }
        else
            for(int i = 0; i < size; i++){
                if(obj[i].equals(o))
                    return i;
            }
        return -1;
    }

    public int lastIndexOf(Object o){
        if(o == null)
            for(int i = size-1; i >= 0; i--){
                if(obj[i] == null)
                    return i;
            }
        else
            for(int i = size-1; i >= 0; i--){
                if(obj[i].equals(o))
                    return i;
            }
        return -1;
    }

    public boolean contains(Object o){ return indexOf(o) > -1; }

    public Object[] toArray(){ return Arrays.copyOf(obj,size); }

    public void clear(){ size = 0; }

}
