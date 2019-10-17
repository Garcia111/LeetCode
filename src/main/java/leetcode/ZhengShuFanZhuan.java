package leetcode;

import java.util.*;
/**
 * @author：Cheng.
 * @date：Created in 8:38 2019/8/28
 */
public class ZhengShuFanZhuan {

    //大整数范围超出
    public static int reverse(int x){
        boolean flag = x>=0 ? true: false;
        if(!flag){
            x= 0-x;
        }
        List<Integer> list = new ArrayList<>();
        do{
            list.add(x%10);
            x= x/10;
        }while(x%10 != x);
        if(x!=0){
            list.add(x);
        }
        int result = 0;
        for(int i= 0;i<list.size();i++){
            result = result*10+(Integer) list.get(i);
        }
        return flag==true?result:(0-result);

    }
    //我们可以一次构建反转整数的一位数字，在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会
    //导致溢出。

    public static void main(String[] args){
        System.out.println(reverse(102));
    }

}
