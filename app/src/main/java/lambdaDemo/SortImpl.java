package lambdaDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Package: lambdaDemo
 * @Author: Relice
 * @Date: 16/4/20
 * @Des: lambda实际中的使用, 实战
 */
public class SortImpl {

    /**
     * 其实在{@link ParmasImpl}中已经说过了lambda 的一些常用方法,
     * 下面是在实际中 对集合数据排序时的用法:
     * 首先我们分析下Collections.sort(); 功能中参数内部类方法.
     * 内部类Comparator ,默认内部方法compare(s1,s2)参数类型是String,带返回值int.
     */
    public void demo1() {
        //没用使用lambda 的代码
        ArrayList<String> strs = new ArrayList<>();
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });


        //使用lambda 语法后,简单好看
        /**
         * this::demo1Test 与 String::compareTo 区别
         *
         * 表达的就是当前类下的demo1Test(obj,obj)方法,
         * 其实你如果直接引用compareTo 方法也是可以的,那你就不可以用this了,
         * 而是使用String 对象,因此compareTo 在String 对象内.
         */
        // 1.1 使用匿名内部类根据values 排序 strs
        Collections.sort(strs, this::demo1Test);
        // 1.2 使用匿名内部类根据values 排序 strs
        Collections.sort(strs, String::compareTo);

        // 2 使用lambda根据values  排序 strs
        Comparator<String> sortByName = (s1, s2) -> (s1.compareTo(s2));
        Collections.sort(strs, sortByName);

        // 3 也可以采用声明形参的写法:
        Collections.sort(strs, (String s1, String s2) -> (s1.compareTo(s2)));
    }

    /**
     * 提出比较的方法出来,方便lambda的双冒号写法调用
     */
    private int demo1Test(String s1, String s2) {
        return s1.compareTo(s2);
    }
}
