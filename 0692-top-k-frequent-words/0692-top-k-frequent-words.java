
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(
            (a, b) -> {
                if (map.get(a).equals(map.get(b))) {
                    return a.compareTo(b);
                }

                return map.get(b) - map.get(a);
            }
        );

        for (String word : map.keySet()) {
            pq.offer(word);
        }
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        return result;
    }
}
