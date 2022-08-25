package com.cn.Entity;

import com.cn.Inter.Fruit;

public class Apple implements Fruit {
    float applePrice;
    float appleWeight;
    @Override
    public float saleFruitPrice() {

        return applePrice;
    }

    @Override
    public float saleFruitWeight() {

        return appleWeight;
    }
    public Apple(float applePrice,float appleWeight){
        this.applePrice=applePrice;
        this.appleWeight=appleWeight;
    }
}
