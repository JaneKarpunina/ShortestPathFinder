import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SearchServiceTest {

    Account root;

    Account a8;
    Account a9;

    @BeforeEach
    void createGraph() {

        root = new Account(1);

        Account a2 = new Account(2);
        Account a3 = new Account(3);
        Account a4 = new Account(4);
        Account a5 = new Account(5);

        Account a6 = new Account(6);
        Account a7 = new Account(7);

        a8 = new Account(8);
        a9 = new Account(9);

        root.setChildren(Arrays.asList(a2, a3));
        a2.setChildren(Arrays.asList(a4, a5, root));
        a3.setChildren(Arrays.asList(root, a8));

        a4.setChildren(Arrays.asList(a6, a7, a2));
        a5.setChildren(Collections.singletonList(a2));
        a6.setChildren(Collections.singletonList(a4));
        a7.setChildren(Arrays.asList(a4, a8));

        a8.setChildren(Arrays.asList(a3, a7, a9));
        a9.setChildren(Collections.singletonList(a8));

    }

    @Test
    void testShortestPathFinder() {

        checkPath(8, 3);

    }

    @Test
    void testShortestPathFinder2() {

        checkPath(9, 4);
    }

    @Test
    void testShortestPathFinder3() {

        checkPath(1, 1);
    }

    @Test
    void testSearchBidirectional() {

        SearchService searchService = new SearchService();

        List<Account> result = searchService.searchBidirectional(root, a9);

        assertEquals(4, result.size());

    }

    private void checkPath(int id, int expected) {
        SearchService searchService = new SearchService();

        List<Account> result = searchService.search(root, id);

        assertEquals(expected, result.size());
    }



  
}