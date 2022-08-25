package com.cn.Entity;

import com.cn.Inter.Fruit;



public class Mango implements Fruit {

    float mangoPrice;
    float mangoWeight;


    @Override
    public float saleFruitPrice() {

        return mangoPrice;
    }

    @Override
    public float saleFruitWeight() {

        return mangoWeight;
    }
    public Mango(float mangoPrice,float mangoWeight){
        this.mangoPrice=mangoPrice;
        this.mangoWeight=mangoWeight;
    }
}
