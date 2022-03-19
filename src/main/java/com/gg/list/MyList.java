package com.gg.list;

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

    static MyListImpl of(Object... elems) {
        MyListImpl list = new MyListImpl();
        for (Object elem : elems) {
            list.add(elem);
        }
        return list;
    }
}
