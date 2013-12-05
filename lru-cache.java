import java.util.LinkedHashMap;

public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache =
        new LinkedHashMap<Integer, Integer>(16, 0.75f, true);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer result = cache.get(key);
        return result == null ? -1 : result;
    }
    
    public void set(int key, int value) {
        if (capacity <= 0) return;
        if (cache.size() < capacity || cache.containsKey(key)) {
            cache.put(key, value);
        } else if (capacity > 0) {
            // Remove least recently accessed.
            Iterator<Integer> it = cache.keySet().iterator();
            it.next();
            it.remove();
            cache.put(key, value);
        }
    }
}
