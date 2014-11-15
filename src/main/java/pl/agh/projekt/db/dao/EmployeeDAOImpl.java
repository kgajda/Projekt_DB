package pl.agh.projekt.db.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Employee;

import java.util.List;

/**
 * Created by michal on 08.11.14.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public int insert(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
        return employee.getEmployeeID();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Employees WHERE EmployeeID = :id");
        query.setParameter("id", id);
        return (Employee) query.uniqueResult();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeers() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Employees WHERE EmployeeID = :id");
        return (List<Employee>) query.uniqueResult();
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);

    }

    @Override
    @Transactional
    public void delete(int id) {
        sessionFactory.getCurrentSession().createQuery("DELETE Employees WHERE EmployeeID = :id").executeUpdate();
    }
}
