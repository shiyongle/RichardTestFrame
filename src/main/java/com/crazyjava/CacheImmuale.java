package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/6/29 21:22
 * @Description:
 */
public class CacheImmuale {
    private static int MAX_SIZE = 10;

    //使用数组来缓存已有的实例
    private static CacheImmuale[] cache = new CacheImmuale[MAX_SIZE];

    //记录缓存实例在缓存中的位置，cache[pos-1]是最新缓存的实例
    private static int pos = 0;

    private final String name;

    private CacheImmuale(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static CacheImmuale valueOf(String name){
        //遍历已缓存的对象
        for (int i = 0; i < MAX_SIZE; i ++){
            if(cache[i] != null && cache[i].getName().equals(name)){
                return cache[i];
            }
        }
        //如果缓存池已满
        if (pos == MAX_SIZE){
            //把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始位置
            cache[0] = new CacheImmuale(name);
            //把pos设置为1
            pos = 1;
        }else {
            //把新建的对象缓存起来，pos+1
            cache[pos++] = new CacheImmuale(name);
        }
        return cache[pos -1];
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == CacheImmuale.class){
            CacheImmuale ci = (CacheImmuale) obj;
            return name.equals(ci.getName());
        }
        return false;
    }

    public int hashCode(){
        return name.hashCode();
    }
}
