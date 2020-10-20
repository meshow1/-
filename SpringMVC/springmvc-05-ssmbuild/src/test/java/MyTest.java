import com.kuang.dao.BookMapper;
import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.kuang.service.BookServiceImpl;
import com.mysql.cj.Session;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;

public class MyTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = context.getBean("bookServiceImpl", BookService.class);
        for (Books books : bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }

    }
}
