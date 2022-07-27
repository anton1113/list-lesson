package com.gg.list;


import java.util.Arrays;

public class MyListImpl implements MyList {
private Object[] container = new Object[100];
    @Override
    public void add(Object elem) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == null) {
                container[i] = elem;
                return;
            }
        }
    }

    @Override
    public void add(Object elem, int index) {
container[index] = elem;
    }

    @Override
    public Object get(int index) {
        int count = 0;
        Object o = null;
        for (Object value : container) {
            if (value == null) {
                count++;
            } else {
                o = container[index + count];
            }
        }
        return o;
    }

    @Override
    public Object remove(Object elem) {
        Object o = null;
        for (int i = 0; i < container.length; i++) {

            if (container[i] != null && container[i].equals(elem)) {
                o = container[i];
                container[i] = null;
            }

        }
        return  o;
    }

    @Override
    public Object remove(int index) {
        Object o = null;
        for (int i = 0; i < container.length; i++) {

            if (i == index) {
                o = container[i];
                container[i] = null;
            }

        }
        return o;
    }

    @Override
    public void purge() {
        Arrays.fill(container, null);
    }

    @Override
    public int size() {
        int count = 0;
        for (Object o : container) {
            if (o != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyListImpl myList = (MyListImpl) o;
        return Arrays.equals(container, myList.container);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(container);
    }

    @Override
    public boolean isEmpty() {
        if (container.length == 0) {
            return true;
        }
        int count = 0;
        for (Object o : container) {
            if (o != null) {
                count++;
            }
         }
        return count == 0;
        }
     public String toString() {
        int noNullsCount = 0;
         for (Object o :
                 container) {
             if (o != null) noNullsCount++;
         }
         Object[] o  = Arrays.copyOf(container, noNullsCount);
         return Arrays.toString(o);

     }
    }
