import java.util.Collection;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public MyLinkedList() {}

    // Конструктор для инициализации из другой коллекции
    public MyLinkedList(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    // Добавление элемента
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Получение элемента по индексу
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Удаление элемента по индексу
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        Node<T> previous = null;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next;
        }

        if (current == tail) {
            tail = previous;
        }

        size--;
        return current.data;
    }

    // Добавление всех элементов другой коллекции
    public void addAll(Collection<? extends T> collection) {
        for (T element : collection) {
            add(element);
        }
    }

    public int size() {
        return size;
    }

    // Метод для сортировки пузырьком с флагом
    public static <T extends Comparable<? super T>> void bubbleSort(MyLinkedList<T> list) {
        boolean swapped;
        for (int i = 0; i < list.size() - 1; i++) {
            swapped = false;
            Node<T> current = list.head;
            Node<T> next = list.head.next;

            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (current.data.compareTo(next.data) > 0) {
                    T temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                    swapped = true;
                }
                current = next;
                next = next.next;
            }
            if (!swapped) break;
        }
    }
}
