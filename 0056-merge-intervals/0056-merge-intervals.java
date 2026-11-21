class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] current : intervals) {
            if (result.isEmpty()) {
                result.add(current);
            }
            else {
                int[] previous = result.get(result.size() - 1);

                if (current[0] <= previous[1]) {
                    previous[1] = Math.max(previous[1], current[1]);

                } else {
                    result.add(current);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
