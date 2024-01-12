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

    List<Account> searchBidirectional(Account start, Account end) {

        if (start == null || end == null) {
            return new ArrayList<>();
        }

        if (start.equals(end)) {
            return new ArrayList<>(Collections.singletonList(start));
        }

        LinkedList<Account> accountQueue = new LinkedList<>();
        LinkedList<Account> accountQueueSecondDirection = new LinkedList<>();

        Map<Account, Account> pathMap = new HashMap<>();

        start.marked = true;

        accountQueue.offer(start);
        pathMap.put(start, null);

        end.markedSecondDirection = true;

        accountQueueSecondDirection.offer(end);
        pathMap.put(end, null);

        while(!accountQueue.isEmpty() || !accountQueueSecondDirection.isEmpty()) {

             Account accountFirst = accountQueue.poll();
             Account accountSecond = accountQueueSecondDirection.poll();

            if (accountFirst != null) {
                for (Account currentAccount : accountFirst.getChildren()) {

                    if (currentAccount != null && !currentAccount.isMarked()) {

                        if (pathMap.containsKey(currentAccount)) {
                            return findPathBidirectional(pathMap, currentAccount, accountFirst);
                        }
                        pathMap.put(currentAccount, accountFirst);
                        currentAccount.setMarked(true);
                        accountQueue.offer(currentAccount);


                    }

                }
            }
            if (accountSecond != null) {
                for (Account currentAccount : accountSecond.getChildren()) {

                    if (currentAccount != null && !currentAccount.isMarkedSecondDirection()) {

                        if (pathMap.containsKey(currentAccount)) {
                            return findPathBidirectional(pathMap, currentAccount, accountSecond);
                        }
                        currentAccount.setMarkedSecondDirection(true);
                        pathMap.put(currentAccount, accountSecond);
                        accountQueueSecondDirection.offer(currentAccount);


                    }

                }
            }


        }

        return new ArrayList<>();

    }

    private List<Account> findPathBidirectional(Map<Account, Account> pathMap,
                                                Account currentAccount, Account previousAccount) {

        LinkedList<Account> result = new LinkedList<>();
        Account previous = pathMap.get(currentAccount);

        result.add(currentAccount);

        while(previous != null) {

            result.addFirst(previous);
            previous = pathMap.get(previous);

        }

        previous = pathMap.get(previousAccount);

        result.addLast(previousAccount);

        while(previous != null) {

            result.addLast(previous);
            previous = pathMap.get(previous);

        }

        return result;
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
