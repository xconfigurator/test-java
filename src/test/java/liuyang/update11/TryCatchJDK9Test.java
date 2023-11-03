package liuyang.update11;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;

/**
 * try-with-resource
 * 文档参考
 * https://wiki.eclipse.org/Java9/Examples
 *
 * @author xconf
 * @since 2023/11/3
 */
@Slf4j
public class TryCatchJDK9Test {

    @DisplayName("JDK9 try-catch")
    @Test
    void test01Writer() {

        // liuyang 直接从Eclipse给出的例子中超了两个。
        class Two implements Closeable {
            @Override
            public void close() throws IOException {
                // nothing
            }
        }

        final Two t1 = new Two();
        try (t1; final Two t2 = new Two()) {
            // Empty by design
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // t1 = null; // Remove this code
    }
}
