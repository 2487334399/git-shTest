package tulingxueyuan;

import java.util.ArrayList;
import java.util.List;

public class InOrder {

    public List<Integer> inorderTest(TreeNode root){
        List<Integer>res=new ArrayList<>();
        inOrder(root,res);
        return res;
    }
    public void inOrder(TreeNode root,List<Integer>res){
        if(root==null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
}
