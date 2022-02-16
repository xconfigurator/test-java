package liuyang.jvm.classloader;

/**
 * @author :liuyang(wx)
 * @date :2022/2/16 14:05
 */
public class HelloClassLoader {
    /**
     * bootstrap class loader
     *  implemented by native language
     *  load th core classes of jdk
     *
     * extension class loader
     *  load the class from jre/lib/ext
     *
     * application class loader
     *  load user-define classes
     *  ClassLoader.getSystemClassLoader()
     *
     * other class loaders
     *  SecureClassLoader
     *  URLClassLoader
     */
    public static void main(String[] args) {
        ClassLoader classLoader = HelloClassLoader.class.getClassLoader();
        while (classLoader.getParent() != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
    }
}
