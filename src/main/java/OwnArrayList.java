import org.w3c.dom.ls.LSOutput;

/**
 * This class represent my own ArrayList implementation based on original ArrayList built in java.
 * It consists of methods similar to original ArrayList.
 * Abstract class that is extended OwnAbstractArrayList consists of original methods from
 * List interface, which are not implemented.
 *
 * @param <T> represents certain type of list
 */

public class OwnArrayList<T> extends OwnAbstractArrayList<T> {
    private int currentSize;
    private int numberOfElements;
    private final double UPPER_LIMIT = 0.9;
    private final double LOWER_LIMIT = 0.6;
    private final int DEFAULT_SIZE = 10;
    private Object[] arrayList;

    /**
     * Class constructor, which initialize array and sets array size to defaultSize = 10.
     */
    OwnArrayList() {
        currentSize = DEFAULT_SIZE;
        numberOfElements = 0;
        arrayList = new Object[DEFAULT_SIZE];
    }

    /**
     * Class constructor, which initialize array and sets array size to i parameter.
     * It also prevents setting i to value less or equal to 0.
     * @param i - array size
     */
    OwnArrayList(int i) {
        if (i > 0) {
            currentSize = i;
        } else {
            System.out.println("Size value should be greater than zero, so it is set to default size [10]");
            currentSize = DEFAULT_SIZE;
        }
        numberOfElements = 0;
        arrayList = new Object[currentSize];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    @Override
    public boolean contains(Object o) {
        int contains = 0;
        for (int i = 0; i < currentSize; i++) {
            if(arrayList[i] instanceof Float && o instanceof Float){
                if(Float.compare((Float)arrayList[i], (Float) o) == 0){
                    contains++;
                }
            }
            else if(arrayList[i] instanceof Double && o instanceof Double){
                if(Double.compare((Double)arrayList[i], (Double) o) == 0){
                    contains++;
                }
            }
            else if (arrayList[i] == o) {
                contains++;
            }
        }
        return contains != 0;
    }

    @Override
    public boolean add(T t) {
        if (numberOfElements <= LOWER_LIMIT * currentSize) {
            relocateArrayList();
        } else if (numberOfElements >= UPPER_LIMIT * currentSize) {
            relocateArrayList();
        }
        arrayList[numberOfElements] = t;
        numberOfElements++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            if (numberOfElements <= LOWER_LIMIT * currentSize) {
                relocateArrayList();
            } else if (numberOfElements >= UPPER_LIMIT * currentSize) {
                relocateArrayList();
            }
            int index = indexOf(o);
            for (int i = index; i < currentSize - 1; i++) {
                if (i == numberOfElements - 1) {
                    break;
                }
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[currentSize - 1] = null;
            numberOfElements--;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            arrayList[i] = null;
        }
        numberOfElements = 0;
        relocateArrayList();
    }

    @Override
    public T get(int index) {
        if(index >= 0 && index < currentSize) {
            return (T) arrayList[index];
        }
        else {
            throw new RuntimeException("Index is out of range");
        }
    }

    @Override
    public T set(int index, T element) {
        if (numberOfElements <= LOWER_LIMIT * currentSize) {
            relocateArrayList();
        } else if (numberOfElements >= UPPER_LIMIT * currentSize) {
            relocateArrayList();
        }
        if(index >= 0 && index < currentSize && index < numberOfElements) {
            arrayList[index] = element;
            return (T) arrayList[index];
        }
        else if(index >= 0 && index < currentSize){
            numberOfElements++;
            return (T) arrayList[index];
        }
        else {
            throw new RuntimeException("Index is out of range");
        }
    }

    @Override
    public void add(int index, T element) {
        if (numberOfElements <= LOWER_LIMIT * currentSize) {
            relocateArrayList();
        } else if (numberOfElements >= UPPER_LIMIT * currentSize) {
            relocateArrayList();
        }
        if (arrayList[index] != null) {
            for (int i = currentSize - 1; i > index; i--) {

                arrayList[i] = arrayList[i - 1];
            }
        }
        numberOfElements++;
        arrayList[index] = element;
    }

    @Override
    public T remove(int index) {
        if (index < numberOfElements && index >= 0) {
            if (numberOfElements <= LOWER_LIMIT * currentSize) {
                relocateArrayList();
            } else if (numberOfElements >= UPPER_LIMIT * currentSize) {
                relocateArrayList();
            }
            T object = (T) arrayList[index];
            for (int i = index; i < currentSize - 1; i++) {
                if (i == numberOfElements - 1) {
                    break;
                }
                arrayList[i] = arrayList[i + 1];
            }
            arrayList[currentSize - 1] = null;
            numberOfElements--;
            return object;
        }
        else {
            throw new RuntimeException("There is no element on the list with index " + index);
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            if(arrayList[i] instanceof Float && o instanceof Float){
                if(Float.compare((Float)arrayList[i], (Float) o) == 0){
                    index = i;
                    break;
                }
            }
            else if(arrayList[i] instanceof Double && o instanceof Double){
                if(Double.compare((Double)arrayList[i], (Double) o) == 0){
                    index = i;
                    break;
                }
            }
            else if (arrayList[i] == o) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            return index;
        }
        throw new RuntimeException("There is no " + o + " element on the list");
    }

    /**
     * Method that change size of arraylist. It is not possible to change the size directly, so this method creates
     * new ArrayList with new size, and copy values from old arraylist. It also checks if list is empty, so if it is
     * true, method ensure that size of list will be at least 1.
     */
    private void relocateArrayList() {
        int oldSize = currentSize;
        if (numberOfElements == 0) {
            currentSize = 1;
        } else {
            currentSize = (4 * numberOfElements) / 3;
            if (oldSize == currentSize) {
                currentSize++;
            }
        }
        Object[] newArrayList = new Object[currentSize];
        System.arraycopy(arrayList, 0, newArrayList, 0, numberOfElements);
        arrayList = newArrayList;
    }
}
