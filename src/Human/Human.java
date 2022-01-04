package Human;
//Создайте класс Human со следующими полями:
//
//name (имя, строка);
//age (возраст, число);
//weight (вес, число);
//address (адрес, строка);
//work (работа, строка).
//Создайте 5 инициализаторов (конструкторов), принимающих:
//
//name, age;
//name, address;
//name, age, weight;
//name, age, work;
//age, weight, address, work.
//Задача конструктора — создать полноценный объект (сделать его валидным). То есть, если вес неизвестен,
// то нужно указать хоть какой-нибудь средний вес, то же касается возраста и имени, а вот адреса и работы может и не быть (равны null).

public class Human {
    String name, address, work;
    int age, weight;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 60;
    }

    public Human(String name, String address) {
        this.name = name;
        this.address = address;
        this.weight = 60;
        this.age = 25;
    }

    public Human(String name, int age, int weight) {
        this(name, age);
        this.weight = weight;
    }

    public Human(String name, int age, String work) {
        this(name, age);
        this.weight = 60;
        this.work = work;
    }

    public Human(int age, int weight, String address, String work) {
        this.name = "Jhon";
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.work = work;
    }
}

}
