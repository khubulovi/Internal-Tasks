import java.util.*;


//task6
public class StructureDeleting<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private final int capacity;
    private final Map<Integer, List<T>> table;

    public StructureDeleting() {
        this(DEFAULT_CAPACITY);
    }

    public StructureDeleting(int capacity) {
        this.capacity = capacity;
        this.table = new HashMap<>(capacity);
    }

    private int hash(T element) {
        return element.hashCode() % capacity;
    }

    public void add(T element) {
        int index = hash(element);
        table.computeIfAbsent(index, k -> new ArrayList<>()).add(element);
    }

    public void remove(T element) {
        int index = hash(element);
        List<T> list = table.get(index);
        if (list != null) {
            list.remove(element);
            if (list.isEmpty()) {
                table.remove(index);
            }
        }
    }
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        for (List<T> list : table.values()) {
            result.addAll(list);
        }
        return result;
    }
}
