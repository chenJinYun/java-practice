package readerxml;

import datalist.User;

import java.io.Writer;
import java.util.List;

public interface DomProcessor {
    public void userToHtml(List<User> user, Writer writer);
}
