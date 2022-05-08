package tulingxueyuan;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTree {

    public List<Integer>preOrderTest(TreeNode root){
        List<Integer>res=new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        //先打印当前节点，然后打印左子树，最后再打印右子树
        res.add(root.val);
        preOrder(root.left,res);
        preOrder(root.right,res);
    }
}
