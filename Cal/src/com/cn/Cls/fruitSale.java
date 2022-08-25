package com.cn.Cls;

import com.cn.Inter.Fruit;
import com.cn.Inter.Sale;




public class fruitSale implements Sale {

    //根据反射创建对应类的实体
    Fruit apple=Factory.getInstance("Apple");
    Fruit strawberry=Factory.getInstance("Strawberry");
    Fruit mango=Factory.getInstance("Mango");
    //如果正常销售时只销售苹果或芒果或草莓
    @Override
    public float normalSale() {
        if(apple.saleFruitWeight()>=0||strawberry.saleFruitWeight()>=0||mango.saleFruitWeight()>0){
            return apple.saleFruitWeight()*apple.saleFruitPrice()+strawberry.saleFruitPrice()*strawberry.saleFruitWeight()
                    +mango.saleFruitPrice()*mango.saleFruitWeight();
        }
        return 0.0f;
    }
    //打折销售水果
    @Override
    public float preSale() {

        float count=0;
        if(apple.saleFruitWeight()>=0||strawberry.saleFruitWeight()>=0||mango.saleFruitWeight()>0){

            count= apple.saleFruitWeight()*apple.saleFruitPrice()+strawberry.saleFruitPrice()*strawberry.saleFruitWeight()
                    +mango.saleFruitPrice()*mango.saleFruitWeight();
            return (float)0.8*count;
        }
        return 0.0f;

    }
    //明显促销水果
    @Override
    public float obPreSale() {
        //计算总金额
        float count=0;
        if(apple.saleFruitWeight()>=0||strawberry.saleFruitWeight()>=0||mango.saleFruitWeight()>0){
            count= apple.saleFruitWeight()*apple.saleFruitPrice()+strawberry.saleFruitPrice()*strawberry.saleFruitWeight()
                    +mango.saleFruitPrice()*mango.saleFruitWeight();
            if(count>=0&&count<100){
                return (float)0.8*count;
            }else if(count>100){
                return count-(count/100)*10;
            }

        }
        return 0.0f;
    }
}
