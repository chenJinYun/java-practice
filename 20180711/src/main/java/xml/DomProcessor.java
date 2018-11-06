package xml;

import bean.User;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Create by DomProcessor on 7/11/2018
 */
public interface DomProcessor {

    public void usersToHtml(List<User> users, Writer writer)  throws IOException;
}
