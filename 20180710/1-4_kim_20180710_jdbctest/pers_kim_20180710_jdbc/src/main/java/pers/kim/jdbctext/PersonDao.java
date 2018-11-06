package pers.kim.jdbctext;

import java.util.List;

public interface PersonDao {
    public int addPerson(Person per);
    public List<Person> finAllPerson();
    public int updatePerson(int id,Person person);
    public int deletePerson(int id);
    public Person loadPerson(int id);
    public int xmlToDB(String path);
}
