import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), 0, result);

        return result;
    }

    private void backtrack(
            int start,
            int k,
            int n,
            List<Integer> current,
            int sum,
            List<List<Integer>> result) {

        if (current.size() == k && sum == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (current.size() >= k || sum >= n) {
            return;
        }

        for (int i = start; i <= 9; i++) {

            current.add(i);

            backtrack(
                    i + 1,
                    k,
                    n,
                    current,
                    sum + i,
                    result
            );

            current.remove(current.size() - 1);
        }
    }
}