package liuyang.date.utils;

import lombok.extern.slf4j.Slf4j;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * JAXB对象中使用的是XMLGregorianCalendar对象
 * @author liuyang
 * @since 2021/6/15
 */
@Slf4j
public class XMLDateUtil {

    /**
     * @param date
     * @return 若转换发生异常则返回null
     */
    public static XMLGregorianCalendar toXMLFormat(Date date) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar xgc = null;
        try {
            xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        } catch (DatatypeConfigurationException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return xgc;
    }

    public static Date toData(XMLGregorianCalendar cal) {
        GregorianCalendar gregorianCalendar = cal.toGregorianCalendar();
        return gregorianCalendar.getTime();
    }
}
