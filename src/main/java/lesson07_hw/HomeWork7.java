package lesson07_hw;
/**
 * Java 1. HomeWork 7
 *
 * @author Vitalii Luzhnov
 * @version 02.02.2022
 */
class HomeWork7 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(10);
        System.out.println(cat);
        System.out.println(plate);

        cat.eat(plate);

        System.out.println(plate);
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean isFull;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return name + ", appetite: " + appetite;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int food) {
        this.food -= food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}
