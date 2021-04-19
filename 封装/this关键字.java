package javaSE.类和对象第八节.封装;
class Person{
    private String name;
    private int age;

    public Person(){
        this("调用带有一个参数的构造方法，且这个参数是String");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("调用带有一个参数的构造方法，且这个参数是String");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class this关键字 {
    int a = 10;
    public void func(){
        this.a = 99;
    }
    public static void main(String[] args) {
        this关键字 this关键字 = new this关键字();
        System.out.println(this关键字.a);
        this关键字.func();
        System.out.println(this关键字.a);
    }
}
