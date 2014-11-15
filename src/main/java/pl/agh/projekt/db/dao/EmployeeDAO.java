package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Employee;

import java.util.List;

/**
 * Created by michal on 31.10.14.
 */
public interface EmployeeDAO {
    int insert(Employee employee);

    Employee findByID(int id);

    List<Employee> getAllEmployeers();

    void update(Employee employee);

    void delete(int id);


}
