package StreamAPI;


import Lambda.Employee;
import org.junit.Test;
import sun.java2d.pipe.AAShapePipe;

import java.util.*;
import java.util.stream.Stream;

public class TestStream2 {
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
    public void test1(){
        employees.stream()
                /*.filter(employee -> employee.getAge()>35)*/
                .distinct()
                .forEach(System.out::println);

    }@Test
    public void test2(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);


        System.out.println("------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStream2::filterCharacter);

        streamStream.forEach( sm -> sm.forEach(System.out::println));

        list.stream()
                .flatMap(TestStream2::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for(Character ch: str.toCharArray()){
            list.add(ch);

        }
        return list.stream();
    }


    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List list2 = new ArrayList();
        list2.add(11);
        list2.addAll(list);
        System.out.println(list2);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("eee","aaa", "bbb", "ccc", "ddd");

        list.stream()
                .sorted()
                .forEach(System.out::println);

        /*employees.stream()
                .sorted((e1,e2)-> {
                    *//*if(e1.getAge()== e2.getAge()){
                        return e1.getName().equals(e2.getName());
                    }else{
                        return e2.getAge() == e1.getAge();*//*
                    }
                });*/
        /*employees.stream()
                .sorted((e1, e2) ->{
                    if(Objects.equals(e1.getAge(), e2.getAge())){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return -e1.getAge()==(e2.setAge());
                    }
                })
                .forEach(System.out::println);*/
    }
}
