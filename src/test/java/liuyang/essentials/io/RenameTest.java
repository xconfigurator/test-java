package liuyang.essentials.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

/**
 * @author xconf
 * @since 2024/1/7
 */
public class RenameTest {

    @Test
    void 更名Windows聚焦下面的图片() {
        // from liuyang.io.rename.FileTest
        final String FOLDER_PATH = "F:\\liuyang\\Windows 聚焦\\rename\\202401191050";
        File folder = new File(FOLDER_PATH);
        //Arrays.stream(folder.listFiles()).forEach(System.out::println);
        //Arrays.stream(folder.listFiles()).forEach(file -> System.out.println(file.getAbsolutePath() + ".png"));
        Arrays.stream(folder.listFiles()).forEach(file -> file.renameTo(new File(file.getAbsoluteFile() + ".png")));
    }

    @Test
    void 批量修改宇哥视频文件名() {
        // from liuyang.io.rename.TestFile
        // "F:\\01_数学\\数学_张宇\\2024_0002_基础30讲\\01.高等数学\\04.第4讲_一元函数微分学"
        final String FILE_NAME = "E:\\真题_2013-2022_高昆仑_2023版真题大全解配套视频_分类解析\\01.高数";

        // 改名
        File file = new File(FILE_NAME);
        //Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName().replace(".xlsx", "")));
        //Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName().replace("【22.21免费公众号：考研草堂，后台回复“获取资料”即可获取22和21资料汇总，QQ群1037079685】..", "")));//
        Arrays.stream(file.listFiles()).forEach(f -> {
            // 【22.21免费公众号：考研草堂，后台回复“获取资料”即可获取22和21资料汇总，QQ群1037079685】..
            // .【后续课程关注微信公众号“考研草堂”后台回复“获取资料”即可获取24和23资料汇总，qq群782054034,每天更新通知群】
            // .【23.22免费公众号：考研草堂，后台回复“获取资料”即可获取23和22资料汇总，QQ群493337111】.
            String REPLACE_TARGET = "mp4";
            String newFilePath = f.getAbsolutePath().replace(REPLACE_TARGET, ".mp4");

            System.out.println(newFilePath);
            f.renameTo(new File(newFilePath));
        });

        // 检查
        Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName()));
    }
}
