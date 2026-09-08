class Solution {
    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;

            int count = 0;

            for (int i = 0; i < n; i++) {
                count += upperBound(matrix[i], mid);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int upperBound(int[] row, int target) {

        int left = 0;
        int right = row.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (row[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}