package kr.ac.jejunu;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by hyh0408 on 2017. 3. 15..
 */
public class UserDaoTest {
    DaoFactory daoFactory;

    @Before //Test 돌리기전에 돌려주세요 (클라이언트에게 역할을 던져줌 DaoFactory)

    public void setup() {
        daoFactory = new DaoFactory();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        UserDao userDao = daoFactory.getUserDao(); //의존성 주입
        /*UserDao userDao = new UserDao(new JejuConnectionMaker()); 여러 개의 도메인 추가 시 Defendency 최소화해야하기에*/
        User user = userDao.get(id);
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        String name = "헐크";
        String password = "1111";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new UserDao(new JejuConnectionMaker());
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }

    /* @Test
    public void getHalla() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String name = "허윤호";
        String password = "1234";

        UserDao userDao = new UserDao(new HallaConnectionMaker());
        User user = userDao.get(id);
        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));
    }

    @Test
    public void addHalla() throws SQLException, ClassNotFoundException {
        String name = "헐크";
        String password = "1111";
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        UserDao userDao = new UserDao(new HallaConnectionMaker());
        Long id = userDao.add(user);
        User resultUser = userDao.get(id);
        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }

    */
}
