package com.leetcode.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 24点运算
 */
public class twelvePM {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //用于初步读取String储存
        LinkedList<String> list1 = new LinkedList<>();
        //用于将String转化成int储存
        LinkedList<Integer> list = new LinkedList<>();
        //用于还原：（1->A; 13->K）
        LinkedList<String> list2 = new LinkedList<>();

        list2.add("0");
        list2.add("A");
        for (int i = 2; i <= 10; i++){
            list2.add(Integer.toString(i));
        }
        list2.add("J");
        list2.add("Q");
        list2.add("K");
        //读取String：
        while (sc.hasNext()){
            list1.add(sc.next());
        }
        int flag = 0;
        //转换成Integer：//遇到JOKER 直接输出ERROR
        for (int i = 0; i < 4 ; i++){
            String cur = list1.get(i);
            if (cur.equals("JOKER") || cur.equals("joker")){
                System.out.println("ERROR");
                flag = -1;
                break;
            }else if (cur.equals("A")){
                list.add(1);
            }else if (cur.equals("K")){
                list.add(13);
            }else if (cur.equals("Q")){
                list.add(12);
            }else if (cur.equals("J")){
                list.add(11);
            }else{
                list.add(Integer.valueOf(cur));
            }
        }
        //暴力遍历四个数的排列组合：
        if (flag == 0){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (j == i) continue;
                    if(flag == 1) break;
                    for (int k = 0; k < 4; k++){
                        if (k == i || k == j) continue;
                        if(flag == 1) break;
                        for (int p = 0; p < 4; p++){
                            if (p == i || p == j || p == k) continue;
                            if(flag == 1) break;
                            //将四个数给如helper function做判断：
                            String out = helper(list.get(i), list.get(j), list.get(k),list.get(p));
                            //输出非NONE，生成答案：
                            if (!out.equals("NONE")){
                                String res = "";
                                res += list2.get(list.get(i));
                                res += out.substring(0,1);
                                res += list2.get(list.get(j));
                                res += out.substring(1,2);
                                res += list2.get(list.get(k));
                                res += out.substring(2,3);
                                res += list2.get(list.get(p));
                                System.out.println(res);
                                flag = 1;
                            }
                        }
                    }
                }
            }
            //helepr function输出为NONE输出NONE：
            if (flag == 0) System.out.println("NONE");
        }
    }
    //类似于2-sum --> 3-sum -->4-sum思路：
    static public String helper(int a, int b){
        if (a * b == 24) return "*";
        else if (a + b == 24) return "+";
        else if (b != 0 && a % b == 0 && a / b == 24) return "/";
        else if (a - b == 24) return "-";
        else return "NONE";
    }
    //重载
    static public String helper(int a, int b, int c){
        if (!helper(a * b, c).equals("NONE")) return "*" + helper(a * b, c);
        else if (!helper(a + b, c).equals("NONE")) return "+" + helper(a + b, c);
        else if (!helper(a - b, c).equals("NONE")) return "-" + helper(a - b, c);
        else if (b != 0 && a % b == 0 && !helper(a / b, c).equals("NONE")) return "/" + helper(a * b, c);
        else return "NONE";
    }
    //重载：输出的是三个有序运算符号
    static public String helper(int a, int b, int c, int d){
        if (!helper(a * b, c, d).equals("NONE")) return "*" + helper(a * b, c, d);
        else if (!helper(a + b, c, d).equals("NONE")) return "+" + helper(a + b, c, d);
        else if (!helper(a - b, c, d).equals("NONE")) return "-" + helper(a - b, c, d);
        else if (b != 0 && a % b == 0 && !helper(a / b, c, d).equals("NONE")) return "/" + helper(a * b, c, d);
        else return "NONE";
    }
}
