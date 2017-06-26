package com.example.shuhaohe.cardactivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuhaohe.cardactivity.data.ConstantData;
import com.example.shuhaohe.cardactivity.util.SP;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv_name;

    private List<String> typeList = ConstantData.TYPE_LIST;
    private List<Integer> sizeList = ConstantData.Size_LIST;
    private List<Integer> colorList = ConstantData.Color_LIST;

    private SP sp;

    private ImageView iv_setting;
    private RelativeLayout rl_setting;
    private RelativeLayout rl_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        sp = SP.getSingleTonData(this, ConstantData.CARD_PATH);

        initView();
        setListener();
        askIsFly();
    }

    //设置飞行模式
    private void askIsFly() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("是否设置飞行模式？").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                startActivity(intent);
            }
        }).setNegativeButton("否", null).show();
    }

    //设置监听
    private void setListener() {

        iv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        rl_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_setting.setVisibility(View.VISIBLE);
                rl_card.setClickable(false);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rl_setting.setVisibility(View.GONE);
                                rl_card.setClickable(true);
                            }
                        });
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        int curType = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_TYPE);
        int curSize = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_SIZE);
        int curColor = sp.getSharedPreferencedInt(ConstantData.CARD_TEXT_COLOR);

        setName();
        setType(typeList.get(curType), sizeList.get(curSize), colorList.get(curColor));
    }

    //设置名字
    private void setName() {
        String name = sp.getSharedPreferencedString(ConstantData.CARD_NAME);
        tv_name.setText(name);
//        setType(list.get(0));
    }

    private void setType(String type, Integer size, Integer color) {
        tv_name.setTextSize(size);
        tv_name.setTextColor(color);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + type);
        tv_name.setTypeface(typeface);
    }

    //初始化ID
    private void initView() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        rl_setting = (RelativeLayout) findViewById(R.id.rl_setting);
        rl_card = (RelativeLayout) findViewById(R.id.rl_card);
        iv_setting = (ImageView) findViewById(R.id.iv_setting);

        rl_setting.setVisibility(View.GONE);
    }
}
