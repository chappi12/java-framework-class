import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import javafx.application.Application;
import kr.ac.jejunu.DaoFactory;
import kr.ac.jejunu.User;
import kr.ac.jejunu.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;


/**
 * Created by ce-416-17 on 2017-03-15.
 */
public class UserDaoTest {
    UserDao userDao;
    @Before
    public void setup() {
//        daoFactory = new DaoFactory();
//        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        userDao = context.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "승찬";
        String password= "1234";

        User user = userDao.get(id);
        assertThat(id, is(user.getId())); //getid의 아이디가 id와 같은지 확인해줘 (Test코드에서만 사용)
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String name = "Chappi";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password); //리펙토링 단축키가 먼가? 리펙토링 어떻게 하나
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException {
        String name = "Chappi";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);

        String changedName = "승찬";
        String changedPassword= "1234";

        user.setId(id);
        user.setName(changedName);
        user.setPassword(changedPassword);

        userDao.update(user);

        User changedUser = userDao.get(id);

        assertThat(id, is(changedUser.getId()));
        assertThat(changedName, is(changedUser.getName()));
        assertThat(changedPassword, is(changedUser.getPassword()));
    }

    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        String name = "Chappi";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password);
        Long id = userDao.add(user);

        userDao.delete(id);

        User deletedUser = userDao.get(id);

        assertThat(deletedUser, nullValue());
    }
}