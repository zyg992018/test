import org.omg.CORBA.PUBLIC_MEMBER;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;

import static java.lang.Thread.currentThread;

public class TestXml {
    public static void main(String[] agrs){
        //获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            PersonHandler handler = new PersonHandler();
            parser.parse(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("aa.xml"),handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class PersonHandler extends DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
        System.out.println("---------解析开始----------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(qName+"解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch,start,length);
        System.out.println(s);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println(qName+"解析结束");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("---------解析结束----------");
    }
}