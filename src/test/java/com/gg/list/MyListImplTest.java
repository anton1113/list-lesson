package com.gg.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyListImplTest {

    private static final String FOO = "foo";
    private static final String BAR = "bar";
    private static final String BUS = "bus";

    private static final int INITIAL_LIST_SIZE = 3;

    private MyList list;

    @BeforeEach
    public void init() {
        list = new MyListImpl();
        list.add(FOO);
        list.add(BAR);
        list.add(BUS);
    }

    @Test
    public void testGet() {
        assertListContent(list, FOO, BAR, BUS);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(list.isEmpty());
        list = new MyListImpl();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(INITIAL_LIST_SIZE, list.size());
        list.add("gachi");
        list.add("muchi");
        assertEquals(INITIAL_LIST_SIZE + 2, list.size());
    }

    @Test
    public void testRemove() {
        list.remove(FOO);
        assertEquals(2, list.size());
        assertEquals(BAR, list.get(0));
        list.remove(1);
        assertEquals(1, list.size());
        assertEquals(BUS, list.get(0));
    }

    @Test
    public void testPurge() {
        list.purge();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEquals() {
        MyList list1 = MyList.of("gg", "ff");
        MyList list2 = MyList.of("gg");
        assertNotEquals(list1, list2);
        list2.add("ff");
        assertEquals(list1, list2);
    }

    @Test
    public void testToString() {
        String expected = String.format("[\"%s\", \"%s\", \"%s\"]", FOO, BAR, BUS);
        assertEquals(expected, list.toString());
    }

    @Test
    public void testReverse() {
        list.reverse();
        assertListContent(list, BUS, BAR, FOO);
    }

    @Test
    public void testSubList() {
        assertListContent(list.subList(0, 1), FOO, BAR);
        assertListContent(list.subList(2, 2), BUS);
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(-1, 0));
    }

    private void assertListContent(MyList list, Object... elements) {
        for (int i = 0; i < elements.length; i++) {
            assertEquals(elements[i], list.get(i));
        }
    }
}
