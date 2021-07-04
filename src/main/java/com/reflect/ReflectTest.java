package com.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author: Richered
 * @Date: 2021/7/5 1:14
 * @Description 反射
 * 不改变任何代码的前提下，可以帮我们创建任意类的对象，且执行其中的任意方法
     * 1、将需要创建的对象全类名和需要执行的方法定义在配置文件中
     * 2、在程序中加载读取配置文件
     * 3、使用反射技术来加载类
     * 4、创建对象
     * 5、执行方法
 */
public class ReflectTest {

    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();

        //获取目录配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();

        InputStream is = classLoader.getResourceAsStream("pro.properties");

        pro.load(is);

        //获取配置文件中定义的数据
        String className = pro.getProperty("ClassName");

        String methodName = pro.getProperty("MethodName");

        //加载该类进内存
        Class cls = Class.forName(className);

        //创建对象
        Object obj = cls.newInstance();

        //获取方法列表
        Method method = cls.getMethod(methodName);

        //执行方法
        method.invoke(obj);
    }
}
