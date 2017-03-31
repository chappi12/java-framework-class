package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ce-416-30 on 2017-03-24.
 */
/*public class DaoFactory { //중요!! Spring Framework와 같은 역할, 의존성을 가지지 않는 코드를 위해
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker()); //의존성을 이 클래스가 JejuConnectionMaker에게 주입시켜줌 DI(Defendency Injection)
    }

    public ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}>> 이게 스프링 사용하지 않고 스프링 프레임 역할의 클래스를 만들어준것것*/
@Configuration

public class DaoFactory { //중요!! Spring Framework와 같은 역할, 의존성을 가지지 않는 코드를 위해
    @Bean
    public UserDao getUserDao() {
        UserDao userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker());
        return userDao; //의존성을 이 클래스가 JejuConnectionMaker에게 주입시켜줌 DI(Defendency Injection)
    }
    @Bean
    public ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}

//DaoFactory = Spring Container 역할
