package at.Dl;

public class SingletonTest {

    public static void main(String[] args) {
        Singleton singleton=new Singleton();
        Singleton singleton1=new Singleton();
        System.out.println(singleton==singleton1);

    }
}
