package liuyang.tools.apache.commons.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IOTest {
	
	private final String FILE_PATH = "F:\\workspaces\\workspace_oxygen/TestJavaExtension/src/main/collections/cn/edu/hebau/liuyang/collection/commons/CIOTestCases.java";
	private final String FOLDER_PATH = "F:\\workspaces\\workspace_oxygen/TestJavaExtension/src";
	
	/**
	 * 统计文件以及目录的大小
	 */
	@Test
	public void testFileAndFolderSize() {
		String FILE_PATH = this.FILE_PATH;
		String FOLDER_PATH = this.FOLDER_PATH;
		
		long length = FileUtils.sizeOf(new File(FILE_PATH));// 文件
		System.out.println("file size = " + length);
		length = FileUtils.sizeOf(new File(FOLDER_PATH));// 文件夹
		System.out.println("folder size = " + length);
	}

	/**
	 * 遍历子孙级
	 * 以及文件过滤
	 */
	@Test
	public void testListChildren() {
		String FOLDER_PATH = "F:/workspaces/workspace_oxygen/TestJavaExtension";
		/**
		 * (new File(FOLDER_PATH), EmptyFileFilter.NOT_EMPTY, null)
		 * (new File(FOLDER_PATH), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE)
		 * (new File(FOLDER_PATH), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE)
		 * (new File(FOLDER_PATH), FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE)
		 */
		Collection<File> files = FileUtils.listFiles(new File(FOLDER_PATH), FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
	
	/**
	 * 读取文件内容
	 * @throws IOException 
	 */
	@Test
	public void testReadFileContent() throws IOException {
		// 读入字符串
		// String msg = FileUtils.readFileToString(new File(FILE_PATH)); // @Deprecated
		String msg = FileUtils.readFileToString(new File(FILE_PATH), "UTF-8");
		System.out.println(msg);
		
		// 读入字节数组
		byte[] data = FileUtils.readFileToByteArray(new File(FILE_PATH));
		System.out.println(data.length);
	
		// 逐行读取 方法1
		List<String> lines = FileUtils.readLines(new File(FILE_PATH), "UTF-8");
		for (String line : lines) {
			System.out.println(line);
		}
		System.out.println("#1");
		
		// 逐行读取 方法2
		LineIterator lineItor = FileUtils.lineIterator(new File(FILE_PATH), "UTF-8");
		while (lineItor.hasNext()) {
			System.out.println(lineItor.next());
		}
		System.out.println("#2");
	}
	
	/**
	 * 写入内容
	 * @throws IOException 
	 */
	@Test
	public void testWriteFile() throws IOException {
		// 写文件 String
		/**
		 * (new File("hey.txt"), "使用Apache commons-io FileUtils写入", "UTF-8")
		 * 最后一个true表示追加模式
		 * (new File("hey.txt"), "使用Apache commons-io FileUtils写入", "UTF-8", true)
		 */
		FileUtils.write(new File("hey.txt"), "使用Apache commons-io FileUtils写入", "UTF-8", true);
		FileUtils.writeStringToFile(new File("hey.txt"), "使用Apache commons-io FileUtils写入", "UTF-8", true);// 与write相同
		
		// 写文件 字节数组
		FileUtils.writeByteArrayToFile(new File("byte.data"), "heiheihei".getBytes(), true);
		
		// 写出列表
		List<String> lines = new ArrayList<String>();
		lines.add("hello");
		lines.add("world");
		FileUtils.writeLines(new File("heylines.txt"), "UTF-8", lines, true);
	}
	
	/**
	 * 文件拷贝
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	@Test
	public void testFileCopy() throws MalformedURLException, IOException {
		FileUtils.copyURLToFile(new URL("http://www.baidu.com"), new File("baidu.html"));
		FileUtils.copyURLToFile(new URL("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg"), new File("jerry.jpg"));
		
		String html = IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
		System.out.println(html);
	}
}
