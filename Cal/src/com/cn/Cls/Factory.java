package com.cn.Cls;
import com.cn.Entity.Apple;
import com.cn.Entity.Mango;
import com.cn.Entity.Strawberry;
import com.cn.Inter.Fruit;

public class Factory {

    public static Fruit getInstance(String name) {


        if (name.equals("Apple")) {
            return new Apple(1.0f, 8.0f);
        } else if (name.equals("Mango")) {
            return new Mango(2.0f, 20.0f);
        } else if (name.equals("Strawberry")) {
            return new Strawberry(2.0f, 13.0f);
        }
        return null;
    }


}
