package Dog;
//Создать класс Dog. У собаки должны быть следующие поля:
//
//name (кличка, строка);
//age (возраст, число).
//Оба поля должны быть приватными и иметь геттеры и сеттеры.
//
//Реализуйте в классе конструктор, принимающий данные поля (name, age).
//
//Создайте метод bark() (лаять), метод должен возвращать строку woof.

public class Main {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String bark() {
        return "woof";
    }

    // name getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // age getter and setter
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}