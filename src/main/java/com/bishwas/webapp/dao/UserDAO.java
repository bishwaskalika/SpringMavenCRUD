/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishwas.webapp.dao;

import com.bishwas.webapp.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dell
 */
public interface UserDAO {
    int insert(User user) throws ClassNotFoundException, SQLException;
    
    int update(User user) throws ClassNotFoundException, SQLException;
      
    List<User> getAll() throws ClassNotFoundException, SQLException;
    
    User getById( int id) throws ClassNotFoundException, SQLException;
    
    int delete( int id) throws ClassNotFoundException, SQLException;
}
