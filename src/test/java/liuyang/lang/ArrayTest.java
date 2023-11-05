package liuyang.lang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author xconf
 * @since 2023/10/28
 */
@Slf4j
public class ArrayTest {

    /**
     * Java数组声明时不能使用变量
     * C++可以！
     */
    @Test
    void test202310281043() {
        int len = 1;
        while (len < 10) {
            //int num_array2[len];// variable-length array
            //cout << "len = " << len;
            //cout << ", sizeof(num_array2) = " << sizeof(num_array2) << endl;
            len++;
        }

        //final int l = 1;
        //int arr[l];
    }
}
