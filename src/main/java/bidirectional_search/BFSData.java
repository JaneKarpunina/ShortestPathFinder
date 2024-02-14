package bidirectional_search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BFSData {

    Map<Integer, PathNode> visited = new HashMap<>();

    LinkedList<PathNode> toVisit = new LinkedList<>();

    public BFSData(Person person) {
        PathNode pathNode = new PathNode(person, null);
        visited.put(person.id, pathNode);
        toVisit.addLast(pathNode);
    }

    boolean isFinished() {
        return toVisit.isEmpty();
    }
}
