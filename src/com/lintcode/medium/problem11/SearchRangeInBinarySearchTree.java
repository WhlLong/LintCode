package com.lintcode.medium.problem11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈〉
 *
 * @author whl
 * @create 2019/2/14
 * @since 1.0.0
 */
public class SearchRangeInBinarySearchTree {

    public static void main(String[] args) {
        SearchRangeInBinarySearchTree searchTree = new SearchRangeInBinarySearchTree();
        List<Integer> result = searchTree.searchRange(null,0,10);
        System.out.println(Arrays.toString(result.toArray()));
    }


    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        mid(root,result,k1,k2);

        return result;
    }

    public void mid(TreeNode root,List<Integer> result,int k1,int k2){
        if(root ==null){
            return ;
        }
        if(root.val > k1){
            mid(root.left,result,k1,k2);
        }
        if(root.val >= k1 && root.val <= k2){
            result.add(root.val);
        }
        if(root.val < k2){
            mid(root.right,result,k1,k2);
        }

    }

}



