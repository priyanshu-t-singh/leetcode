// Time Complexity: O(log(m * n))
// Space Complexity: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int outerLeft = 0, outerRight = m - 1;
        int innerLeft = 0, innerRight = n - 1;

        while (outerLeft <= outerRight) {
            int outerMid = (outerLeft + outerRight) / 2;
            if (target < matrix[outerMid][0]) {
                outerRight = outerMid - 1;
            } else if (target > matrix[outerMid][n-1]) {
                outerLeft = outerMid + 1;
            } else {
                while (innerLeft <= innerRight) {
                    int innerMid = (innerLeft + innerRight) / 2;
                    if (target == matrix[outerMid][innerMid]) {
                        return true;
                    }

                    if (target < matrix[outerMid][innerMid]) {
                        innerRight = innerMid - 1;
                    } else {
                        innerLeft = innerMid + 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
