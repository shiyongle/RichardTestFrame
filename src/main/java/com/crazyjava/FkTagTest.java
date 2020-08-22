package com.crazyjava;

/**
 * @Author: Richered
 * @Date: 2020/08/22 19:04
 * @Description:
 **/
//@FKTag(age = 5)
@FKTag(name = "疯狂java", age = 9)
public class FkTagTest {

    public static void main(String[] args) {
        Class<FkTagTest> clazz = FkTagTest.class;
        FKTag[] tags = clazz.getDeclaredAnnotationsByType(FKTag.class);
        for (FKTag tag :tags){
            System.out.println(tag.name() + "-->" + tag.age());
        }

        FKTags container = clazz.getDeclaredAnnotation(FKTags.class);

        System.out.println(container);
    }
}
