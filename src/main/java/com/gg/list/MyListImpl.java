package com.gg.list;

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
        return container[index];
    }

    @Override
    public Object remove(Object elem) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void purge() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
