package lesson07_hw;
/**
 * Java 1. HomeWork 7
 *
 * @author Vitalii Luzhnov
 * @version 02.02.2022
 */
class HomeWork7 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 1);
        Plate plate = new Plate(1, 5); //начальное количество еды в тарелке; максимальное количество еды для тарелки
        System.out.println(cat);
        System.out.println(plate);

        cat.eat(plate);

        plate.addFood(2); //добавлено еды, если не хватило

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
        if (!isFull) {
            plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return name + ", appetite: " + appetite;
    }
}

class Plate {
    private int food;
    private int maxFoodPlate;

    Plate(int food, int maxFoodPlate) {
        this.food = food;
        this.maxFoodPlate = maxFoodPlate;
    }

    public void decreaseFood(int food) {
        this.food -= food;
    }

    // Метод добавления еды в тарелку
    public void addFood(int food) {
        if (this.food + food <= maxFoodPlate) {
            this.food += food;
        }
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}
