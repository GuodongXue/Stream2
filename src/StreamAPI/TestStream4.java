package StreamAPI;

import Lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStream4 {
    List<Employee> employees = Arrays.asList(
            new Employee("a", 18, 2222.33, Employee.Status.EASY),
            new Employee("a", 18, 2222.33, Employee.Status.FREE),
            new Employee("b", 16, 23422.33, Employee.Status.VOCATION),
            new Employee("n", 13, 2342.33, Employee.Status.FREE),
            new Employee("e", 23, 22672.33, Employee.Status.EASY),
            new Employee("e", 99, 22256.33, Employee.Status.VOCATION),
            new Employee("t", 45, 222255.33, Employee.Status.EASY),
            new Employee("y", 33, 222275.33, Employee.Status.VOCATION),
            new Employee("r", 22, 534.33, Employee.Status.VOCATION),
            new Employee("y", 66, 2256.33, Employee.Status.FREE),
            new Employee("u", 55, 2265.33, Employee.Status.EASY),
            new Employee("x", 65, 223455.33, Employee.Status.VOCATION),
            new Employee("w", 19, 222788.33, Employee.Status.EASY)

    );
    List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    Integer[] numArr = new Integer[]{1,2,3,4,5,6,7,8,9,10};

    @Test
    public void test1(){
        Arrays.stream(numArr)
                .map(x -> x*x)
                .forEach(System.out::println);

    }

    @Test
    public void test2(){
        Optional<Integer> sumPeople = employees.stream()
                .map(employee -> 1)
                .reduce(Integer::sum);
        System.out.println(sumPeople.get());
    }

    @Test
    public void test3(){

    }



}
