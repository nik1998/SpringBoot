package com.example.demo;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "orders")
public class MyOrder implements Serializable {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
   /* @Column(name = "EndPoint")
    private Point EndPoint;
    @Column(name = "StartPoint")
    private Point StartPoint;*/
    @Column(name = "Status")
    private String Status;

}