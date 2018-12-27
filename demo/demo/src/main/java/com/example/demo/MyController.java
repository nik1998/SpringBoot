package com.example.demo;

import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class MyController {
    @Autowired
    OrderService rep;

   /* @Autowired
    public MyController(OrderRepository r) {
        this.rep = r;
    }*/
   public ArrayList<ArrayList<String>> SelectAll() {
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
    @RequestMapping("/findall")
    public String findAll(){
        String result = "";
        SelectAll();
        for(MyOrder or : rep.findAll()){
            result += or.toString() + "<br>";
        }

        return result;
    }
    @RequestMapping("/save")
    public String save(){
        String result = "Ok";
       // try {
            MyOrder o = new MyOrder();
            rep.createOrder(o);
        //}
        /*catch (Exception ex)
        {
            Logger lgr = Logger.getLogger(MyController.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }*/
        return result;
    }
}
