package liuyang.update17;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 文本块
 * JDK13 预览
 * JDK14 二次预览
 * JDK15 转正
 * 显著提高可读性
 * https://www.bilibili.com/video/BV1PY411e7J6?p=199&vd_source=8bd7b24b38e3e12c558d839b352b32f4
 * 17:00 ~ 21:22
 *
 * @author xconf
 * @since 2023/11/4
 */
@Slf4j
public class Block15Test {

    @Test
    void testBlock13() {
        String block = """
                <div>
                    <span>Java也可以写文本块了！</span>
                </div>
                """;
        log.info("{}", block);
        System.out.printf(block);

        String json = """
                {
                    "name": "Song HongKang",
                    "gender": "男"
                }
                """;
        log.info("{}", json);
        System.out.println(json);
    }

    // /////////////////////////////////////////////////////////////
    // Python
    // https://www.runoob.com/python3/python3-string.html
    // Python ''' xxxxxx '''

    // /////////////////////////////////////////////////////////////
    // C++
    /*
    // liuyang 202311040614 add C++ 11 Raw string literal R"()"
    cout << "# C++ 11 Raw String Literal ################" << endl;
    string block = R"(
        <div>
            <span>C++ 11 也可以写文本块了！</span>
        </div>
    )";
    cout << block << endl;
     */

    /**
     * JDK 14增强
     * \:取消换行操作
     * \s:表示一个空格
     */
    @Test
    void testBlock14() {
        String newQuery = """
                    SELECT id, name, email \
                    FROM students\s\
                    WHERE id > 4 \
                    ORDER BY email DESC
                """;
        log.info("{}", newQuery);
        System.out.println(newQuery);
    }


}
