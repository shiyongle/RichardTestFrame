package com.crazyjava;


import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Richered
 * @Date: 2020/7/12 17:17
 * @Description: 梭哈游戏
 */
public class ShowHand {

    /**定义该游戏最多支持多少玩家**/
    private final int PLAY_NUM = 5;

    /**定义扑克牌的所有花色和数值**/
    private String[] types = {"方块", "草花", "红心", "黑桃"};

    private String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    /**cards 是一局游戏中剩下的扑克牌**/
    private List<String> cards = new LinkedList<>();

    /**定义所有玩家**/
    private String[] players = new String[PLAY_NUM];

    /**定义所有玩家手上的扑克牌**/
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 初始化扑克牌,放入52张扑克牌
     * 并且使用shuffle方法将它们随机排列
     */
    public void initCards(){
        for (int i = 0; i < types.length; i ++){
            for (int j = 0; j < values.length; j ++){
                cards.add(types[i] + values[j]);
            }
        }
        //随机
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家
     * @param names
     */
    public void initPlayer(String... names){
        if (names.length > PLAY_NUM || names.length < 2){
            //校验玩家数量
            System.out.println("玩家数量不对");
            return;
        }else {
            for (int i = 0; i < names.length; i++){
                players[i] = names[i];
            }
        }
    }

    /**
     * 初始化玩家手上的扑克牌，开始游戏的时候手上的扑克牌为空
     * 程序初始长度为0的LinkedList表示
     */
    public void initPlayCards(){
        for (int i = 0; i < players.length; i++){
            if (players[i] != null && !players[i].equals("")){
                playersCards[i] = new LinkedList<String>();
            }
        }
    }

    /**
     * 输出全部扑克牌仅做测试
     */
    public void showAllCards(){
        for (String card : cards){
            System.out.println(card);
        }
    }

    /**
     * 发牌
     * @param first
     */
    public void deliverCard(String first){
        /**
         * 调用ArrayUtils的search方法，下方调用了indexof方法，就是返回一个object在数组中的位置
         * 查询出指定元素在数组中的索引
         */
        int firstPos = ArrayUtils.indexOf(players, first);

        //依次给位于该指定玩家之后的每个玩家发牌
        for (int i = firstPos; i < PLAY_NUM; i++){
            if (players[i] != null){
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
        //依次给位于该指定玩家之前的每个玩家发牌
        for (int i = 0; i < firstPos; i++){
            if (players[i] != null){
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }

    /**
     * 输出玩家手上的扑克牌
     */
    public void showPlayCards(){
        for (int i = 0; i < PLAY_NUM; i++){
            if (players[i] != null){
                System.out.println(players[i] + ": ");
                for (String card : playersCards[i]){
                    System.out.println(card + "\t");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        ShowHand sh = new ShowHand();
        sh.initPlayer("电脑玩家", "孙悟空");
        sh.initCards();
        sh.initPlayCards();

        sh.showAllCards();
        System.out.println("------正式发牌--------");

        sh.deliverCard("孙悟空");
        sh.showPlayCards();


        sh.deliverCard("电脑玩家");
        sh.showPlayCards();
    }
}
