package tulingxueyuan;

import java.util.HashMap;
import java.util.Map;

//爬楼梯计数，有多少中解法
public class StudyDemo {

    //斐波那契数列
    //递归的解法
    public int ClimbStairWithRecursive(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        return ClimbStairWithRecursive(n-1)+ ClimbStairWithRecursive(n-2);
    }

    private Map<Integer, Integer> storeMap=new HashMap<>();
    /*递归的解法，用HashMap存储中间计算结果*/
    public int climbStairs(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        if(null!=storeMap.get(n)){
            return storeMap.get(n);
        }else{
            int result=climbStairs(n-1)+climbStairs(n-1);
            storeMap.put(n,result);
            return result;
        }
    }
    public int climbStairC(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int pre=1;
        int prenext=2;
        int result=0;
        for(int i=3;i<n;++i){
            result=pre+prenext;
            prenext=pre;

            pre=result;
        }
        return result;
    }

}

