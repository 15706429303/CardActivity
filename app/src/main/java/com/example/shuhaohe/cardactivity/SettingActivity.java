package com.example.shuhaohe.cardactivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuhaohe.cardactivity.data.ConstantData;
import com.example.shuhaohe.cardactivity.util.SP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuhao.HE on 2017/6/19.
 */

public class SettingActivity extends AppCompatActivity {

    private TextView tv_00, tv_01, tv_02, tv_03, tv_04;
    private TextView tv_10, tv_11, tv_12, tv_13, tv_14;
    private TextView tv_small, tv_medium, tv_big;

    private List<TextView> typeList = new ArrayList<>();
    private List<TextView> sizeList = new ArrayList<>();
    private List<TextView> colorList = new ArrayList<>();

    private Button btn_confirm;
    private Button btn_cancel;

    private SP sp;

    private int preType = 0;
    private int preSize = 0;
    private int preColor = 0;

    private int curType = 0;
    private int curSize = 0;
    private int curColor = 0;

    //修改姓名
    private TextView tv_name;
    private EditText et_name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        sp = SP.getSingleTonData(this, ConstantData.CARD_PATH);

        initView();
        initData();
        setListener();
        initSetting();
        initName();
    }

    //修改姓名
    private void initName() {
        tv_name.setText("当前姓名:" + sp.getSharedPreferencedString(ConstantData.CARD_NAME));
    }

    private void initData() {
        typeList.add(tv_00);
        typeList.add(tv_01);
        typeList.add(tv_02);
        typeList.add(tv_03);
        typeList.add(tv_04);

        sizeList.add(tv_big);
        sizeList.add(tv_medium);
        sizeList.add(tv_small);

        colorList.add(tv_10);
        colorList.add(tv_11);
        colorList.add(tv_12);
        colorList.add(tv_13);
        colorList.add(tv_14);
    }

    //初始化ID
    private void initView() {
        //type
        tv_00 = (TextView) findViewById(R.id.tv_00);
        tv_01 = (TextView) findViewById(R.id.tv_01);
        tv_02 = (TextView) findViewById(R.id.tv_02);
        tv_03 = (TextView) findViewById(R.id.tv_03);
        tv_04 = (TextView) findViewById(R.id.tv_04);
        //color
        tv_10 = (TextView) findViewById(R.id.tv_10);
        tv_11 = (TextView) findViewById(R.id.tv_11);
        tv_12 = (TextView) findViewById(R.id.tv_12);
        tv_13 = (TextView) findViewById(R.id.tv_13);
        tv_14 = (TextView) findViewById(R.id.tv_14);
        //size
        tv_small = (TextView) findViewById(R.id.tv_small);
        tv_medium = (TextView) findViewById(R.id.tv_medium);
        tv_big = (TextView) findViewById(R.id.tv_big);
        //button
        btn_confirm = (Button) findViewById(R.id.btn_confirm);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        //name
        tv_name = (TextView) findViewById(R.id.tv_name);
        et_name = (EditText) findViewById(R.id.et_name);
    }

    //监听事件
    private void setListener() {
        tv_00.setOnClickListener(new TextTypeListener());
        tv_01.setOnClickListener(new TextTypeListener());
        tv_02.setOnClickListener(new TextTypeListener());
        tv_03.setOnClickListener(new TextTypeListener());
        tv_04.setOnClickListener(new TextTypeListener());

        tv_big.setOnClickListener(new TextSizeListener());
        tv_medium.setOnClickListener(new TextSizeListener());
        tv_small.setOnClickListener(new TextSizeListener());

        tv_10.setOnClickListener(new TextColorListener());
        tv_11.setOnClickListener(new TextColorListener());
        tv_12.setOnClickListener(new TextColorListener());
        tv_13.setOnClickListener(new TextColorListener());
        tv_14.setOnClickListener(new TextColorListener());

        btn_confirm.setOnClickListener(new ButtonListener());
        btn_cancel.setOnClickListener(new ButtonListener());
    }

    //初始化设置
    private void initSetting() {
        curType = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_TYPE);
        preType = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_TYPE);
        setTypeStateColor(curType, preType);

        curSize = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_SIZE);
        preSize = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_SIZE);
        setSizeStateColor(curSize, preSize);

        curColor = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_COLOR);
        preColor = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_COLOR);
        setColorStateColor(curColor, preColor);
    }

    //type点击回调
    public class TextTypeListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_00:
                    setTypeStateColor(0, preType);
                    break;
                case R.id.tv_01:
                    setTypeStateColor(1, preType);
                    break;
                case R.id.tv_02:
                    setTypeStateColor(2, preType);
                    break;
                case R.id.tv_03:
                    setTypeStateColor(3, preType);
                    break;
                case R.id.tv_04:
                    setTypeStateColor(4, preType);
                    break;
            }
        }
    }

    //size点击回调
    public class TextSizeListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_big:
                    setSizeStateColor(0, preSize);
                    break;
                case R.id.tv_medium:
                    setSizeStateColor(1, preSize);
                    break;
                case R.id.tv_small:
                    setSizeStateColor(2, preSize);
                    break;
            }
        }
    }

    //size点击回调
    public class TextColorListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_10:
                    setColorStateColor(0, preColor);
                    break;
                case R.id.tv_11:
                    setColorStateColor(1, preColor);
                    break;
                case R.id.tv_12:
                    setColorStateColor(2, preColor);
                    break;
                case R.id.tv_13:
                    setColorStateColor(3, preColor);
                    break;
                case R.id.tv_14:
                    setColorStateColor(4, preColor);
                    break;
            }
        }
    }

    //设置type选中状态
    private void setTypeStateColor(int cur, int pre) {
        curType = cur;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_TYPE, cur);

        typeList.get(pre).setBackgroundResource(R.drawable.shape_background_blue);
        typeList.get(pre).setTextColor(Color.BLACK);
        typeList.get(cur).setBackgroundResource(R.drawable.shape_background_red);
        typeList.get(cur).setTextColor(Color.WHITE);

        preType = curType;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_TYPE, preType);
    }

    //设置size选中状态
    private void setSizeStateColor(int cur, int pre) {
        curSize = cur;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_SIZE, cur);

        sizeList.get(pre).setBackgroundResource(R.drawable.shape_background_blue);
        sizeList.get(pre).setTextColor(Color.BLACK);
        sizeList.get(cur).setBackgroundResource(R.drawable.shape_background_red);
        sizeList.get(cur).setTextColor(Color.WHITE);

        preSize = curSize;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_SIZE, preSize);
    }

    //color选中状态
    private void setColorStateColor(int cur, int pre) {
        curColor = cur;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_COLOR, cur);

        colorList.get(pre).setBackgroundResource(R.drawable.shape_background_blue);
        colorList.get(pre).setTextColor(Color.BLACK);
        colorList.get(cur).setBackgroundResource(R.drawable.shape_background_red);
        colorList.get(cur).setTextColor(Color.WHITE);

        preColor = curColor;
        sp.setSharedPreferencedInt(ConstantData.CARD_TEXT_PRE_COLOR, preColor);
    }

    public class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_confirm:
                    String name = et_name.getText().toString().trim();
                    if (!TextUtils.isEmpty(name)) {
                        sp.setSharedPreferencedString(ConstantData.CARD_NAME, name);
                    }
                    finish();
                    break;
                case R.id.btn_cancel:
                    setTypeStateColor(0, preType);
                    setSizeStateColor(0, preSize);
                    setColorStateColor(0, preColor);
                    break;
            }
        }
    }

}
