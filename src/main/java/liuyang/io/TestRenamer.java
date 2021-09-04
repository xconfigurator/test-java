package liuyang.io;

import java.io.File;

public class TestRenamer {

	// private static final String FILE_PATH = "W:/FFOutput";

	private static final String FILE_PATH = "E:\\01_考研视频\\数学_张宇_2022_update\\00.电子书";
	// private static final String REPLACE_AIM = "【20.21免费公众号：考研草堂／QQ群1132509296】";
	// private static final String REPLACE_AIM = "【20.21免费公众号：考研草堂／QQ群1037079685】";
	private static final String REPLACE_AIM = "【22.21免费公众号：考研草堂，后台回复“获取资料”即可获取22和21资料汇总，QQ群1037079685】";

	public static void main(String[] args) {
		File file = new File(FILE_PATH);
		String[] names = file.list();
		for (String str : names) {
			File f = new File(FILE_PATH + File.separator + str);
			if (!f.isDirectory()) {
				// System.out.println(f.getName().replaceAll(REPLACE_AIM, ""));
				File newFile = new File(FILE_PATH + File.separator + f.getName().replaceAll(REPLACE_AIM, ""));
				System.out.println(newFile.getAbsolutePath());
				f.renameTo(newFile);
				/*
				File newFile = new File("马原_" + f.getName());
				System.out.println(newFile.getName());
				f.renameTo(newFile);
				 */
			}
		}
	}

}