import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import kr.ac.jejunu.User;
import kr.ac.jejunu.UserDao;
import org.junit.Test;

import java.sql.SQLException;


/**
 * Created by ce-416-17 on 2017-03-15.
 */
public class UserDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "SeungChan";
        String password= "1111";

        UserDao userDao = new UserDao();

        User user = userDao.get(id);
        assertThat(id, is(user.getId())); //getid의 아이디가 id와 같은지 확인해줘 (Test코드에서만 사용)
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String name = "SeungChan";
        String password = "1111";

        User user = new User();
        user.setName(name);
        user.setPassword(password); //리펙토링 단축키가 먼가? 리펙토링 어떻게 하나
        UserDao userDao = new UserDao();
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }
}