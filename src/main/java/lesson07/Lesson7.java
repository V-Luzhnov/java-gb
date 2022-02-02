package lesson07;

class Lesson7 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(10);
        System.out.println(cat);
        System.out.println(plate);

//-1-       plate.setFood(plate.getFood() - cat.getAppetite());
//-2-       plate.decreaseFood(cat.getAppetite());
        cat.eat(plate);

        System.out.println(plate);
    }
}

//-3+I- interface ICat {
//-3+I-     void eat(Plate plate);
//-3+I- }

class Cat {
//-3+I- class Cat implements ICat {
    private String name;
    private int appetite;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

//-3+I-    @Override
    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }

//-2-    public int getAppetite() {
//-2-        return appetite;
//-2-    }

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

//-1-    public int getFood() {
//-1-        return food;
//-1-    }
//-1-
//-1-    public void setFood(int food) {
//-1-        this.food = food;
//-1-    }

    public void decreaseFood(int food) {
        this.food -= food;
    }

    @Override
    public String toString() {
        return "Plate: " + food;
    }
}