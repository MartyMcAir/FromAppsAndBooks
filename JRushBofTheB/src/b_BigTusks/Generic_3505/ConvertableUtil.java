package b_BigTusks.Generic_3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap<>();
        for (V v : list) {
            result.put(v.getKey(), v);
        }
        return result;
    }

    // прошло проверку
    public static <K, V extends Convertable> Map convert3(List<V> list) {
        Map result = new HashMap();
        // code here
        for (int i = 0; i < list.size(); i++) {
            Convertable convertable = list.get(i);
//            ConvertableUser o = (ConvertableUser) list.get(i);
            result.put(convertable.getKey(), convertable);
        }
        return result;
    }

    public static Map convert2(List<? extends Convertable> list) {
        Map result = new HashMap();
        // code here
        for (int i = 0; i < list.size(); i++) {
            Convertable convertable = list.get(i); // тут попутал местами ключ со значением
//            ConvertableUser o = (ConvertableUser) list.get(i);
            result.put(convertable, convertable.getKey());
        }
        return result;
    }
}
