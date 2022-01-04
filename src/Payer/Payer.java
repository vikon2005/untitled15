package Payer;
//Опишите класс Payer. В классе должны быть следующие поля:
//
//surname (фамилия, строка);
//name (имя, строка);
//address (адрес, строка);
//cardNumber (номер карты).
//Реализуйте конструктор, принимающий эти параметры (surname, name, address, cardNumber) и метод public toString(), возвращающий строку вида Payer: surname name, address: address, card: cardNumber.

public class Payer {
    String surname;
    String name;
    String adress;
    String cardNumber;

    public Payer(String surname, String name, String adress, String cardNumber) {
        this.surname = surname;
        this.name = name;
        this.adress = adress;
        this.cardNumber = cardNumber;

    }

    public Payer() {
            }

    public String toString() {
        return "Payer:" +surname+" "+name+" "+adress+", card:" +cardNumber;

    }
}