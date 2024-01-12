import java.util.*;

public class SearchService {

    List<Account> search(Account start, Integer id) {

        LinkedList<Account> accountQueue = new LinkedList<>();

        Map<Account, Account> pathMap = new HashMap<>();

        start.marked = true;

        accountQueue.offer(start);
        pathMap.put(start, null);

        while(!accountQueue.isEmpty()) {

            Account account = accountQueue.poll();

            if (account.getId().equals(id)) {
                return findPath(pathMap, account);
            }

            for (Account currentAccount : account.getChildren()) {

                if (!currentAccount.marked) {
                    currentAccount.setMarked(true);
                    pathMap.put(currentAccount, account);
                    accountQueue.offer(currentAccount);


                }

            }


        }

        return new ArrayList<>();

    }

    private List<Account> findPath(Map<Account, Account> pathMap, Account account) {

        List<Account> result = new ArrayList<>();
        Account previous = pathMap.get(account);

        result.add(account);

        while(previous != null) {

          result.add(previous);
          previous = pathMap.get(previous);

        }

        return result;
    }


}
