/*
 * Testing method which is testing if every method implemented in OwnArrayList class work properly.
 */
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Own ArrayList class should: ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OwnArrayListTest {
    @Test
    @Order(1)
    @DisplayName("check size of a list")
    public void shouldCheckSizeOfList(){
        OwnArrayList list = new OwnArrayList(5);
        assertEquals(5,list.size());
        list.add("Jan");
        assertEquals(1,list.size());
        list.add("Pawel");
        assertEquals(2,list.size());
        list.remove(0);
        assertEquals(3,list.size());
        list.remove("Pawel");
        assertEquals(1,list.size());
        list.add(1);
        assertEquals(1,list.size());
        list.add(4);
        assertEquals(2,list.size());
    }

    @Test
    @Order(2)
    @DisplayName("check if list is empty")
    public void shouldCheckIfListIsEmpty(){
        OwnArrayList list = new OwnArrayList();
        assertTrue(list.isEmpty());
        list.add(1);
        list.add("Jan");
        list.add(4.5);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @Order(3)
    @DisplayName("check if list contains specified element")
    public void shouldCheckIfListContainsElement(){
        OwnArrayList list = new OwnArrayList();
        list.add(5);
        list.add(6.7);
        list.add(3.5f);
        list.add("Jan");
        list.add(true);
        assertAll("contains the element",
                () -> assertTrue(list.contains("Jan")),
                () -> assertTrue(list.contains(6.7)),
                () -> assertFalse(list.contains(7.543)),
                () -> assertTrue(list.contains(3.5f)),
                () -> assertTrue(list.contains(true))
        );
        list.remove(1);
        assertFalse(list.contains(6.7));
        assertTrue(list.contains(5));
    }

    @Test
    @Order(4)
    @DisplayName("add new elements to the list")
    public void shouldAddElement(){
        OwnArrayList list = new OwnArrayList();
        list.add(9);
        list.add(10);
        list.add(1,4);
        list.add("Jan");
        list.add(6.7);
        assertAll("added elements",
                ()->assertEquals(9,list.get(0)),
                ()->assertEquals(4,list.get(1)),
                ()->assertEquals(10,list.get(2)),
                ()->assertEquals("Jan",list.get(3)),
                ()->assertEquals(6.7,list.get(4))
        );
    }

    @Test
    @Order(5)
    @DisplayName("remove an element from list")
    public void shouldRemoveElement(){
        OwnArrayList list = new OwnArrayList(-1);
        list.add(9L);
        list.add(true);
        list.add(1,4);
        list.add(3.14d);
        list.add(6.7f);
        list.add('D');
        list.add("Jan");
        assertTrue(list.remove(true));
        assertFalse(list.remove("Kamil"));
        list.remove("Jan");
        assertTrue(list.remove(6.7f));
        assertTrue(list.remove(3.14d));
        list.remove((Character)'D');
        list.remove((Integer) 4);
        list.remove(9L);
        assertAll("removed elements",
                () -> assertEquals(1,list.size()),
                () -> assertNull(list.get(0)),
                () -> assertThrows(RuntimeException.class, () -> list.remove(5)),
                () -> assertThrows(RuntimeException.class, () -> list.remove(-5))
        );
    }

    @Test
    @Order(6)
    @DisplayName("clear list")
    public void shouldClearList(){
        OwnArrayList list = new OwnArrayList();
        list.clear();
        assertTrue(list.isEmpty());
        list.add(9);
        list.add(true);
        list.add(1,4);
        list.add(6.7);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(1,list.size());
    }

    @Test
    @Order(7)
    @DisplayName("check which element is on specified position on the list")
    public void shouldGetElementFromList(){
        OwnArrayList list = new OwnArrayList();
        list.add(9);
        list.add(true);
        list.add(1,4);
        list.add(6.7);
        assertAll("getting elements",
                () -> assertEquals(9, list.get(0)),
                () -> assertEquals(true, list.get(2)),
                () -> assertEquals(6.7, list.get(3)),
                () -> assertThrows(RuntimeException.class, () -> list.get(-1)),
                () -> assertThrows(RuntimeException.class, () -> list.get(10))
                );
    }

    @Test
    @Order(8)
    @DisplayName("set an element on specified position")
    public void shouldSetElementToList(){
        OwnArrayList list = new OwnArrayList();
        list.set(0,"Jan");
        assertEquals(1,list.size());
        list.add(9);
        list.add(true);
        list.add(1,4);
        list.add(6.7);
        assertAll("setting elements",
                () -> assertEquals(5, list.size()),
                () -> assertEquals(5, list.set(1,5)),
                () -> assertThrows(RuntimeException.class, () -> list.set(10,5)),
                () -> assertThrows(RuntimeException.class, () -> list.set(-5,5))
        );
    }

    @Test
    @Order(9)
    @DisplayName("read index of specified element")
    public void shouldCheckIndexOfElement(){
        OwnArrayList list = new OwnArrayList();
        list.add(9);
        list.add(true);
        list.add(1,4);
        list.add(6);
        assertAll("get index",
                () -> assertEquals(3, list.indexOf(6)),
                () -> assertThrows(RuntimeException.class, () -> list.indexOf("Jan"))
        );
    }
}