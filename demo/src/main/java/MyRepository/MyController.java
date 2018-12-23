package MyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    /*@RequestMapping("/save")
    public String process(){
        // save a single Customer
        service.save(new Order(new Point(1,2),new Point(2,3),"lag"));

        return "Done";
    }*/
    private final OrderRepository rep;

    @Autowired
    public MyController(OrderRepository r) {
        this.rep = r;
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "";

        for(Order or : rep.findAll()){
            result += or.toString() + "<br>";
        }

        return result;
    }
   /* @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        //result = repository.findOne(id).toString();
        return result;
    }

    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName){
        String result = "";

        for(Order or: service.findByLastName(lastName)){
            result += or.toString() + "<br>";
        }

        return result;
    }*/
}