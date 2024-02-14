package bidirectional_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathFinderTest {

    Person root;

    Person a8;
    Person a9;

    Person a4;

    @BeforeEach
    void createGraph() {

        root = new Person(1);

        Person a2 = new Person(2);
        Person a3 = new Person(3);
        a4 = new Person(4);
        Person a5 = new Person(5);

        Person a6 = new Person(6);
        Person a7 = new Person(7);

        a8 = new Person(8);
        a9 = new Person(9);

        root.setFriends(Arrays.asList(a2, a3));
        a2.setFriends(Arrays.asList(a4, a5, root));
        a3.setFriends(Arrays.asList(root, a8));

        a4.setFriends(Arrays.asList(a6, a7, a2));
        a5.setFriends(Collections.singletonList(a2));
        a6.setFriends(Collections.singletonList(a4));
        a7.setFriends(Arrays.asList(a4, a8));

        a8.setFriends(Arrays.asList(a3, a7, a9));
        a9.setFriends(Collections.singletonList(a8));

    }

    @Test
    void searchBidirectionalTest() {

        ShortestPathFinder shortestPathFinder = new ShortestPathFinder();

        List<Person> result = shortestPathFinder.searchBidirectional(root, a9);

        assertEquals(4, result.size());
    }

    @Test
    void searchBidirectionalTest2() {

        ShortestPathFinder shortestPathFinder = new ShortestPathFinder();

        List<Person> result = shortestPathFinder.searchBidirectional(a4, a8);

        assertEquals(3, result.size());
    }
}