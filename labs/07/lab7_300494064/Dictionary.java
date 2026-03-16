import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        if (count == elems.length) {
            increaseCapacity();
        }

        elems[count] = new Pair(key, value);
        count++;
    }

    private void increaseCapacity() {
        Pair[] newElems = new Pair[elems.length + INCREMENT];
        System.arraycopy(elems, 0, newElems, 0, count);
        elems = newElems;
    }

    @Override
    public boolean contains(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        return null;
    }

    @Override
    public void replace(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                elems[i].setValue(value);
                return;
            }
        }

        throw new NoSuchElementException("key not found: " + key);
    }

    @Override
    public Integer remove(String key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }

        for (int i = count - 1; i >= 0; i--) {
            if (elems[i].getKey().equals(key)) {
                Integer removedValue = elems[i].getValue();

                for (int j = i; j < count - 1; j++) {
                    elems[j] = elems[j + 1];
                }

                elems[count - 1] = null;
                count--;
                return removedValue;
            }
        }

        throw new NoSuchElementException("key not found: " + key);
    }

    @Override
    public String toString() {
        String res = "Dictionary: {elems = [";
        for (int i = count - 1; i >= 0; i--) {
            res += elems[i];
            if (i > 0) {
                res += ", ";
            }
        }
        return res + "]}";
    }
}
