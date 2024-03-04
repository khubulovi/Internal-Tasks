import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;


//task6
public class StructureDeleting<T> {
        private final Map<T, Boolean> map;

        public StructureDeleting() {
            map = new LinkedHashMap<>();
        }

        public void add(T element) {
            map.put(element, true);
        }

        public void delete(T element) {
            map.remove(element);
        }

        public void printElements() {
            map.keySet().forEach(key -> System.out.print(key + " "));
            System.out.println();
        }

    }
