package threadlocal;

public class Person {
    private int age;

    public Person() {
        this.age = 0;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}