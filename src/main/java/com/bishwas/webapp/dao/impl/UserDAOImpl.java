/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishwas.webapp.dao.impl;

import com.bishwas.webapp.dao.UserDAO;
import com.bishwas.webapp.entity.User;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository(value = "userDAO")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
    @Override
    public int insert(User user) throws ClassNotFoundException, SQLException {
       String sql="INSERT INTO bishwas(name,address) VALUES(?,?)";
      
       return jdbcTemplate.update(sql, new Object[]{user.getName(),user.getAddress()});
    
        
    }

    @Override
    public List<User> getAll() throws ClassNotFoundException, SQLException {
        String sql="SELECT * FROM bishwas";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        });
        
    }

    @Override
    public User getById(int id) throws ClassNotFoundException, SQLException {
      String sql="SELECT * FROM bishwas where id=?"; 
      return jdbcTemplate.queryForObject(sql, new Object[]{id},new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAddress(rs.getString("address"));
                return user;
            }
        });
}

   

    @Override
    public int update(User user) throws ClassNotFoundException, SQLException {
        String sql="UPDATE  bishwas set name=?,address=? WHERE id=?";      
       return jdbcTemplate.update(sql, new Object[]{user.getName(),user.getAddress(),user.getId()});
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String sql="DELETE FROM  bishwas  WHERE id=?";      
         return jdbcTemplate.update(sql, id);
    }
    
}
