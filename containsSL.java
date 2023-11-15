
public abstract class containsSL <T extends Comparable<T>> extends SkipList<T>{
    @Override
    public boolean contains(T value) {
        level = MAX_LEVEL;
        SkipListNode<T> current = header.forward[level];
        while(current != null) {
            level--;
            if(current.value.equals(value)) {
                return true;
            }
        }
        return false;
    }
}
