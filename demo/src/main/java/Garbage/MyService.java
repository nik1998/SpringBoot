package Garbage;

import org.springframework.stereotype.Service;

@Service
public class MyService implements IService {

   /*@Autowired
    private OrderRepository repository;*/
    /*@Autowired
    private EntityManager entityManager;
    @Override
    public List<Order> findAll() {

        String sql = "Select * from Order";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
        //List<Order> cities = (List<Order>) repository.findAll();

    }*/
}