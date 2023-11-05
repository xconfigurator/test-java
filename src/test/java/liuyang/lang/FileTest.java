package liuyang.lang;

import java.io.File;
import java.util.Arrays;

/**
 * @author xconf
 * @since 2023/5/10
 */
public class FileTest {

    private static final String FOLDER_PATH = "F:\\liuyang\\Windows 聚焦\\rename\\20231028";

    public static void main(String[] args) {
        File folder = new File(FOLDER_PATH);
        //Arrays.stream(folder.listFiles()).forEach(System.out::println);
        //Arrays.stream(folder.listFiles()).forEach(file -> System.out.println(file.getAbsolutePath() + ".png"));
        Arrays.stream(folder.listFiles()).forEach(file -> file.renameTo(new File(file.getAbsoluteFile() + ".png")));
    }
}
