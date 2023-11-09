package liuyang.essentials;

/**
 * @since 2017/12/25
 * @author liuyang
 *
 */
public class Hello {

	public static void main(String[] args) {
		System.out.println("foo");

		// 进制
		int a = 0b0000000000010101;	// 0b或0B 	二进制
		int b = 021;				// 0		八进制
		int c = 21;					// 默认		十进制
		int d = 0x21;				// 0x或0X	十六进制
	}
}