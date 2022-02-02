package lesson07_hw;
/**
 * Java 1. HomeWork 7
 *
 * @author Vitalii Luzhnov
 * @version 02.02.2022
 */
class HomeWork7 {
    public static void main(String[] args) {
        int food = 30; // начальное количество еды в тарелке
        int maxFoodPlate = 50; // максимальное количество еды, которое помещается в тарелку
        int foodAdd = 40; // количество еды для добавления

        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 10),
                new Cat("Kotik", 20)
        };

        Plate plate = new Plate(food, maxFoodPlate);

        System.out.println("Рыб в тарелке до еды: " + plate);
        System.out.println("Начали есть");

        for (Cat cat : cats) {
            cat.eat(plate, false);
            System.out.println(cat);
        }

        System.out.println("Рыб в тарелке после еды: " + plate);
        System.out.println("Рыб добавлено: " + foodAdd + " р.");

        // добавляем еду, если всем не хватило
        plate.addFood(foodAdd);

        System.out.println("Рыб в тарелке до еды: " + plate);
        System.out.println("Начали есть");

        for (Cat cat : cats) {
            cat.eat(plate, false);
            System.out.println(cat);
        }

        System.out.println("Рыб в тарелке после добавления: " + plate);
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

    public void eat(Plate plate, boolean isFull2) {
        isFull = isFull2;
        if (!isFull) {
            isFull = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return name + ", может съесть: " + appetite + " р., " + "cытость: " + isFull;
    }
}

class Plate {
    private int food;
    private int maxFoodPlate;

    Plate(int food, int maxFoodPlate) {
        this.food = food;
        this.maxFoodPlate = maxFoodPlate;
    }

    public boolean decreaseFood(int food1) {
        if (food < food1) {
            return false;
        }
        food -= food1;
        return true;
    }

    // Метод добавления еды в тарелку
    public void addFood(int food) {
        if (this.food + food <= maxFoodPlate) {
            this.food += food;
        }
    }

    @Override
    public String toString() {
        return food + " р.";
    }
}
