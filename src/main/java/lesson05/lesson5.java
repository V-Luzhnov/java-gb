package lesson05;

class lesson5 {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", "black", 3);
        cat.setName("Vasilii");
        System.out.println(cat.voice());
        System.out.println(cat);
        Cat cat1 = new Cat("Murzik");
        System.out.println(cat1.voice());
        System.out.println(cat1);
    }
}

class Cat {
    private String name;
    private String color;
    private int age;

    Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    Cat(String name) {
        this.name = name;
    }

    String voice(){
        return "meow";
    }

    @Override
    public String toString(){
        return  "Cat: " + name + ", " + color + ", " + age;
    }
}
