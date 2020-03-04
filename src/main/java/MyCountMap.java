import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class MyCountMap<E> implements CountMap<E> {

    private HashMap<E, Integer> map = new HashMap<>();

    public void add(E key) {
        int value = 1;
        if (map.containsKey(key)) {
            Integer oldValue = map.get(key);
            map.remove(key);
            value += oldValue;
        }
        map.put(key, value);
    }

    public int getCount(E key) {
        return map.get(key);
    }

    public int remove(E key) {
        Integer value = map.get(key);
        map.remove(key);
        return value;
    }

    public int size() {
        return map.size();
    }

    public void addAll(CountMap<? extends E> source) {
        HashMap<E, Integer> sourceMap =  (HashMap<E, Integer>) source.toMap();
        for (Map.Entry<E, Integer> entry : sourceMap.entrySet()) {
            int value = entry.getValue();
            if (map.containsKey(entry.getKey())) {
                Integer oldValue = map.get(entry.getKey());
                map.remove(entry.getKey());
                value += oldValue;
            }
            map.put(entry.getKey(), value);
        }
    }

    public Map toMap() {
        return (Map) map.clone();
    }

    public void toMap(Map destination) {
        destination = (Map) map.clone();
    }
}
