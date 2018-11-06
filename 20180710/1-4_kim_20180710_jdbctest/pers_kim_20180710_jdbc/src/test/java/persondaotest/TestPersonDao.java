package persondaotest;

import org.junit.Assert;
import org.junit.Test;
import pers.kim.jdbctext.Person;
import pers.kim.jdbctext.PersonDaoImpl;
import pers.kim.xmltodb.WriteHandle;

import java.util.ArrayList;
import java.util.List;

public class TestPersonDao {
    private static PersonDaoImpl personDao=new PersonDaoImpl();
    @Test
    public void testAddPerson() {
        Person person=new Person(0,"张三",18,"女");
        int i=personDao.addPerson(person);
        Assert.assertTrue(i>0);
    }

    @Test
    public void testFindAllPerson() {
        List<Person> perList=new ArrayList<Person>();
        perList=personDao.finAllPerson();
        Assert.assertNotNull(perList);
    }

    @Test
    public void testUpdatePerson() {
        Person pers=new Person(1,"张三",18,"男");
        int i=personDao.updatePerson(1,pers);
        Assert.assertTrue(i>0);
    }

    @Test
    public void testDeletePerson() {
        int i=personDao.deletePerson(2);
         i=personDao.deletePerson(3);
         i=personDao.deletePerson(4);
         i=personDao.deletePerson(5);
        Assert.assertTrue(i>0);
    }

    @Test
    public void testLoadPerson(){
        Person per=new Person(0,"",0,"");
        per=personDao.loadPerson(2);
        Assert.assertNotNull(per);
    }

    @Test
    public void testXMLtoDB() {
        WriteHandle.setData();
        int i=personDao.xmlToDB("person");
        Assert.assertTrue(i>0);
    }
}
