/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.az.sample.web.controllers;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.az.sample.model.User;

/**
 *
 * @author apanasovich
 */
@Controller
public class InitController {

    @Autowired
    SessionFactory sessionFactory;
    @javax.annotation.Resource
    @Qualifier("contents")
    String content;

    @ResponseBody
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    @Transactional
    public String init() {

        SQLQuery createSQLQuery = sessionFactory.getCurrentSession().createSQLQuery(content);
        createSQLQuery.executeUpdate();

        return "ok";
    }
}
