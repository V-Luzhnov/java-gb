package lesson06_2;

class Animal {
    void voice() {
        System.out.println("Животное издало какой-то звук");
    }
}
class Dog extends Animal {
}

class Cat extends Animal {
    @Override
    void voice() {
        System.out.println("Кот мяукнул");
    }
}

public class AnimalsApp {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        animal.voice();
        cat.voice();
        dog.voice();
    }
}
