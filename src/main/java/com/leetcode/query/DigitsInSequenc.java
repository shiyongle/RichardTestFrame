package com.leetcode.query;

/**
 * @Descriotion 数字序列中某一位的数字
 * @Date 2022/5/7 0:15
 * @Created by shiyl
 */
public class DigitsInSequenc {
    public int digitAtIndex(int index) {
        if(index<0)
            return -1;
        int m=1;  //m位数
        while(true) {
            int numbers=numbersOfIntegers(m);  //m位数的个数
            if(index<numbers*m)
                return getDigit(index,m);
            index-=numbers*m;
            m++;
        }
    }

    /*
     * 返回m位数的总个数
     * 例如，两位数一共有90个：10~99；三位数有900个：100~999
     */
    private int numbersOfIntegers(int m) {
        if(m==1)
            return 10;
        return (int) (9*Math.pow(10, m-1));
    }

    /*
     * 获取数字
     */
    private int getDigit(int index, int m) {
        int number=getFirstNumber(m)+index/m;  //对应的m位数
        int indexFromRight = m-index%m;  //在数字中的位置
        for(int i=1;i<indexFromRight;i++)
            number/=10;
        return number%10;
    }

    /*
     * 第一个m位数
     * 例如第一个两位数是10，第一个三位数是100
     */
    private int getFirstNumber(int m) {
        if(m==1)
            return 0;
        return (int) Math.pow(10, m-1);
    }

    public static void main(String[] args) {
        DigitsInSequenc demo=new DigitsInSequenc();
        System.out.println(demo.digitAtIndex(0)==0);
        System.out.println(demo.digitAtIndex(1)==1);
        System.out.println(demo.digitAtIndex(19)==4);
        System.out.println(demo.digitAtIndex(1000)==3);
        System.out.println(demo.digitAtIndex(1001)==7);
        System.out.println(demo.digitAtIndex(1002)==0);
    }
}
