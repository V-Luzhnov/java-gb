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
//                new Cat("Murzik", 200, 0),
//                new Dog("Polkan", 500, 10),
//                new Cat("Barsik", 200, 0)
                new Cat("Murzik", 200),
                new Dog("Polkan", 500, 10),
                new Cat("Barsik", 200)
        };

        for (IAnimal animal : animals) {
            System.out.println(animal.run(150));
            System.out.println(animal.swim(3));
        }
        //Luzhnov 28.01.2022 +
//        System.out.println("Котиков: " + Cat.count);
//        System.out.println("Собачек: " + Dog.count);
//        System.out.println("Всего животных: " + (Cat.count + Dog.count));
        System.out.println("Котиков: " + Cat.getCountOfCat());
        System.out.println("Собачек: " + Dog.getCountOfDog());
        System.out.println("Всего животных: " + Animal.getCountOfAnimals());
        //Luzhnov 28.01.2022 -
    }
}

class Cat extends Animal {
    //Luzhnov 28.01.2022 +
//    static int count;
    private static int count = 0;

//    Cat(String name, int limitRun, int limitSwim) {
//        super(name, limitRun, limitSwim);
//        count++;
//    }

    Cat(String name, int limitRun) {
        super(name, limitRun, -1);
        count++;
    }

    public static int getCountOfCat() {
        return count;
    }

    @Override
    public String swim(int distance) {
        return name + " не любит купаться" ;
    }

//    @Override
//    public String run(int distance) {
//        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
//    }
//
//    @Override
//    public String swim(int distance) {
//        return name + (distance > limitSwim ? " не " : " ") + "проплыл " + distance + " м";
//    }
    //Luzhnov 28.01.2022 -
}

class Dog extends Animal {
    //Luzhnov 28.01.2022 +
//    static int count;
    private static int count = 0;
    //Luzhnov 28.01.2022 -

    Dog(String name, int limitRun, int limitSwim) {
        super(name, limitRun, limitSwim);
        count++;
    }

    //Luzhnov 28.01.2022 +
    public static int getCountOfDog() {
        return count;
    }

//    @Override
//    public String run(int distance) {
//        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
//    }
//
//    @Override
//    public String swim(int distance) {
//        return name + (distance > limitSwim ? " не " : " ") + "проплыл " + distance + " м";
//    }
    //Luzhnov 28.01.2022 -
}

interface IAnimal {
    String run(int distance);
    String swim(int distance);
}

abstract class Animal implements IAnimal {
    protected String name;
    protected int limitRun;
    protected int limitSwim;
    //Luzhnov 28.01.2022 +
    private static int count = 0;
    //Luzhnov 28.01.2022 -

    Animal(String name, int limitRun, int limitSwim) {
        this.name = name;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        //Luzhnov 28.01.2022 +
        count++;
        //Luzhnov 28.01.2022 -
    }

    //Luzhnov 28.01.2022 +
    public static int getCountOfAnimals() {
        return count;
    }

    @Override
    public String run(int distance) {
        return name + (distance > limitRun ? " не " : " ") + "пробежал " + distance + " м";
    }

    @Override
    public String swim(int distance) {
        return name + (distance > limitSwim ? " не " : " ") + "проплыл " + distance + " м";
    }
    //Luzhnov 28.01.2022 -

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}
