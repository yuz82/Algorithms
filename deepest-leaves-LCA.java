/**
给一个tree，每个node 有很多children，
找到所有最深的nodes 的common  ancestor,
                a
     b            c          d
e         f
return b
                        a
             b          c          d 
      e    
f
return f     

                        a
             b          c          d    w
      e                 g
f                        h

return a
*/

TreeNode dfs (TreeNode root){
    if (root==null)    return new wrapper(0,null);
    wrapper left = dfs(root.left);
    wrapper right = dfs(root.right);
    if (left.height==right.height){ 
        return new wrapper(left.height+1, root);
    }else{
        if (left.height>right.height){
            return new wrapper(left.height+1, left.node);
        }else{
            return new wrapper(right.height+1, right.node);
        }
    }
}

class wrapper {
    int height;
    TreeNode node;
    public wrapper(int height, TreeNode node){
        this.height = height;
        this.node = node;
    }
}. more info on 1point3acres.com
