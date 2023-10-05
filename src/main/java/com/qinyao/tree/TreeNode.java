package com.qinyao.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TreeNode
 * @Description
 * @Version 1.0.0
 * @Author LinQi
 * @Date 2023/09/14
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    List<Integer> simpleLevelOrder (TreeNode root){
        if(root == null){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        // 将根节点放入队列中，然后不断遍历序列
        queue.add(root);
        // 有多少元素就执行多少次
        while(queue.size() > 0){
            // 获取当前队列的长度，这个长度相当于当前这一层的节点个数
            TreeNode t = queue.remove();
            res.add(t.val);
            if(t.left != null){
                queue.add(t.left);
            }
            if(t.right != null){
                queue.add(t.right);
            }
        }
        return  res;
    }
}
