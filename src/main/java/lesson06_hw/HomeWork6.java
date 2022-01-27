package lesson06_hw;
/*
 * Java 1. HomeWork 6
 *
 * @author Vitalii Luzhnov
 * @version 28.01.2022
 */
class HomeWork6 {
    public static void main(String[] args) {

        IAnimal[] animals = {
                new Cat("Murzik", 200, 0),
                new Dog("Polkan", 500, 10),
                new Cat("Barsik", 200, 0),
        };

        for (IAnimal animal : animals) {
            System.out.println(animal.run(150));
            System.out.println(animal.swim(3));
        }
        System.out.println("Котиков: " + Cat.count);
        System.out.println("Собачек: " + Dog.count);
        System.out.println("Всего животных: " + (Cat.count + Dog.count));
    }
}

class Cat extends Animal {
    static int count;

    Cat(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
        count++;
    }

    @Override
    public String run(int distance) {
        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
    }

    @Override
    public String swim(int distance) {
        return name + (distance > limitSwim ? " не " : " ") + "проплыл " + distance + " м";
    }
}

class Dog extends Animal {
    static int count;

    Dog(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
        count++;
    }

    @Override
    public String run(int distance) {
        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
    }

    @Override
    public String swim(int distance) {
        return name + (distance > limitSwim ? " не " : " ") + "проплыл " + distance + " м";
    }
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal {
    protected String name;
    protected int limitRun;
    protected int limitSwim;

    Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}
