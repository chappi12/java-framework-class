package kr.ac.jejunu;

import java.sql.*;

/**
 * Created by ce-416-17 on 2017-03-15.
 */
public class UserDao {
    public User get(Long id) throws SQLException, ClassNotFoundException {
        //User 어디에 있어? Mysql
        //class를 로딩해야되겠네.
        Connection connection = getConnection();
        //쿼리를 만들어야겠네
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?"); //하얀글자는 자동완성되는부분!
        preparedStatement.setLong(1,id);
        //쿼리를 실행해야겠네
        ResultSet resultSet = preparedStatement.executeQuery();  //resultSet : 결과받기
        //실행된 결과를 객체에 매핑
        resultSet.next(); //엔트리포인트의 커서를 옮겨주는것 (데이터를 받는것, 데이터 1개당 1 next)
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        //자원해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과 리턴
        return user;
    }


    public Long add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name, password) VALUES (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();  //resultSet : 결과받기

        preparedStatement = connection.prepareStatement("select last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Long id = resultSet.getLong(1);

        resultSet.close();;
        preparedStatement.close();
        connection.close();

        return id;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://113.198.160.125:3306/jeju?characterEncoding=utf-8", "jeju", "1234"); //겹치는 부분 리펙토링할때 (method로 뺄때)는 Refactor > Extract > method 누르고 진행)
    }

}
