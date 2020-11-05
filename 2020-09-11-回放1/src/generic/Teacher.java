package generic;

public class Teacher {
    public String name;
    public int age;
    public int height;

    public Teacher(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
