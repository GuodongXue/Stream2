package Lambda;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private int age;
    private Status Status;



    public Employee(String name,int age, double salary,  Employee.Status status) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        Status = status;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employee.Status getStatus() {
        return Status;
    }

    public void setStatus(Employee.Status status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", Status=" + Status +
                '}';
    }

    public enum Status{
        FREE,
        EASY,
        VOCATION;
    }


   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, age);
    }*/
}
