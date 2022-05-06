package com.leetcode.algorithm;

/**
 * @Descriotion 翻转单词顺序
 * @Date 2022/5/7 0:31
 * @Created by shiyl
 */
public class ReverseWordsInSentence {
    public String ReverseSentence(char[] chars) {
        if(chars==null || chars.length<=0)
            return String.valueOf(chars);
        //翻转整个句子
        reverseSb(chars,0,chars.length-1);
        //翻转单词（指针指向单词的第一个和最后一个）
        int start=0;
        int end=0;
        while(start<chars.length){
            while(end<chars.length && chars[end]!=' ')
                end++;
            reverseSb(chars,start,end-1);
            start=++end;
        }
        return String.valueOf(chars);
    }

    private void reverseSb(char[] chars,int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
}
