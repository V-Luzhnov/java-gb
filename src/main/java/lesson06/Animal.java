package lesson06;

class lesson06 {
    public static void main(String[] args) {
//        final int a = 5;

        IAnimal[] animals = {new Cat("Murzik", "black", 5), new Dog("Polkan", "white", 3)};
//        Animal[] animals = {new Cat("Murzik", "black", 5), new Dog("Polkan", "white", 3)};
//        Cat cat = new Cat("Murzik", "black", 5);
//        System.out.println(cat);
//        System.out.println(cat.voice());
//        Dog dog = new Dog("Polkan", "white", 3);

//        for (Animal animal : animals) {
        for (IAnimal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.voice());
        }
//            System.out.println(dog);
//            System.out.println(dog.voice());
    }
}

class Cat extends Animal {
    Cat(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String voice() {
        return  "meow!";
    }
}

class Dog extends Animal {
    Dog(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public String voice() {
        return  "bow-wow!";
    }
}

interface IAnimal {
    String voice();
    //методы ран и свим
}

//final class Animal {
//class Animal {
//abstract class Animal {
abstract class Animal implements  IAnimal{
    //Поля
    protected String name;
    protected String color;
    protected int age;

    //Конструктор
    Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    //инициализировать поля ограничения бега и плаванья  через конструктор при создании объекта

//    final String voice() {
//    String voice() {
//        return ("unknown voice!");
//    }
//    abstract String voice();

    @Override
    public String toString(){
        return  "Animal: " + name + ", " + color + ", " + age;
    }
}

