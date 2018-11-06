package pers.kim.xmltodb;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.XMLWriter;
import pers.kim.jdbctext.Person;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteHandle  {
    public static void setData() {
        Person per=new Person(0,"test",0,"男");
        try {
            Element root = (Element) new DOMElement("list");
            Document doc = (Document) new DOMDocument();
            doc.setRootElement(root);
            for (int i = 0; i <10000 ; i++) {
                Element perEle = (Element) new DOMElement("person");
                perEle.addAttribute("id", i+"");
                Element name = perEle.addElement("name");
                name.setText(per.getName());
                Element age = perEle.addElement("age");
                age.setText(i+"");
                Element sex = perEle.addElement("sex");
                sex.setText(per.getSex());
                root.add(perEle);
            }
            try {
                XMLWriter write = new XMLWriter(new FileOutputStream("person"));
                write.write(doc);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
