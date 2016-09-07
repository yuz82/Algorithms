/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, new StringBuilder());
        return res;
    }
    
    public void helper(TreeNode root, StringBuilder sb){
        if(root==null) { return; }
        if(root.left==null && root.right==null){
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(root.val); 
            res.add(tmp.toString());
            return;
        }
        if(root.left!=null){
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(root.val);
            tmp.append("->");
            helper(root.left, tmp);
        }
        if(root.right!=null){
            StringBuilder tmp = new StringBuilder(sb);
            tmp.append(root.val);
            tmp.append("->");
            helper(root.right, tmp);
        }
    }
}

//iterative
public class Solution {
    class Node{
        TreeNode node;
        String path;
        Node(TreeNode node, String path){
            this.node = node; this.path = path;
        }
    }
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null){ return res; }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(root, root.val+""));
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.node.left==null && node.node.right==null){
                res.add(node.path);
                continue;
            }
            if(node.node.left!=null){
                stack.push(new Node(node.node.left, node.path+"->"+node.node.left.val));
            }
            if(node.node.right!=null){
                stack.push(new Node(node.node.right, node.path+"->"+node.node.right.val));
            }
        }
        return res;
    }
    
}
