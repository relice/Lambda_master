package lambdaDemo;

/**
 * @Package: lambdaDemo
 * @Author: Relice
 * @Date: 16/4/20
 * @Des: 内部方法带2个参数 , 带返回值
 */
public interface IParmas2AndReturn<A, B, R> {
    R call(A a, B b);
}

