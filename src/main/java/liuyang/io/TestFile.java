package liuyang.io;

import java.io.File;
import java.util.Arrays;

public class TestFile {
    //public static final String FILE_NAME = "C:\\Users\\liuyang\\Desktop\\pdt-nms_数据库表";
    public static final String FILE_NAME = "C:\\Users\\liuyang\\Downloads\\14.第二章物理层";

    public static void main(String[] args) {
        File file = new File(FILE_NAME);
        //Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName().replace(".xlsx", "")));
        // 打印名称
        //Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName().replace("【22.21免费公众号：考研草堂，后台回复“获取资料”即可获取22和21资料汇总，QQ群1037079685】..", "")));//
        Arrays.stream(file.listFiles()).forEach(f -> {
            String newFilePath = f.getAbsolutePath().replace("【22.21免费公众号：考研草堂，后台回复“获取资料”即可获取22和21资料汇总，QQ群1037079685】..", "");
            //System.out.println(newFilePath);
            f.renameTo(new File(newFilePath));
        });
        Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName()));
    }
}
