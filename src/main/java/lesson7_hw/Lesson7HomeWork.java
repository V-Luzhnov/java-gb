package lesson7_hw;

public class Lesson7HomeWork {
    public static void main(String[] args) {
        int food = 30; // начальное количество рыбы в тарелке
        int foodAdd = 40; // количество рыбы для добавления
        final int sizePlate = 30; // объем тарелки, т.е. сколько рыбы помещается в тарелку

        Cat[] cats = {
                new Cat("Barsik", 10),
                new Cat("Murzik", 30),
                new Cat("Kotik", 20)
        };

        if (!checkSizePlate(sizePlate, cats)) {
            System.out.println("Тарелка слишком маленькая. Возьмите тарелку побольше.");
            return;
        }

        System.out.println("Запас рыбы: " + foodAdd);

        Plate plate = new Plate(food, sizePlate);
        System.out.println("Рыб в тарелке до еды: " + plate);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat);
        }

        System.out.println("Рыб в тарелке после еды: " + plate);

        // добавляем еду, если есть голодный кот
        if (catHungry(cats)) {
            foodAdd = plate.addFood(foodAdd);
            System.out.println("foodAdd 2: " + foodAdd);
            for (Cat cat : cats) {
                cat.eat(plate);
                System.out.println(cat);
            }
        }
        System.out.println("Рыб в тарелке после еды: " + plate);
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

    static boolean checkSizePlate(int sizePlate, Cat[] cats) {
        for (Cat cat : cats) {
            if (sizePlate < cat.getAppetite()) {
                return false;
            }
        }
        return true;
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

    public boolean decreaseFood(int food) {
        if ((this.food - food) < 0) {
            return false;
        }
        this.food -= food;
        return true;
    }

    // Метод добавления еды в тарелку
    public int addFood(int foodAdd) {
        System.out.println("this.food: " + this.food);
        System.out.println("foodAdd: " + foodAdd);
        System.out.println("this.sizePlate: " + this.sizePlate);
        if (this.food + foodAdd <= this.sizePlate) {
            System.out.println("Добавлено: " + foodAdd);
            this.food += foodAdd;
            System.out.println("Рыб в тарелке после добавления: " + this.food);
            return 0;
        } else {
            this.food = this.sizePlate;
            System.out.println("Рыб в тарелке после добавления: " + this.food);
            return foodAdd - this.sizePlate;
        }
//        System.out.println("Рыб в тарелке после добавления: " + this.food);

//    public void addFood(int foodAdd) {
//        System.out.println("this.food: " + this.food);
//        System.out.println("foodAdd: " + foodAdd);
//        System.out.println("this.sizePlate: " + this.sizePlate);
//        if (this.food + foodAdd <= this.sizePlate) {
//            System.out.println("Добавлено: " + foodAdd);
//            this.food += foodAdd;
//        } else {
//            this.food = this.sizePlate;
//        }
//        System.out.println("Рыб в тарелке после добавления: " + this.food);

//        System.out.println("Добавлено: " + foodAdd);
//        this.food += foodAdd;
//        System.out.println("Рыб в тарелке после добавления: " + this.food);
    }

    @Override
    public String toString() {
        return "" + food;
    }
}
