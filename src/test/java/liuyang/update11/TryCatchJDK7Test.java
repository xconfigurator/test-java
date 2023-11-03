package liuyang.update11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * JDK7 multi-catch
 * 1. try-with-resources statement
 * 2. multi-catch
 * 参考文档：
 * https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2FgettingStarted%2Fqs-with-java7.htm
 *
 * @author xconf
 * @since 2023/11/3
 */
@Slf4j
public class TryCatchJDK7Test {
    @DisplayName("JDK7的try-catch写法")
    @Test
    void test01FiltWriter() {
        // ctrl + shift + u 看类的继承结构图（貌似只有在Ultimate版本里有）
        // ctrl + h 查看继承接口 Hierarchy
        try (FileWriter fw = new FileWriter("d://test.txt")) {
            fw.write("hello, world jdk7 multi-catch & ");
        } catch (
                IOException e) {// multi-catch 格式举例： (NullPointerException | IlligalArgumentException e)  https://help.eclipse.org/latest/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2FgettingStarted%2Fqs-with-java7.htm
            log.error(e.getMessage(), e);
        }
    }

    @DisplayName("JDK7的try-catch写法")
    @Test
    void test02FileReader() {
        try (FileReader fr = new FileReader("d://test.txt")) {
            char[] cbuf = new char[1024];
            int len = 0;
            while ((len = fr.read(cbuf)) != -1) {
                log.info(new String(cbuf, 0, len));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 因为FileNotfoundException是IOException的子类，所以就不能写成multi-catch形式
    }

    @DisplayName("把文件从utf-8编码转成gbk")
    @Test
    void testFromUTF8ToGBK() {
        try (
                FileInputStream fis = new FileInputStream("d://test-from-utf8.txt");
                InputStreamReader isr = new InputStreamReader(fis, "utf-8");
                BufferedReader br = new BufferedReader(isr);

                FileOutputStream fos = new FileOutputStream("d://test-to-gbk.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "gbk");
                BufferedWriter bw = new BufferedWriter(osw);
                ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            //throw new RuntimeException(e);
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            log.error(e.getMessage(), e);
        }
    }
}
