package pl.agh.projekt.db.dao;

import java.util.List;
import pl.agh.projekt.db.orm.Orders;

/**
 * Created by karol on 31.10.14.
 */
public interface OrdersDAO {
    int insert(Orders orders);
    Orders findByID(int id);
    List<Orders> getAllOrders();
    void update(Orders orders);
    void delete(int orders);
    
}
