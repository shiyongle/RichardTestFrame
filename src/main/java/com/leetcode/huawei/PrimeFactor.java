package com.leetcode.huawei;


import java.util.Scanner;

/**
 * @Descriotion 质数因子:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * @Date 2022/5/9 14:47
 * @Created by shiyl
 */
public class PrimeFactor {
    public static void main(String[] args) {
        // 处理输入
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            // 获取需要求解的值
            int target = sc.nextInt();
            int y = 2;// 因子从2开始算
            while(target != 1){ // 短除法，除到目标值为1为止
                if(target % y == 0) // 能能够整除2
                {
                    System.out.print(y+" ");
                    target /= y;
                }else{// 更新y的值
                    if(y > target / y) y = target;//如果剩余值为质数
                    else y++;  //y值增加1
                }
            }
        }
    }
}
