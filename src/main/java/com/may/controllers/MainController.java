package com.may.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.may.entities.Info;
import com.may.entities.User;

/**
 *  Created by EugenMaysyuk on 1/15/2016.
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    public SessionFactory sessionFactory;

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(ModelMap model) {

        Session session = sessionFactory.openSession();

        User user = new User();
        user.setUsername( "Test" );
        user.setPassword( "123456" );
        user.setAge(23);

        Info info = new Info();
        info.setBankId( 1 );
        info.setText1( "text1" );
        info.setText2( "text2" );
        info.setText3( "text3" );

        session.persist( user );
        session.persist( info );

        session.close();

        return "index";
    }

}
