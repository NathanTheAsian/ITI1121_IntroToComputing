import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {

    private final E[] elems;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elems[top - 1];
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E saved = elems[--top];
        elems[top] = null;
        return saved;
    }

    public void push(E element) throws FullStackException {
        if (top == elems.length) {
            throw new FullStackException("stack is full");
        }
        elems[top++] = element;
    }

    public int getCapacity() {
        return elems.length;
    }

    public void clear() {
        for (int i = 0; i < top; i++) {
            elems[i] = null;
        }
        top = 0;
    }
}
