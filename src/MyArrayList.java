import java.util.Collection;

public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Конструктор для инициализации из другой коллекции
    public MyArrayList(Collection<? extends T> collection) {
        elements = collection.toArray();
        size = elements.length;
    }

    // Добавление элемента
    public void add(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    // Получение элемента
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    // Удаление элемента по индексу
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = get(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Îáíóëÿåì ïîñëåäíèé ýëåìåíò
        return removedElement;
    }

    // Добавление всех элементов другой коллекции
    public void addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newElements = new Object[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public int size() {
        return size;
    }

    // Метод для сортировки пузырьком с флагом
    public static <T extends Comparable<? super T>> void bubbleSort(MyArrayList<T> list) {
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.elements[j] = list.get(j + 1);
                    list.elements[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}

