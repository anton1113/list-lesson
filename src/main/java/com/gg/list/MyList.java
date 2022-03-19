package com.gg.list;

import com.gg.list.exception.NotImplementedException;

public interface MyList {

    void add(Object elem);

    void add(Object elem, int index);

    Object get(int index);

    /**
     * Delete element from list
     * @param elem to delete
     * @return deleted element
     */
    Object remove(Object elem);

    /**
     * Delete i-th element from list
     * @param index of element to delet
     * @return deleted element
     */
    Object remove(int index);

    void purge();

    int size();

    boolean isEmpty();

    default void reverse() {
        throw new NotImplementedException("Vovan will handle it");
    }

    default MyList subList(int start, int end) {
        throw new NotImplementedException("Vovan will handle it");
    }


    static MyListImpl of(Object... elems) {
        MyListImpl list = new MyListImpl();
        for (Object elem : elems) {
            list.add(elem);
        }
        return list;
    }
}
