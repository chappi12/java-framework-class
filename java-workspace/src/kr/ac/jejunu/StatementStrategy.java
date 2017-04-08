package kr.ac.jejunu;

/**
 * Created by ce-416-18 on 2017-03-31.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hyh0408 on 2017. 3. 31..
 */
public interface StatementStrategy {
    public PreparedStatement makeStatement(Connection connection) throws SQLException;
}