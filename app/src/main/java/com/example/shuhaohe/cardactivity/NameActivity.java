package com.example.shuhaohe.cardactivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shuhaohe.cardactivity.data.ConstantData;
import com.example.shuhaohe.cardactivity.util.SP;

/**
 * Created by shuhao.HE on 2017/6/19.
 */

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private Button btn_confirm;

    private SP sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = SP.getSingleTonData(NameActivity.this, ConstantData.CARD_PATH);
        String name = sp.getSharedPreferencedString(ConstantData.CARD_NAME);
        if(TextUtils.isEmpty(name)){
            setContentView(R.layout.activity_name);
            initView();
            setListener();
        }else{
            Intent intent=new Intent(NameActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void setListener() {
        btn_confirm.setOnClickListener(this);
    }

    private void initView() {
        et_name= (EditText) findViewById(R.id.et_name);
        btn_confirm= (Button) findViewById(R.id.btn_confirm);
    }

    @Override
    public void onClick(View view) {
                String name = et_name.getText().toString().trim();
                if(!TextUtils.isEmpty(name)){
                    SP.getSingleTonData(this,ConstantData.CARD_PATH).
                            setSharedPreferencedString(ConstantData.CARD_NAME,name);
                    Intent intent=new Intent(NameActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(this, "名字不能为空", Toast.LENGTH_SHORT).show();
                }
        }
}
