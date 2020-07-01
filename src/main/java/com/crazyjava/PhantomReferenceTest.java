package com.crazyjava;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author: Richered
 * @Date: 2020/7/1 21:07
 * @Description:
 */
public class PhantomReferenceTest {
    public static void main(String[] args) throws Exception{
        //创建一个字符串对象
        String str = new String("疯狂java讲义");

        //创建一个引用队列
        ReferenceQueue rq = new ReferenceQueue();

        //创建一个虚引用，让此虚引用引用到上方的字符串
        PhantomReference pr = new PhantomReference(str, rq);

        //切断str与字符串的联系
        str = null;

        //取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以此处输出为null
        System.out.println(pr.get());

        //强制垃圾回收
        System.gc();
        System.runFinalization();

        //垃圾回收之后，虚引用将被放入引用队列中
        //取出引用队列中最先进入队列的引用与pr比较
        System.out.println(rq.poll() == pr);
    }
}
