package liuyang.getobj;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author :liuyang(wx)
 * @date :2022/2/16 15:09
 */
public class GetObj03URLClassLoader {
    //private static final String CLASSURL = "file:/F:/workspaces/workspace_oxygen/TestJava/bin/";
    //private static final String CLASSNAME = "cn.edu.hebau.liuyang.Hello";
    private static final String CLASSURL = "file:G:\\workspaces\\workspace_idea_c\\test-java\\target\\classes\\liuyang\\lang";
    private static final String CLASSNAME = "liuyang.lang.Hello";

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        URL[] urls = new URL[] {new URL(CLASSURL)};
        URLClassLoader loader = new URLClassLoader(urls);
        Class clazz = loader.loadClass(CLASSNAME);
        clazz.getMethod("main", String[].class).invoke(null, (Object) new String[] {});
    }
}
