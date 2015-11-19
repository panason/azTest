package ru.atc.sample.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import ru.az.sample.model.User;
import ru.az.sample.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.az.sample.web.services.UserService;

/**
 *
 * @author apanasovich
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentDaoServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(StudentDaoServiceTest.class);

    @Autowired
    UserService userService;

    @javax.annotation.Resource
    @Qualifier("contents")
    String content;
    @Autowired
    SessionFactory sessionFactory;

    @Before

    public void before() {
        Session openSession = sessionFactory.openSession();
        SQLQuery createSQLQuery = openSession.createSQLQuery(content);
        createSQLQuery.executeUpdate();
        openSession.close();

    }

    @Test
    public void indexTest() {
        List<User> allUsers = userService.getAllUsers();
        logger.debug("{}", allUsers);

    }
}
