/**
 * Abstract class that implements List interface and throws exception to every method that will not be implemented
 * in class OwnArrayList.
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class OwnAbstractArrayList<T> implements List<T>{

    public Object[] toArray() {
        throw new MethodNotImplementedException();
    }
    public <T1> T1[] toArray(T1[]a) {
        throw new MethodNotImplementedException();
    }
    public boolean addAll(Collection<? extends T> c) {
        throw new MethodNotImplementedException();
    }
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new MethodNotImplementedException();
    }
    public boolean removeAll(Collection<?> c) {
        throw new MethodNotImplementedException();
    }
    public boolean retainAll(Collection<?> c) {
        throw new MethodNotImplementedException();
    }
    public int lastIndexOf(Object o) {
        throw new MethodNotImplementedException();
    }
    public ListIterator<T> listIterator() {
        throw new MethodNotImplementedException();
    }
    public ListIterator<T> listIterator(int index) {
        throw new MethodNotImplementedException();
    }
    public List<T> subList(int fromIndex, int toIndex) {
        throw new MethodNotImplementedException();
    }
    public Iterator<T> iterator() {
        throw new MethodNotImplementedException();
    }
    public boolean containsAll(Collection<?> c) {
        throw new MethodNotImplementedException();
    }
}
