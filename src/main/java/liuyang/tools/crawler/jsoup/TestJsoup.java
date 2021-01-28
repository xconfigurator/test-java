package liuyang.tools.crawler.jsoup;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 快速抓取网页图片
 *
 * 教学视频
 * https://www.bilibili.com/video/BV1RU4y147eZ
 */
@Slf4j
public class TestJsoup {

    public static final String OUTPUT_FOLDER = "d:/test/crawler/jsoup";
    public static final String URL = "https://mp.weixin.qq.com/s/jtxqf8JE0vEkLshgdYgzog";

    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL(URL), 100000);
        Element jsContent = document.getElementById("js_content");
        Elements imgs = jsContent.getElementsByTag("img");
        int idx = 0;
        for (Element img : imgs) {
            log.info(img.attr("data-src"));

            // 写入本地
            URL target = new URL(img.attr("data-src"));
            URLConnection urlConnection = target.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(OUTPUT_FOLDER + "/" + (++idx) + ".jpg"));

            // 复制
            int temp = 0;
            while ((temp = inputStream.read()) != -1) {
                fileOutputStream.write(temp);
            }
            log.info(img.attr("data-src") + "下载完毕， 本地名称：" + idx + ".jpg");

            fileOutputStream.close();
            inputStream.close();
        }
    }
}
