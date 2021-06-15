package liuyang.date;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuyang
 * @since 2021/6/15
 */
@Slf4j
public class XMLDateUtilTest {

    @Test
    void testToXMLFormat() {
        XMLGregorianCalendar xmlGregorianCalendar = XMLDateUtil.toXMLFormat(new Date());
        log.info(xmlGregorianCalendar.toXMLFormat());
    }

    @Test
    void testToDate() {
        java.util.Date date = XMLDateUtil.toData(XMLDateUtil.toXMLFormat(new Date()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sdf.format(date));
    }

}
