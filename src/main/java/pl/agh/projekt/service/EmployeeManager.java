package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.EmployeeDAO;
import pl.agh.projekt.db.orm.Employee;

import java.util.List;

/**
 * Created by michal on 08.11.14.
 */
@Service
public class EmployeeManager {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> employeeList() {
        return employeeDAO.getAllEmployeers();
    }

    public Employee getEmployee(int id) {
        return employeeDAO.findByID(id);
    }

}
