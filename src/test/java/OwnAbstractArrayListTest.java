/**
 * Testing method that tests if all methods implemented in OwnAbstractArrayList class throw proper Exception.
 */

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Own Abstract ArrayList class should: ")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OwnAbstractArrayListTest {
    OwnAbstractArrayList ownAbstractArrayList = Mockito.mock(
            OwnAbstractArrayList.class,
            Mockito.CALLS_REAL_METHODS
    );

    @Test
    @Order(1)
    @DisplayName("throw an exception, while trying to use method toArray()")
    void shouldCopyElementsToArrayList() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.toArray());
    }

    @Test
    @Order(2)
    @DisplayName("throw an exception, while trying to use method toArray(T[] a)")
    void shouldCopyElementsToArrayListWithSpecifiedType() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.toArray((Object[]) null));
    }

    @Test
    @Order(3)
    @DisplayName("throw an exception, while trying to use method addAll(Collection<? extends T> c)")
    void shouldAddAllElementsToArrayList() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.addAll(null));
    }

    @Test
    @Order(4)
    @DisplayName("throw an exception, while trying to use method toArray(int index, Collection<? extends T> c)")
    void shouldAddAllElementsToArrayListFromSpecifiedPosition() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.addAll(0,null));
    }

    @Test
    @Order(5)
    @DisplayName("throw an exception, while trying to use method removeAll(Collection<?> c)")
    void shouldRemoveAllElementsFromArrayList() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.removeAll(null));
    }

    @Test
    @Order(6)
    @DisplayName("throw an exception, while trying to use method retainAll(Collection<?> c)")
    void shouldRetainAllElementsFromArrayList() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.retainAll(null));
    }

    @Test
    @Order(7)
    @DisplayName("throw an exception, while trying to use method lastIndexOf(Object o)")
    void shouldFindLastIndexOfSpecifiedElement() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.lastIndexOf(null));
    }

    @Test
    @Order(8)
    @DisplayName("throw an exception, while trying to use method listIterator()")
    void shouldReturnListIteratorOverTheElements() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.listIterator());
    }

    @Test
    @Order(9)
    @DisplayName("throw an exception, while trying to use method listIterator(int index)")
    void shouldReturnListIteratorOverTheElementsFromSpecifiedPosition() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.listIterator(0));
    }

    @Test
    @Order(10)
    @DisplayName("throw an exception, while trying to use method subList(int fromIndex, int toIndex)")
    void shouldReturnSubList() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.subList(0,0));
    }

    @Test
    @Order(11)
    @DisplayName("throw an exception, while trying to use method iterator()")
    void shouldReturnIterator() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.iterator());
    }

    @Test
    @Order(12)
    @DisplayName("throw an exception, while trying to use method containsAll(Collection<?> c)")
    void shouldCheckIfArrayListContainsAllSpecifiedElements() {
        assertThrows(MethodNotImplementedException.class, () -> ownAbstractArrayList.containsAll(null));
    }
}