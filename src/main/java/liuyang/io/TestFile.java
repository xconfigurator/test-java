package liuyang.io;

import java.io.File;
import java.util.Arrays;

public class TestFile {
    //public static final String FILE_NAME = "C:\\Users\\liuyang\\Desktop\\pdt-nms_数据库表";
    //public static final String FILE_NAME = "C:\\Users\\liuyang\\Downloads\\14.第二章物理层";
    //public static final String FILE_NAME = "F:\\liuyang_workspaces\\workspace_vscode_cpp\\test_20200428_c_cpp\\04_OJ";
    public static final String FILE_NAME = "F:\\liuyang_workspaces\\workspace_vscode_cpp\\test_20200428_c_cpp";

    public static void main(String[] args) {
        //replaceNames(FILE_NAME);
        countCppFiles(FILE_NAME);
    }

    public static void replaceNames(String fileName) {
        File file = new File(fileName);
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

    // count *.cpp files
    private static int cppCounter = 0;
    public static void countCppFiles(String fileName) {
        traverseFile(new File(fileName));
        System.out.println("cpp文件数量：" + cppCounter);
    }
    private static void traverseFile(File file) {
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                traverseFile(f);
            } else {
                // TODO 判断文件扩展名有问题。
                if (f.getName() != null
                        && f.getName().indexOf(".") != -1
                        && ".cpp".equalsIgnoreCase(f.getName().substring(f.getName().lastIndexOf(".")))) {
                    System.out.println(f.getName());
                    cppCounter++;
                }
            }
        }
    }
}
