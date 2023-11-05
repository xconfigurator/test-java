package liuyang.update17;

import lombok.extern.slf4j.Slf4j;

/**
 * JDK15 预览
 * JDK16 二次预览
 * JDK17 转正
 *
 * https://www.bilibili.com/video/BV1PY411e7J6?p=199&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 35:00 ~ 44:00左右
 *
 * @author xconf
 * @since 2023/11/3
 */
@Slf4j
public class Sealed17Test {
    // 耕细粒度第控制继承的手段。
    // 指定可以被那些子类继承。
    // public sealed class Person permits Student, Teacher, Worker {}
    // 见Sealed17Demo.java
}
