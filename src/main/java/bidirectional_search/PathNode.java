package bidirectional_search;

import java.util.LinkedList;
import java.util.List;

public class PathNode {

    Person person;

    PathNode previous;

    public PathNode(Person person, PathNode previous) {

        this.person = person;
        this.previous = previous;

    }

    LinkedList<Person> getPath(boolean startsWithRoot) {

        LinkedList<Person> path = new LinkedList<>();
        PathNode node = this;

        while(node != null) {

            if (startsWithRoot) {
                path.addLast(node.person);
            }
            else {
                path.addFirst(node.person);
            }

            node = node.previous;

        }

        return path;
    }
}
