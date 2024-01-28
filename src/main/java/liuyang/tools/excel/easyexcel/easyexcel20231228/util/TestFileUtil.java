package liuyang.tools.excel.easyexcel.easyexcel20231228.util;

/**
 * @author xconf
 * @since 2023/12/28
 */
public class TestFileUtil {
    public static String getPath() {
        //return TestFileUtil.class.getResource("/").getPath();
        return TestFileUtil.class.getResource("/").getPath().replace("test-classes/", "");
    }
}
