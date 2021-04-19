package javaSE.类和对象第八节.封装;
/*public void show(){
        System.out.println("我叫" + myName + ",今年" + myAge + "岁");
        }*/
class Student{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(){
        System.out.println("Student!!");
    }
    public Student(String name){
        System.out.println(name);
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
public class Test {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(student1);

        student1.setName("江户川柯南");
        System.out.println(student1.getName());
        System.out.println(student1);
    }
}
