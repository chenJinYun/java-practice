package pers.kim.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.XMLWriter;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlTest {
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory=SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser();
        XMLReader reader=parser.getXMLReader();
        final List<Book> bookList=new ArrayList<Book>();
        final Book[] newBook = {null};
        final String[] preTag = {""};
        reader.setContentHandler(new DefaultHandler(){
            @Override
            public void startDocument(){

            }
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if("book".equals(qName)){
                    newBook[0] = new Book();
                    newBook[0].setId(attributes.getValue("id"));
                }
                preTag[0] = qName;
            }

            @Override
            public void endElement(String uri, String localName, String qName){
                if("book".equals(qName)){
                    bookList.add(newBook[0]);
                    newBook[0] = null;
                }
                preTag[0] = null;
            }

            @Override
            public void characters(char[] ch, int start, int length){
                if(preTag!=null){
                    String content = new String(ch,start,length);
                    if("bookName".equals(preTag[0])){
                        newBook[0].setBookName(content);
                    }else if("price".equals(preTag[0])){
                        newBook[0].setPrice(content);
                    } else if("author".equals(preTag[0])){
                        newBook[0].setAuthor(content);
                    }
                }
            }
        });
        reader.parse("book");
//        write in file
        Element root=new DOMElement("books");
        Document doc=new DOMDocument();
        doc.setRootElement(root);
        for(Book bookInfo:bookList){
            Element bookEle=new DOMElement("book");
            bookEle.addAttribute("id",bookInfo.getId());
            Element name=bookEle.addElement("bookName");
            name.setText(bookInfo.getBookName());
            Element price=bookEle.addElement("price");
            price.setText(bookInfo.getPrice());
            Element author=bookEle.addElement("author");
            author.setText(bookInfo.getAuthor());
            root.add(bookEle);
        }
        XMLWriter write=new XMLWriter(new FileOutputStream("newBook"));
        write.write(doc);
    }
}
