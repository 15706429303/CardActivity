package com.example.shuhaohe.cardactivity.data;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhao.HE on 2017/6/19.
 */

public class ConstantData {
    public static  final String FIRST_START="FIRST_START";

    public static final String CARD_PATH="CARD_PATH";
    public static final String CARD_NAME="CARD_NAME";

    public static final String  CARD_TEXT_TYPE="CARD_TEXT_TYPE";
    public static final String  CARD_TEXT_PRE_TYPE="CARD_TEXT_PRE_TYPE";

    public static final String  CARD_TEXT_SIZE="CARD_TEXT_SIZE";
    public static final String  CARD_TEXT_PRE_SIZE="CARD_TEXT_PRE_SIZE";

    public static final String  CARD_TEXT_COLOR="CARD_TEXT_COLOR";
    public static final String  CARD_TEXT_PRE_COLOR="CARD_TEXT_PRE_COLOR";


    public static final List<String> TYPE_LIST=new ArrayList<>();
    static {
        TYPE_LIST.add("仿宋.ttf");
        TYPE_LIST.add("仿宋gb.ttf");
        TYPE_LIST.add("楷体.ttf");
        TYPE_LIST.add("楷体gb.ttf");
        TYPE_LIST.add("Msyh.ttf");
    }

    public static final List<Integer> Size_LIST=new ArrayList<>();
    static {
        Size_LIST.add(200);
        Size_LIST.add(180);
        Size_LIST.add(160);
    }

    public static final List<Integer> Color_LIST=new ArrayList<>();
    static {
        Color_LIST.add(Color.BLACK);
        Color_LIST.add(Color.BLUE);
        Color_LIST.add(Color.RED);
        Color_LIST.add(Color.GREEN);
        Color_LIST.add(Color.YELLOW);
    }

}
