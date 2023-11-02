package liuyang.functional202311;

/**
 * @author xconf
 * @since 2023/11/2
 */
@FunctionalInterface// 编译器级别约束不允许有多余一个的抽象方法
public interface MyFunctionalInterface {
    void foo();
}
