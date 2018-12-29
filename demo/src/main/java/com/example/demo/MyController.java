package com.example.demo;

import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class MyController {
    @Autowired
    OrderService rep;
    @ResponseBody
    @RequestMapping("/findall")
    public String findAll(){
        String result = "";
        for(MyOrder or : rep.findAll()){
            result += or.toString() + "<br>";
        }

        return result + "\n" ;
    }
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String save(@RequestBody MyOrder o){
        String result = "Ok";
        rep.createOrder(o);
        return result + "\n";
    }
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String insert(@RequestBody MyOrder o){
        String result = "Ok";
        rep.updateOrder(o);
        return result + "\n" ;
    }
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(name = "id", required = false) Long id){
        String result = "Ok";
        if(id!=null) {
            rep.deleteOrder(id);
        }
        return result + "\n" ;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return  "login.html";
    }
    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        SecurityContextHolder.clearContext();
        return  "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/")
    public String init()
    {
        return  "Hello";
    }
}
  /*  public ArrayList<ArrayList<String>> SelectAll() {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        String url = "jdbc:postgresql://localhost:5432/Orders";
        String user = "postgres";
        String password = "1111";
        try (Connection con = DriverManager.getConnection(url, user, password)) {
            Statement Stmt = con.createStatement();
            String sqlCommand = "SELECT * FROM Orders ";
            ResultSet RS = Stmt.executeQuery(sqlCommand);
            while (RS.next()) {
                ArrayList<String> ll = new ArrayList<String>();
                String st1 = RS.getString("Status");
                ll.add(st1);
                ans.add(ll);
            }
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(MyController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return ans;
    }

    public void Insert(MyOrder o)
    {
        String url = "jdbc:postgresql://localhost:5432/Orders";
        String user = "postgres";
        String password = "1111";
        String query = "INSERT INTO Orders(Status) VALUES(?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, o.getStatus());
            pst.executeUpdate();

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(MyController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
   }*/