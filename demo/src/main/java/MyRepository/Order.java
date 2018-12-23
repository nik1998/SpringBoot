package MyRepository;
import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

@Entity
@Table(name = "Order")
public class Order implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column(name = "EndPoint")
    private Point EndPoint;
    @Column(name = "StartPoint")
    private Point StartPoint;
    @Column(name = "Status")
    private String Status;
    protected Order() {}

    public Order(Point StartPoint, Point EndPoint,String Status) {
        this.StartPoint = StartPoint;
        this.EndPoint = EndPoint;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", EndPoint=" + EndPoint +
                ", StartPoint=" + StartPoint +
                ", Status='" + Status + '\'' +
                '}';
    }
}