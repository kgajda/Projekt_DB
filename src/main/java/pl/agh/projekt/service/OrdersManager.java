/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.OrdersDAO;
import pl.agh.projekt.db.orm.Orders;

/**
 *
 * @author karol
 */
@Service
public class OrdersManager {
    
    @Autowired
    private OrdersDAO ordersDAO;
    
    public List<Orders> findAllOrfers(){
        return ordersDAO.getAllOrders();
    }
    
    public Orders findByID(int id){
        return ordersDAO.findByID(id);
    }
    
    public int insertToDB(Orders orders){
       return ordersDAO.insert(orders);
    }
    
    public void update(Orders orders){
        ordersDAO.insert(orders);
    }
    public void delete(int id){
        ordersDAO.delete(id);
    }
}
