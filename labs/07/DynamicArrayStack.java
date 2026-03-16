import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E> {

    private E[] elems;
    private int top;
    private static final int DEFAULT_INC = 25;

    @SuppressWarnings("unchecked")
    public DynamicArrayStack(int capacity) {
        if (capacity < DEFAULT_INC) {
            capacity = DEFAULT_INC;
        }
        elems = (E[]) new Object[capacity];
        top = 0;
    }

    public int getCapacity() {
        return elems.length;
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

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        E saved = elems[--top];
        elems[top] = null;

        if (elems.length - top >= DEFAULT_INC && elems.length - DEFAULT_INC >= DEFAULT_INC) {
            E[] newElems = (E[]) new Object[elems.length - DEFAULT_INC];
            System.arraycopy(elems, 0, newElems, 0, top);
            elems = newElems;
        }

        return saved;
    }

    @SuppressWarnings("unchecked")
    public void push(E element) {
        if (top == elems.length) {
            E[] newElems = (E[]) new Object[elems.length + DEFAULT_INC];
            System.arraycopy(elems, 0, newElems, 0, top);
            elems = newElems;
        }
        elems[top++] = element;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        elems = (E[]) new Object[DEFAULT_INC];
        top = 0;
    }
}
