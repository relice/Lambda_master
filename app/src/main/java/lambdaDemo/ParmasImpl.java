package lambdaDemo;

/**
 * @Package: lambdaDemo
 * @Author: Relice
 * @Date: 16/4/20
 * @Des: 多个参数的方法如何使用 lambda
 */
public class ParmasImpl {

    //不带返回值内部类,1个参数Demo
    public void setOnIParmas1Listener(IParmas1 ipamr) {
    }

    //不带返回值内部类,2个参数Demo
    public void setOnIParmas2Listener(IParmas2 ipamr) {
    }

    //带返回值内部类,2个参数Demo
    public void setOnIParmas2AndReturnListener(IParmas2AndReturn ipamr) {
    }

    //配合demo1测试
    public void demo1Test(Object o) {
    }

    //配合demo2测试
    public void demo2Test(Object o1, Object o2) {
    }

    /**
     * lambda 还有一个很屌的写法,看得我都觉得轻飘飘的feel都有了,
     * 才发现原来java代码可以这么单纯的,来看看吧,我也是看到这个写法后才喜欢上lambda的.
     * 那就是 lambda的双冒号(::)写法:
     * <p>
     * lambda 双冒号写法前提条件是,方法接收的值是参数原值,没有拼接其他数据,
     * 额,不明白是吧,开始我也是云里雾里,接着看下面解释吧.
     * <p>
     * 1.这是订阅IParmas1 接口的一个监听.
     * setOnIParmas1Listener(IParmas1 ipamr)
     * <p>
     * 2.在{@link IParmas1}  接口中定义的方法参数(A a),也就是Object.
     * void call(A a);
     * <p>
     * 3.因此在接收内部类方法参数,也就是demo1Test(Object o),该方法的参数也是obj
     * demo1Test(Object o)
     * <p>
     * 4.这样条件下就可以直接把案例1,写成lambda语法了
     * setOnIParmas1Listener(this::demo1Test);
     * <p>
     * 见demo2,案例2,多参数双冒号(::)写法{@see demo2}
     **/
    public void demo1() {
        //TODO 案例1,方法内部实现使用统一参数类型 原始写法
        setOnIParmas1Listener(new IParmas1() {
            @Override
            public void call(Object o) {
                ParmasImpl.this.demo1Test(o);
            }
        });
        //lambda 写法
        setOnIParmas1Listener(this::demo1Test);

        //TODO 案例2,不带返回值 原始写法
        setOnIParmas1Listener(new IParmas1() {
            @Override
            public void call(Object s) {
                ParmasImpl.this.demo2();
            }
        });
        // 不带返回值的lambda写法
        setOnIParmas1Listener(s -> demo2());
    }

    /**
     * lambda 匿名内部类的使用
     * 使用lambda 来美化匿名内部类的高度,看起来简单又优雅
     * lambda 会直接把整个内部类隐藏,只留下形参,而且有一点要注意,内部类使用lambda,
     * 前提是,该内部类只有一个内部方法,如果有两个或以上则使用不了lambda语法.
     * <p>
     * 1. 空参数 写法: () -> 内部类方法的实现.
     * <p>
     * 2. 1参数(String) 写法: s -> 内部类方法的实现.
     * 需要注意的是当参数为Void时,写法与有1个参数的一样
     * <p>
     * 3. 2个参数(String,int) 写法: (s,i) -> 内部类方法的实现.
     * <p>
     * lambda的 内部类写法与泛型没有太大关系,但是也要注意器参数是否被引用.
     * 如果引用的话,其实lambda 是不推荐使用表达式的,但是也可以用,就是在用
     * 的时候,他会自动将类型转换成Object
     * 如下: s 和 i 现在其实是 obj类型
     * 写法1:
     * setOnIParmas2Listener((s, i) -> {
     * System.out.println(s + "-----" + i);
     * });
     * <p>
     * 写法2:当然也可声明类型
     * 而且声明参数类型,只有参数在两个或以上才可以,一个参数是不可以声明的.
     * setOnIParmas2Listener((Object s,Object  i) -> {
     * System.out.println(s + "-----" + i);
     * });
     */
    public void demo2() {
        //TODO 案例1: 原始代码
        setOnIParmas2Listener(new IParmas2<String, Integer>() {
            @Override
            public void call(String s, Integer i) {
                System.out.println(s + "-----" + i);
            }
        });
        //使用lambda
        //因为上面其实是确定了类型的,被sout引用了,但是如果强制使用lambda的话
        //会出现方法参数自动转向默认obj类型
        setOnIParmas2Listener((s, i) -> System.out.println(s + "-----" + i));

        //TODO 案例2:多参数使用 lambda双冒号
        setOnIParmas2Listener(new IParmas2() {
            @Override
            public void call(Object o1, Object o2) {
                ParmasImpl.this.demo2Test(o1, o2);
            }
        });
        //使用lambda
        setOnIParmas2Listener(this::demo2Test);
    }

    /**
     * 在有返回值的时候有两种情况,下面使用带两个参数的内部方法来示范
     * <p>
     * 1.内部方法直接返回,只有一个实现(方法/语句)
     * (s,i) ->  null;
     * 其实这个写法就跟返回值是void的一样,只是void返回值方法内实现一个(方法/语句)而已,
     * 如{@see demo1}案例2,中的lambda写法.
     * s -> demo2()
     * <p>
     * 2.内部方法返回, 2个以上实现(方法/语句)(下面方法的lambda写法)
     * (s,i) ->  {
     * System.out.println("带了一个sout的实现");
     * return null;
     * };
     */
    public void demo2R() {
        //TODO 带返回值的原始方法
        setOnIParmas2AndReturnListener(new IParmas2AndReturn<String, Integer, Double>() {
            @Override
            public Double call(String s, Integer i) {
                System.out.println("带了一个sout的实现");
                return null;
            }
        });

        //使用lambda 写法
        setOnIParmas2AndReturnListener((s, i) -> {
            System.out.println("带了一个sout的实现");
            return null;
        });
    }
}

