package com.leetcode.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 记票统计
 */
public class TicketCounting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            //初始化
            int numOfCandidates = in.nextInt();
            in.nextLine();//指针移到下一行开头
            String[] nameOfCandidates = in.nextLine().split(" ");
            int numOfVotes = in.nextInt();
            in.nextLine();//指针移到下一行开头
            String[] voteFor = in.nextLine().split(" ");
            Map<String,Integer> dict = new HashMap<>();
            int invalid = 0;
            for(int i = 0; i < numOfCandidates; i++){
                dict.put(nameOfCandidates[i],0);
            }
            //计数
            for(int j = 0; j < numOfVotes; j++){
                if(!dict.containsKey(voteFor[j])){
                    invalid++;
                }
                else{
                    Integer pre = dict.get(voteFor[j]);
                    dict.put(voteFor[j],pre + 1);
                }
            }
            //输出结果
            StringBuilder res = new StringBuilder();
            for(String s : nameOfCandidates){
                res.append(s);
                res.append(" : ");
                res.append(dict.get(s));
                res.append("\n");
            }
            res.append("Invalid : ");
            res.append(invalid);
            System.out.println(res);
        }
    }
}
