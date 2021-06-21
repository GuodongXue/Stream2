package Lambda;

import org.junit.Test;

import javax.print.DocFlavor;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodRef {

    @Test
    public void test1(){
        Consumer<String> con = x -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("sjksjsjsjs");
    }

    @Test
    public void test2(){
        Employee emp = new Employee();
        Supplier<String> sup = ()->emp.getName();
        String str = sup.get();
        System.out.println(str);

        Supplier<Integer> sup2 = emp::getAge;
        Integer num = sup2.get();
        System.out.println(num);
    }
    @Test
    public void test3(){
        Comparator<Integer> com = (x, y)-> Integer.compare(x, y);
        Comparator<Integer> com2 = Integer::compare;
    }
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x,y)->x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
    }

    @Test

    public void test5(){
        Supplier<Employee> sup = () -> new Employee();
        sup.get();
    }
    @Test

    public void test6(){
        Function<Integer, String[]> fun = (x)-> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);
        Function<Integer, String[]> fun2 = String[]::new;
        String[] strs2 = fun2.apply(20);
        System.out.println(strs.length);
    }




}
