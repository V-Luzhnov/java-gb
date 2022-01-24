package lesson05;
/*
 * Java 1. HomeWork 5
 *
 * @author Vitalii Luzhnov.
 * @version 24.01.2022
 */
public class HomeWork5 {
    public static void main(String[] args) {
        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Ivan Ivanov", "Director", "i.ivanov@employee.com", "123456789", "100000", 41);
        emplArray[1] = new Employee("Petr Petrov", "Accountant", "p.petrov@employee.com", "234567891", "70000", 45);
        emplArray[2] = new Employee("Sergey Serov", "Tester", "s.serov@employee.com", "345678912", "80000", 39);
        emplArray[3] = new Employee("Igor Smirnov", "Programmer", "i.smirnov@employee.com", "456789123", "90000", 30);
        emplArray[4] = new Employee("Andrey Sviridov", "Security", "a.sviridov@employee.com", "567891234", "50000", 50);

        for (int i = 0; i < emplArray.length; i++ ){
            if (emplArray[i].getAge() > 40) {
                System.out.println(emplArray[i]);
            }
        }
    }
}

class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private int age;

    Employee(String fullName, String position, String email, String phone, String salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public String getFullName() {
        return fullName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setFullName(String fullName) {
        if (fullName != null) {
            this.fullName = fullName;
        }
    }

    public void setPosition(String position) {
        if (position != null) {
            this.position = position;
        }
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public void setPhone(String phone) {
        if (phone != null) {
            this.phone = phone;
        }
    }

    public void setSalary(String salary) {
        if (salary != null) {
            this.salary = salary;
        }
    }

    public void setAge(String age) {
        if (age != null) {
            this.fullName = age;
        }
    }

    @Override
    public String toString(){
        return  "Employee: " + fullName + ", " + position + ", " + email + ", " + phone + ", " + salary + ", " + age;
    }
}
