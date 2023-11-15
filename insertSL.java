import java.util.Random;

/**
 * 
 * @author Vivek Reddy Bhimavarapu
 *
 * @param <T>
 */

public abstract class insertSL<T extends Comparable<T>> extends SkipList<T> {

    public insertSL() {
        super();
    }

    @Override
    public void insert(T value) {
        int newLevel = randomLevel();
        SkipListNode<T> newNode = new SkipListNode<>(value, newLevel);
        SkipListNode<T>[] update = new SkipListNode[newLevel + 1];
        SkipListNode<T> current = getHeader();

        for (int i = getLevel() - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value.compareTo(value) < 0) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }

        if (newLevel > getLevel()) {
            setLevel(newLevel);
        }
    }

    private int randomLevel() {
        int newLevel = 1;
        Random random = new Random();
        while (random.nextDouble() < 0.5 && newLevel < getLevel()) {
            newLevel++;
        }
        return newLevel;
    }
}
