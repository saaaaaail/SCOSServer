package esd.scos.servlet;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
 
/**
 * 封装了XML转换成object，object转换成XML的代码
 * 
 * @author Steven
 * 
 */
public class XMLUtil {
	/**
	 * 将对象直接转换成String类型的 XML输出
	 * 
	 * @param obj
	 * @return
	 */
	public static String convertToXml(Object obj) {
		String xml = null;
		  JAXBContext context;
		  ByteArrayOutputStream outputStream = null ;
		  try {
		   context = JAXBContext.newInstance(obj.getClass());
		   Marshaller m = context.createMarshaller();
		   //m.setProperty(Marshaller.JAXB_ENCODING, encoding);
		   m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		   //设置转换编码
		   String charsetName = System.getProperty("file.encoding");
		   m.setProperty(Marshaller.JAXB_ENCODING, charsetName);
		   //document level event 
		   m.setProperty(Marshaller.JAXB_FRAGMENT, false);
		
		   outputStream = new ByteArrayOutputStream();
		   m.marshal(obj, outputStream);
		   xml=outputStream.toString("gbk");
		  } catch (JAXBException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (UnsupportedEncodingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }finally{
		   if(outputStream != null){
		    try {
		     outputStream.close() ;
		    } catch (IOException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    }
		   }
		  }
		  return xml ;

	}
 
	public static String ToXml(UpdateFood uf) {

		XStream xStream = new XStream(new DomDriver("UTF-8"));

		xStream.alias("xml", uf.getClass());

		return xStream.toXML(uf);

		}
		
}
