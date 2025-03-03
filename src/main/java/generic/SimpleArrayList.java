package generic;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {

    private int defaultCapacity = 10;
    private Object[] arrayList = new Object[defaultCapacity];
    private int endPointer = 0;

    @SafeVarargs // 타입 안정성 관련 어노테이션, 타입 소거 다음 주에 말해주기 이해한사람이. 이펙티브자바 제네릭 파트.
    public SimpleArrayList(T... array) {
        for (T t : array) {
            add(t);
        }
    }

    @Override
    public boolean add(T value) {
        grow();
        arrayList[endPointer] = value;
        endPointer++;
        return true;
    }

    @Override
    public void add(int index, T value) {
        if (index > endPointer) {
            throw new IndexOutOfBoundsException("범위를 넘었습니다");
        }
        endPointer += 1;
        grow();
        for (int i = index + 1; i < endPointer; i++) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = value;
    }

    @Override
    public T set(int index, T value) {
        arrayList[index] = value;
        return (T)arrayList[index];
    }

    @Override
    public T get(int index) {
        return (T)arrayList[index];
    }

    // Objects.equals(temp[i], value)
    // .equals() 차이
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < endPointer; i++) {
            if (Objects.equals(arrayList[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < endPointer; i++) {
            if (Objects.equals(arrayList[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return endPointer;
    }

    @Override
    public boolean isEmpty() {
        return endPointer == 0;
    }

    @Override
    public boolean remove(T value) {
        int removeIndex = indexOf(value);
        remove(removeIndex);
        return true;
    }

    @Override
    public T remove(int index) {
        T removedValue = (T)arrayList[index];
        for (int i = index; i < endPointer - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        endPointer -= 1;
        return removedValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < endPointer; i++) {
            arrayList[i] = null;
        }
        endPointer = 0;
    }

    private void grow() {
        if (endPointer == arrayList.length) {
            defaultCapacity += 100;
            Object[] copyTemp = Arrays.copyOf(arrayList, defaultCapacity);
            arrayList = copyTemp;
        }
    }
}
