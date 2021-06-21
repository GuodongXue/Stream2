package StreamAPI;

import Lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream3{
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

    @Test
    public void test() {
        boolean b1 = employees.stream()
                .allMatch(employee -> employee.getStatus().equals(Employee.Status.EASY));
        System.out.println(b1);


        boolean b2 = employees.stream()
                .anyMatch(employee -> employee.getStatus().equals(Employee.Status.EASY));
        System.out.println(b2);

        Optional<Employee> first = employees.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(first.get());


        Optional<Employee> findEasy = employees.stream()
                .filter(employee -> employee.getStatus().equals(Employee.Status.EASY))
                .findAny();
        System.out.println(findEasy.get());

        Optional<Employee> findFree = employees.parallelStream()
                .filter(employee -> employee.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println(findFree.get());
    }

    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> salarySum = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(salarySum.get());

    }
    @Test
    public void test2(){
        List<String> list= new ArrayList<>();

        list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("1111111111111111111111111111111111");
        Set<String> NameSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());

        NameSet.forEach(System.out::println);
        System.out.println("1111111111111111111111111111111111");
        HashSet<String> HashSetName = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));

        HashSetName.forEach(System.out::println);
    }
    @Test
    public void test3(){
        Long total = employees.stream()
                .collect(Collectors.counting());
        System.out.println(total);
        System.out.println("----------------------");

        Double avgSalary = (Double) employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avgSalary);

        Double collect = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect);

        Optional<Employee> maxSalary = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(maxSalary);

        Map<Employee.Status, List<Employee>> group = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(group);

        Map<Employee.Status, Map<String, List<Employee>>> MultiGroup = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(employee -> {
                    if (employee.getAge() <= 35) {
                        return "Young";

                    } else if (employee.getAge() <= 50) {
                        return "Mid";
                    } else {
                        return "Old";
                    }
                })));

        System.out.println(MultiGroup);

    }
    @Test
    public void test4(){
        Map<Boolean, List<Employee>> parsal = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 8000.0));

        System.out.println(parsal);
    }

    @Test
    public void test5(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getMin());
    }
    @Test

    public void test6(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(str);
    }






}
