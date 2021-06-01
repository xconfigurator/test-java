package liuyang.jaxb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JDK 11 里都没有这个API了！ JDK8 还有。需要引入jaxb-api以及实现
 */
@XmlRootElement
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
	private long id;
	private String bookName;
	private double price;
}
