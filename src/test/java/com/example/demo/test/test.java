package com.example.demo.test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class test {

    public class JDBCTests {

        // lombok 사용안하고 log작업을 할 경우
        // private static final Logger logger = LoggerFactory.getLogger(JDBCTests.class);


        //@Ignore
        @Test
        public void testConnection() {

            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "book_ex";
            String password = "1234";

            // try(AutoCloseable 인터페이스를 구현한 객체만 사용해서 자동으로 close() 메소드를 호출되게하는 기능 제공)
            try (Connection con = DriverManager.getConnection(url, user, password)) {

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }
}