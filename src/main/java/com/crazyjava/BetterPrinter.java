package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/30 15:45
 * Description:
 */
public class BetterPrinter implements Output {

    private String[] printData  = new String[MAX_CACHE_LINE * 2];

    //用于记录当前需要打印的作业数
    private int dataNum = 0;

    @Override
    public void out() {
        //只要有作业就继续打印
        while (dataNum > 0){
            System.out.println("高速打印机正在打印：" + printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE * 2){
            System.out.println("输出队列已满,添加失败");
        }else {
            //把打印数据添加到队列里边，已保存数据的数量加1
            printData[dataNum++] = msg;
        }
    }
}
