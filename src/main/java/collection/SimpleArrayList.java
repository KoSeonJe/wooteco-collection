package collection;

import java.util.Arrays;
import java.util.Objects;

public class SimpleArrayList implements SimpleList{

    private int defaultCapacity = 10;
    private String[] arrayList = new String[defaultCapacity];
    private int endPointer = 0;

    @Override
    public boolean add(String value) {
        grow();
        arrayList[endPointer] = value;
        endPointer++;
        return true;
    }

    @Override
    public void add(int index, String value) {
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
    public String set(int index, String value) {
        arrayList[index] = value;
        return arrayList[index];
    }

    @Override
    public String get(int index) {
        return arrayList[index];
    }

    // Objects.equals(temp[i], value)
    // .equals() 차이
    @Override
    public boolean contains(String value) {
        for (int i = 0; i < endPointer; i++) {
            if (Objects.equals(arrayList[i], value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
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
    public boolean remove(String value) {
        int removeIndex = indexOf(value);
        remove(removeIndex);
        return true;
    }

    @Override
    public String remove(int index) {
        String removedValue = arrayList[index];
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
            String[] copyTemp = Arrays.copyOf(arrayList, defaultCapacity);
            arrayList = copyTemp;
        }
    }
}
