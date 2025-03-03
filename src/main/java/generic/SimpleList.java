package generic;

public interface SimpleList<T> {

    boolean add(T value);

    void add(int index, T value);

    T set(int index, T value);

    T get(int index);

    boolean contains(T value);

    int indexOf(T value);

    int size();

    boolean isEmpty();

    boolean remove(T value);

    T remove(int index);

    void clear();

    static <T> SimpleList<T> fromArrayToArrayList(T[] array) {
        SimpleList<T> simpleList = new SimpleArrayList<>();
        for (T value : array) {
            simpleList.add(value);
        }
        return simpleList;
    }

    static <N extends Number> double sum(SimpleList<N> values) {
        double number = 0;
        for (int i = 0; i < values.size(); i++) {
            number += values.get(i).doubleValue();
        }
        return number;
    }

    static <N extends Number> SimpleList<N> filterNegative(SimpleList<N> values) {
        SimpleList<N> simpleList = new SimpleArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i).doubleValue() >= 0) {
                simpleList.add(values.get(i));
            }
        }
        return simpleList;
    }

    static <N> void copy(SimpleList<? extends N> child, SimpleList<N> parent) {
        for (int i = 0; i < child.size(); i++) {
            parent.set(i, child.get(i));
        }
    }
}
