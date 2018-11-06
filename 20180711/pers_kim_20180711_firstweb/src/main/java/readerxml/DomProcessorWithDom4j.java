package readerxml;

import datalist.User;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.List;

public class DomProcessorWithDom4j implements DomProcessor {
    @Override
    public void userToHtml(List<User> user, Writer writer){
        XMLWriter xmlwrite=new XMLWriter(writer);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Element html=new DOMElement("html");
        Element body=new DOMElement("body");
        Element table=new DOMElement("table");
        for (User u:user) {
            Element tr=new DOMElement("tr");
            Element td=new DOMElement("td");
            td.setText(u.getUsername());
            Element td1=new DOMElement("td");
            td1.setText(u.getPwd());
            Element td2=new DOMElement("td");
            td2.setText(u.getMajor());
            Element td3=new DOMElement("td");
            td3.setText(format.format(u.getBirth()));
            tr.add(td);
            tr.add(td1);
            tr.add(td2);
            tr.add(td3);
            table.add(tr);
        }
        body.add(table);
        html.add(body);
        try {
            writer.write("<!DOCTYPE html>");
            xmlwrite.write(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
