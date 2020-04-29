package b_BigTusks.WordChain_2209_Z;

import java.util.*;

/**
 * paste code below into separate file!
 */

public class DirectedMultighraph {

    private final Map<Character, Map<String, Boolean>> vertices = new HashMap<>();
    private final Map<Character, Integer> inDegrees = new HashMap<>();
    private final Map<Character, Integer> outDegrees = new HashMap<>();
    private final List<String> trail = new ArrayList<>();

    public DirectedMultighraph(String... words) {
        Arrays.stream(words).forEach(this::addArc);
    }

    private void addArc(String arc) { // текущее слово в цикле  Arrays.stream(words).forEach(this..
        char vertexSource = arc.toLowerCase().charAt(0); // первая буква слова
        char vertexDestination = getArcDestination(arc); // последняя буква

        //  putIfAbsent() добавляет один элемент, не изменяя значение существующего элемента.
        //  возвращает значение null, если ключа не было в словаре, и старое значение,
        //  если ключ существует в словаре (при этом старое значение не заменяется новым).
        vertices.putIfAbsent(vertexSource, new HashMap<>()); // добавляем первую букву
        vertices.putIfAbsent(vertexDestination, new HashMap<>()); // последнюю букву
        // кладем в map в значение в новую внутреннюю мапу
        // т.е. на первую букву -> Map< текущее слово, и маркер в false>
        vertices.get(vertexSource).put(arc, false);

        // getOrDefault() возвращает значение элемента с указанным ключом. Если ключ не существует,
        // то метод возвращает значение, указанное во втором параметре.
        // put в Map первую букву и ставим ей в значение 0+1, а если нет и если есть прибавляем к нему +1
        outDegrees.put(vertexSource, outDegrees.getOrDefault(vertexSource, 0) + 1);

        // опять зачем-то put первую букву и значение 0
        inDegrees.putIfAbsent(vertexSource, 0);

        // put зачем-то, последн букву _ хотя мы уже сюда кидали первую wtf!?
        outDegrees.putIfAbsent(vertexDestination, 0);
        // put зачем-то, последн букву _ хотя мы уже сюда кидали первую wtf!?
        // и ставим ей в значение 0+1, а если нет и если есть прибавляем к нему +1
        inDegrees.put(vertexDestination, inDegrees.getOrDefault(vertexDestination, 0) + 1);
    }

    private char getArcDestination(String arc) {
        return arc.toLowerCase().charAt(arc.length() - 1);
    }

    private char getFirstVertex() {
        char start = 0;
        char finish = 0;
        // vertices Map содержит outDegrees Map
        for (char vertex : vertices.keySet()) { // перебираем Map внутри которой в значении Map<String, Boolean>
            // зачем-то вычитаем счетчики букв
            int diff = outDegrees.get(vertex) - inDegrees.get(vertex);
            if (diff == 1) { // и если 1
                //
                start = validateVertex(start, vertex); // присваиваем к start но прежде валидируем это
            } else if (diff == -1) {
                finish = validateVertex(finish, vertex);
            } else if (diff != 0) {
                throw new RuntimeException("Not an Eulerian graph!");
            }
        }
        if (start == 0) {
            start = vertices.keySet().iterator().next();
        }
        return start;
    }

    private char validateVertex(char current, char vertex) {
        if (current != 0) {
//            throw new RuntimeException("Not an Eulerian graph!"); // Ошибка которую выдавал код
        }
        return vertex;
    }

    public List<String> findEulerianTrail() {
        dfs(getFirstVertex());
        return this.trail;
    }

    private void dfs(char sourceVertex) {
        for (Map.Entry<String, Boolean> arc : vertices.get(sourceVertex).entrySet()) {
            boolean wordWasUsed = arc.getValue();
            if (!wordWasUsed) {
                arc.setValue(true);
                String word = arc.getKey();
                dfs(getArcDestination(word));
                trail.add(0, word);
            }
        }
    }
}
