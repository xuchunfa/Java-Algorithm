package cn.xuchunfa.puzzle;


import org.junit.Test;

/**
 * @description: 1~n中包含1的数字个数
 * 输入：13
 * 输出: 1,10,11,12,13(结果为 6因为 11包含2个1)
 * @author: Xu chunfa
 * @create: 2019-04-13 16:12
 **/
public class NumbersInclude1 {

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int counter = 0;
        for(int i = 1;i <= n;i++){
            counter += checkAndCount(i);
        }
        return counter;
    }
    public int checkAndCount(int n){
        int number = 0;
        while(n != 0){
            if(n % 10 == 1){
                number++;
            }
            n = n/10;
        }
        return number;
    }

    @Test
    public void test(){
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }
}
