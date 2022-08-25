package com.cn.Entity;

import com.cn.Inter.Fruit;



public class Strawberry implements Fruit {

    float strawberryPrice;
    float strawberryWeight;


    @Override
    public float saleFruitPrice() {

        return strawberryPrice;
    }

    @Override
    public float saleFruitWeight() {

        return strawberryWeight;
    }
    public Strawberry(float strawberryPrice,float strawberryWeight){
        this.strawberryPrice=strawberryPrice;
        this.strawberryWeight=strawberryWeight;
    }
}
