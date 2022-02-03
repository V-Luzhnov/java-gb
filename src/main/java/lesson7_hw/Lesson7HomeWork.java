package lesson7_hw;
/**
 * Java 1. HomeWork 7
 *
 * @author Vitalii Luzhnov
 * @version 03.02.2022
 */
public class Lesson7HomeWork {
    public static void main(String[] args) {

        int foodAdd = 35; // количество рыбы для добавления
        int food = 30; // начальное количество рыбы в тарелке
        final int sizePlate = 30; // объем тарелки, т.е. сколько рыбы помещается в тарелку

        final String ANSI_RESET = "\033[0m";
        final String ANSI_GREEN = "\033[32m";
        final String ERROR_1 = "Начальное количество рыбы не умещается в тарелке. Уменьшите начальное количество рыбы в тарелке.";
        final String ERROR_2 = "Тарелка слишком маленькая. Возьмите тарелку побольше.";
        final String Q_IN_PLATE = "Количество рыбы в тарелке: ";
        final String Q_FOODADD = "Количество рыбы в запасе: ";

        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 20),
                new Cat("Kotik", 30),
                new Cat("Leopold", 15)
        };

        if (sizePlate < food) {
            System.out.println(ERROR_1);
            return;
        }

        if (!checkSizePlate(sizePlate, cats)) {
            System.out.println(ERROR_2);
            return;
        }

        System.out.println("Количество рыбы, которое помещается в тарелку: " + sizePlate + "\n" + Q_FOODADD + foodAdd);

        Plate plate = new Plate(food, sizePlate);

        System.out.println(Q_IN_PLATE + plate);

        // кормим котиков пока есть еда в запасе
        while (catHungry(cats) && foodAdd != 0) {
            for (Cat cat : cats) {
                cat.eat(plate);
                System.out.println(ANSI_GREEN + cat + ANSI_RESET);
            }
            System.out.println(Q_IN_PLATE + plate);
            // если после еды есть голодные котики, то добавляем еды в тарелку
            if (catHungry(cats)) {
                foodAdd = plate.addFood(foodAdd);
            }
            System.out.println(Q_FOODADD + foodAdd);
        }

        // доесть то, что осталось в тарелке, если будет найден голодный котик с подходящим аппетитом
        if (catWithLittleAppetite(plate.getFood(), cats)) {
            for (Cat cat : cats) {
                cat.eat(plate);
                System.out.println(ANSI_GREEN + cat + ANSI_RESET);
            }
            System.out.println(Q_IN_PLATE + plate + "\n" + Q_FOODADD + foodAdd);
        }
    }

    //проверка на наличие голодного кота
    static boolean catHungry(Cat[] cats) {
        for (Cat cat : cats) {
            if (!cat.getIsFull()) {
                return true;
            }
        }
        return false;
    }

    // проверка соответствия размера тарелки аппетиту каждого кота
    static boolean checkSizePlate(int sizePlate, Cat[] cats) {
        for (Cat cat : cats) {
            if (sizePlate < cat.getAppetite()) {
                return false;
            }
        }
        return true;
    }

    // поиск голодного кота, аппетита которого удовлетворил бы остаток еды в тарелке
    static boolean catWithLittleAppetite(int foodInPlate, Cat[] cats) {
        for (Cat cat : cats) {
            if (foodInPlate >= cat.getAppetite() && !cat.getIsFull()) {
                return true;
            }
        }
        return false;
    }
}

class Cat {

    private String name;
    private int appetite;
    private boolean isFull;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public boolean getIsFull() {
        return isFull;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        if (!this.isFull) {
            this.isFull = plate.decreaseFood(appetite);
        }
    }

    @Override
    public String toString() {
        return name + ", может съесть: " + appetite + ", " + "cытость: " + isFull;
    }
}

class Plate {
    private int food;
    private int sizePlate;

    Plate(int food, int sizePlate) {
        this.food = food;
        this.sizePlate = sizePlate;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int food) {
        if ((this.food - food) < 0) {
            return false;
        }
        this.food -= food;
        return true;
    }

    // Метод добавления еды в тарелку
    public int addFood(int foodAdd) {
        final String Q_AFTER_ADD = "Количество рыбы в тарелке: ";
        final String Q_ADD = "Добавлено рыбы: ";

        if (this.food + foodAdd <= this.sizePlate) {
            System.out.println(Q_ADD + foodAdd);
            this.food += foodAdd;
            System.out.println(Q_AFTER_ADD + this.food);
            return 0;
        }
        int newFoodAdd = foodAdd - (this.sizePlate - this.food);
        System.out.println(Q_ADD + (this.sizePlate - this.food));
        this.food = this.sizePlate;
        System.out.println(Q_AFTER_ADD + this.food);
        return newFoodAdd;
    }

    @Override
    public String toString() {
        return "" + food;
    }
}
