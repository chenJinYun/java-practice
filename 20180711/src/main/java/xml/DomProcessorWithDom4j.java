package xml;

import bean.User;
import data.StaticData;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.dom.DOMDocument;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.XMLWriter;
import util.UserUtil;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

/**
 * Create by DomProcessorWithDom4j on 7/11/2018
 */
public class DomProcessorWithDom4j implements DomProcessor {

    @Override
    public void usersToHtml(List<User> users, Writer writer) throws IOException {
        XMLWriter xmlWriter = new XMLWriter(writer);
        Document doc = new DOMDocument();
        Element html = new DOMElement("html");
        doc.setRootElement(html);
        Element body = new DOMElement("body");
        html.add(body);
        Element table = new DOMElement("table");
        body.add(table);
        users.forEach(user -> {
            Element tr = new DOMElement("tr");
            Element td0 = new DOMElement("td");
            td0.setText(user.getName());
            Element td1 = new DOMElement("td");
            td1.setText(user.getPassWord());
            Element td2 = new DOMElement("td");
            td2.setText(UserUtil.format.format(user.getBirth()));
            Element td3 = new DOMElement("td");
            td3.setText(user.getMajor());
            tr.add(td0);
            tr.add(td1);
            tr.add(td2);
            tr.add(td3);
            table.add(tr);
        });
        writer.write("<!DOCTYPE html>");
        xmlWriter.write(html);
    }

}
