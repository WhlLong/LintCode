package com.lintcode.easy.problem28;

public class SearchA2DMatrix2 {


    public static void main(String[] args) {

        int[][] matrix = {{1, 3, 5,7}, {10,11,16,20}, {23,30,34,50}};
        int target = 7;

        SearchA2DMatrix2 searchA2DMatrix = new SearchA2DMatrix2();
        boolean result = searchA2DMatrix.searchMatrix(matrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target) {
                int pos = binarySearch(matrix[i], 0, matrix[i].length - 1, target);
                if (pos != -1) {
                    return true;
                }
            }
        }




        return false;
    }

    public int binarySearch(int[] arr, int start, int end, int target) {

        int i = start;
        int j = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] == target) {
                return mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

}
