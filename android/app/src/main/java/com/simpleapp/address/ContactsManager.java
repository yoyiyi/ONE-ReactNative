package com.simpleapp.address;


import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ContactsManager extends ReactContextBaseJavaModule {

    public ContactsManager(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    /*绘制的列表导航字母*/
    private String words[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
    private PinyinTool pinyinTool = new PinyinTool();

    @ReactMethod
    public void getAll(Promise promise) {
        ArrayList arrayList = new ArrayList<Phone>();
        try {
            String result = new GetContactsInfo(getReactApplicationContext()).getContactInfo();
            ArrayList<Info> list = new Gson().fromJson(result, new TypeToken<ArrayList<Info>>() {
            }.getType());
            if (list != null && list.size() > 0) {
                Collections.sort(list, new Comparator<Info>() {
                    @Override
                    public int compare(Info lhs, Info rhs) {
                        String l = pinyinTool.toPinYin(lhs.getName()).substring(0, 1);
                        String r = pinyinTool.toPinYin(rhs.getName()).substring(0, 1);
                        return l.compareTo(r);
                    }
                });

                for (int j = 0; j < words.length; j++) {
                    Phone phone = new Phone();
                    phone.setPinYin(words[j]);
                    ArrayList<Info> lis = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        String first = pinyinTool.toPinYin(list.get(i).getName()).substring(0, 1);
                        if (first.equals(words[j])) {
                            lis.add(list.get(i));
                        }
                    }
                    phone.setInfo(lis);
                    arrayList.add(phone);
                }
            }

            Log.e("获取信息--", new Gson().toJson(arrayList) + "");
            promise.resolve(new Gson().toJson(arrayList));
        } catch (Exception e) {
            promise.reject("error", e);
            e.printStackTrace();
        }
    }


    @Override
    public String getName() {
        return "Contacts";
    }

    class Phone {
        private String PinYin;
        private ArrayList<Info> data;

        public String getPinYin() {
            return PinYin;
        }

        public void setPinYin(String pinYin) {
            PinYin = pinYin;
        }

        public ArrayList<Info> getInfo() {
            return data;
        }

        public void setInfo(ArrayList<Info> info) {
            this.data = info;
        }
    }

    class Info {
        private String name;
        private String phone;
        private String PinYin;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFirst() {
            return PinYin;
        }

        public void setFirst(String first) {
            this.PinYin = first;
        }
    }

}
