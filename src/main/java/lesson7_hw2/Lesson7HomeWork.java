package lesson7_hw2;

public class Lesson7HomeWork {
    public static void main(String[] args) {
        int food = 30; // начальное количество еды в тарелке
        int foodAdd = 40; // количество еды для добавления

        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 10),
                new Cat("Kotik", 20)
        };

        int allAppetite = 0;
        for (Cat cat : cats) {
            allAppetite += cat.getAppetite();
        }
//        for (int i = 0; i < cats.length; i++) {
//            allAppetite += cats[i].getAppetite();
//        }
        System.out.println("Общий аппетит: " + allAppetite);

        Plate plate = new Plate(food);
        System.out.println("Рыб в тарелке до еды: " + plate);
        System.out.println("Начали есть");

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println(cats[i]);
        }

        System.out.println("Рыб в тарелке после еды: " + plate);

        // добавляем еду, если всем не хватило
        plate.addFood(foodAdd);


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

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        isFull = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return name + ", может съесть: " + appetite + ", " + "cытость: " + isFull;
    }
}

class Plate {
    private int food;

    Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int food) {
        int thisFood = this.food;
        if ((thisFood -= food) < 0) {
            System.out.println("Рыбы в тарелке осталось: " + this.food);
            return false;
        }
        this.food -= food;
        System.out.println("Рыбы в тарелке осталось: " + this.food);
        return true;
    }

    // Метод добавления еды в тарелку
    public void addFood(int foodAdd) {
        System.out.println("Добавлено: " + foodAdd);
        this.food += foodAdd;
        System.out.println("После добавления в тарелке: " + this.food);
    }

    @Override
    public String toString() {
        return "" + food;
    }
}
