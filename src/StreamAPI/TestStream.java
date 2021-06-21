package StreamAPI;

import Lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
    //创建stream， 可以通过Collection提供的Stream方法或parallelSStream
    @Test
    public void test1(){
        //第一种方法

        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //获取
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //通过stream的静态方法 of（）
        /*Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);*/

        Stream.generate(()-> (Math.random())).limit(5).forEach(System.out::println);

    }
}
