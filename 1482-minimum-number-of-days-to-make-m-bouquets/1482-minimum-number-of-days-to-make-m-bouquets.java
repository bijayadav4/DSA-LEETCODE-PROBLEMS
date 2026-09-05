class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;

        if (required > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canMake(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int consecutive = 0;

        for (int day : bloomDay) {
            if (day <= days) {
                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;

                    if (bouquets == m) {
                        return true;
                    }
                }
            } else {
                consecutive = 0;
            }
        }

        return false;
    }
}