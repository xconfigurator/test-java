package liuyang.jaxb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author liuyang
 * @since 2021/6/1
 */
public class JAXBTest {

	JAXBContext ctx;

	@BeforeEach
	public void init() throws JAXBException {
		ctx = JAXBContext.newInstance(Book.class);
	}

	// 编码 Object -> XML
	@Test
	void marshaller() throws JAXBException {
		Book book = new Book(1, "基于Apache CXF 构建SOA应用", 76.00);

		// JAXBContext ctx = JAXBContext.newInstance(Book.class);
		Marshaller marshaller = ctx.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// !!! 这个很重要！！！ 《================！！！！！！！！！！！！
		
		marshaller.marshal(book, System.out);
	}
	
	// 解码 XML -> Object
	@Test
	void unmarshaller() throws JAXBException {
		String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><bookName>基于Apache CXF 构建SOA应用</bookName><id>1</id><price>76.0</price></book>";

		Unmarshaller unmashaller = ctx.createUnmarshaller();
		Book book = (Book) unmashaller.unmarshal(new StringReader(xmlStr));

		System.out.println(book);
	}
}
