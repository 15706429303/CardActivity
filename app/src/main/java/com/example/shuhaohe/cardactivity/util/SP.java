package com.example.shuhaohe.cardactivity.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SP {

    private static SP singleTonToData=null;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private SP() {
    }

    public static SP getSingleTonData(Context context, String path){
        sharedPreferences=context.getSharedPreferences(path,context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        if(singleTonToData==null){
            synchronized(SP.class){
                if (singleTonToData==null){
                    singleTonToData=new SP();
                }
            }
        }
        return singleTonToData;
    }


    public void setSharedPreferencedBoolean(String string,boolean flag){
        editor.putBoolean(string,flag);
        editor.commit();
    }

    public boolean getSharedPreferencedBoolean(String string){
        return sharedPreferences.getBoolean(string,false);
    }

    public void setSharedPreferencedString(String key,String value){
        editor.putString(key,value);
        editor.commit();
    }

    public String getSharedPreferencedString(String key){
        return sharedPreferences.getString(key,"");
    }

    public void setSharedPreferencedInt(String key,int value){
        editor.putInt(key,value);
        editor.commit();
    }

    public int getSharedPreferencedInt(String key){
        return sharedPreferences.getInt(key,0);
    }

    public boolean idEmptyKey(String key){
        return sharedPreferences.contains(key);
    }

    //获取所有的键值
    public List<String>  getAllKey(){
        List<String> keyList=new ArrayList<>();
        Map<String, ?> all = sharedPreferences.getAll();
        Set<String> strings = all.keySet();
        Iterator<String> iterator=strings.iterator();
        while(iterator.hasNext()){
            keyList.add(iterator.next());
        }
        return keyList;
    }
    //删除键值
    public void removeKey(String key){
        editor.remove(key);
        editor.commit();
    }
    //清除所有的
    public void clearAll(){
        editor.clear();
        editor.commit();
    }
}
