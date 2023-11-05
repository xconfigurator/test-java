package liuyang.update17;

/**
 * @author xconf
 * @since 2023/11/5
 */
public sealed class Sealed17Demo permits Student, Teacher, Worker{
    // 1. 只有指定的子类可以继承
    // 2. 子类继承时修饰符必须满足以下三种之一：final,non-sealed,sealed
}

// 情况1 允许子类是final的
final class Student extends Sealed17Demo {}

// 情况2 允许子类是non-sealed
non-sealed class Teacher extends Sealed17Demo {}// Teacher再被继承的时候没有任何限制

// 情况3 允许子类是sealed的
sealed class Worker extends Sealed17Demo permits Programmer {}
final class Programmer extends Worker {}
