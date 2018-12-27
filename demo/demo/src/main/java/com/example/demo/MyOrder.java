package com.example.demo;
import lombok.Data;
import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;


//@Data
@Entity
@Table(name = "orders")
public class MyOrder implements Serializable {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
/*
    public Point getEndPoint() {
        return EndPoint;
    }

    public void setEndPoint(Point endPoint) {
        EndPoint = endPoint;
    }

    public Point getStartPoint() {
        return StartPoint;
    }

    public void setStartPoint(Point startPoint) {
        StartPoint = startPoint;
    }
*/
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
   /* @Column(name = "EndPoint")
    private Point EndPoint;
    @Column(name = "StartPoint")
    private Point StartPoint;
    @Column(name = "Status")*/
    private String Status;
    //protected MyOrder() {}
/*
    public MyOrder(Point StartPoint, Point EndPoint,String Status) {
        this.StartPoint = StartPoint;
        this.EndPoint = EndPoint;
    }*/

}