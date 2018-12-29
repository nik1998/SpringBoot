package com.example.demo;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    @RequestMapping(value = "/insert", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String insert(@RequestBody MyOrder o){
        String result = "Ok";
        rep.createOrder(o);
        return result + "\n";
    }
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public String update(@RequestBody MyOrder o){
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