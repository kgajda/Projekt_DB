/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.db.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Orders;

/**
 *
 * @author karol
 */
@Repository
public class OrdersDAOImpl implements OrdersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Orders findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Orders WHERE OrderID = :id");
        query.setParameter("id", id);
        return (Orders) query.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Orders> getAllOrders() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Orders.class);
        return (List<Orders>) criteria.list();
    }

    @Override
    @Transactional
    public int insert(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
        return orders.getOrderId();
    }

    @Override
    @Transactional
    public void update(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE Orders WHERE OrderID = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
