package pers.kim.xmltodb;

import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import pers.kim.jdbctext.Person;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class ReaderHandle {
    public static List<Person> readerFile(String path) throws Exception{
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();
        XMLReader reader=parser.getXMLReader();
        final List<Person> perList=new ArrayList<Person>();
        reader.setContentHandler(new DefaultHandler(){
            private Person person;
            private String preTag;
            @Override
            public void startDocument(){

            }
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if("person".equals(qName)){
                    person = new Person(0,"",0,"");
                    person.setId(Integer.parseInt(attributes.getValue("id")));
                }
                preTag = qName;
            }

            @Override
            public void endElement(String uri, String localName, String qName){
                if("person".equals(qName)){
                    perList.add(person);
                    person = null;
                }
                preTag = null;
            }

            @Override
            public void characters(char[] ch, int start, int length){
                if(preTag!=null){
                    String content = new String(ch,start,length);
                    if("name".equals(preTag)){
                        person.setName(content);
                    }else if("age".equals(preTag)){
                        person.setAge(Integer.valueOf(content));
                    } else if("sex".equals(preTag)){
                        person.setSex(content);
                    }
                }
            }
        });
        reader.parse(path);
        return perList;
    }
}
