package bidirectional_search;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathFinder {

    List<Person> searchBidirectional(Person source, Person destination) {

        BFSData sourceData = new BFSData(source);
        BFSData destinationData = new BFSData(destination);

        while (!sourceData.isFinished() && !destinationData.isFinished()) {
            int connection = searchLevel(sourceData, destinationData);
            if (connection != 0) {
                return mergePaths(sourceData, destinationData, connection);
            }

            connection = searchLevel(destinationData, sourceData);
            if (connection != 0) {
                return mergePaths(sourceData, destinationData, connection);
            }

        }

        return null;

    }

    private List<Person> mergePaths(BFSData sourceData, BFSData destinationData, int connection) {

        PathNode sourceEnd = sourceData.visited.get(connection);
        PathNode destinationEnd = destinationData.visited.get(connection);

        LinkedList<Person> sourcePath = sourceEnd.getPath(false);
        LinkedList<Person> destinationPath = destinationEnd.getPath(true);

        destinationPath.remove(0);
        sourcePath.addAll(destinationPath);
        return sourcePath;
    }

    int searchLevel(BFSData sourceData, BFSData destinationData) {

        int count = sourceData.toVisit.size();

        for (int i = 0; i < count; i++) {

            PathNode pathNode = sourceData.toVisit.poll();

            Person person = pathNode.person;

            if (destinationData.visited.containsKey(person.id)) {

                return person.id;
            }

            for(Person friend : person.getFriends()) {
                if (!sourceData.visited.containsKey(friend.id)) {
                    PathNode friendNode = new PathNode(friend, pathNode);
                    sourceData.visited.put(friend.id, friendNode);
                    sourceData.toVisit.addLast(friendNode);

                }
            }


        }

        return 0;
    }
}
