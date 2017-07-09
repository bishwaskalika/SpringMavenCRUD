/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bishwas.webapp.controller;

import com.bishwas.webapp.dao.UserDAO;
import com.bishwas.webapp.entity.User;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dell
 */
@Controller
@RequestMapping(value = "/")
public class DefaultController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(method = RequestMethod.GET)

    public String index(Model model) {
        try {
            //User user = new User(2, "lacto", "Lacto");
            //int result = userDAO.insert(user);
            model.addAttribute("users",userDAO.getAll());
        } catch (Exception ex) {

        }

        return "index";
    }
    
  @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
   public String edit(Model model,@PathVariable("id")int id){
       try{
           model.addAttribute("user", userDAO.getById(id));
       }catch(Exception ex){
       
       }
       return "edit";
   }
   
   @RequestMapping(value = "/add",method = RequestMethod.GET)
   public String add(Model model){
      
       return "add";
   }
   
   
   @RequestMapping(value = "/save", method = RequestMethod.POST)
   public String save(User user){
       try{
           if(user.getId()==0){
           userDAO.insert(user);
           }else{
               userDAO.update(user);
           }
       }catch(Exception ex){
           
       }
       
       return "redirect:/";
   }
   
   
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
   public String delete(@PathVariable("id")int id) throws ClassNotFoundException, SQLException{
      userDAO.delete(id);
       return "redirect:/";
   }
   
}
