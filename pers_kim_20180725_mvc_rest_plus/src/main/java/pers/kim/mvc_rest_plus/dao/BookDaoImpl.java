package pers.kim.mvc_rest_plus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pers.kim.mvc_rest_plus.pojo.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Create on 7/26/2018
 *
 * @Author Kim
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate template;
    @Value(value = "insert into books(id,name,price,publishDate,author) values(kim_book.nextval,?,?,?,?)")
    private String addSql;
    @Value(value = "update books set name=?,price=?,publishDate=?,author=? where id=?")
    private String updateSql;
    @Value(value = "delete from books where id=?")
    private String deleteSql;
    @Value(value = "select id,name,price,publishDate,author from books")
    private String selectSql;
    @Override
    public int addBook(Book book) {
        return template.update(addSql,book.getName(),book.getPrice(),book.getPublishDate(),book.getAuthor());
    }

    @Override
    public int deleteBook(int id) {
        return template.update(deleteSql,id);
    }

    @Override
    public int updateBook(Book book) {
        return template.update(updateSql,book.getName(),book.getPrice(),book.getPublishDate(),book.getAuthor(),book.getId());
    }

    @Override
    public List<Book> findAllBook() {
        return template.query(selectSql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book=new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublishDate(resultSet.getDate("publishDate"));
                return book;
            }
        });
    }
}
