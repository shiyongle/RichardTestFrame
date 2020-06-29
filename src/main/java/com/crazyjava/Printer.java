package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 22:44
 * @Description:
 */
public class Printer implements Output, Product {

    private String[] printData  = new String[MAX_CACHE_LINE];

    //用以记录当前需要打印的作业数
    private int dataNum = 0;

    @Override
    public void out() {
        //只要还有作业，就继续打印
        while (dataNum > 0){
            System.out.println("打印机打印：" + printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE){
            System.out.println("输出队列已满，添加失败");
        }else {
            //把打印数据添加到队列里，已保存数据的数量加1
            printData[dataNum++] = msg;
        }
    }

    @Override
    public int getProductTime() {
        return 45;
    }

    public static void main(String[] args) {
        Output o = new Printer();
        o.getData("轻量级java ee应用实战");
        o.getData("疯狂java讲义");
        o.out();
        o.getData("疯狂android讲义");
        o.getData("疯狂ajax讲义");
        o.out();

        o.print("孙悟空","猪八戒", "白骨精");
        o.test();
        Product p = new Printer();
        System.out.println(p.getProductTime());
        Object obj = p;
    }
}
