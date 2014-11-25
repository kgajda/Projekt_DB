package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.ShippersDAO;
import pl.agh.projekt.db.orm.Shippers;

import java.util.List;

/**
 * Created by szczepan on 09.11.14.
 */
@Service
public class ShippersManager {
    @Autowired
    private ShippersDAO shippersDAO;

    public List<Shippers> findAllOrfers() {
        return shippersDAO.getAllShippers();
    }

    public int insertToDB(Shippers order) {
        return shippersDAO.insert(order);
    }

    public Shippers findByID(int integer) {
        return shippersDAO.findByID(integer);
    }

    public void delete(Integer integer) {
        shippersDAO.delete(integer);
    }
}