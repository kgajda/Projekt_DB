package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.projekt.db.orm.Employees;
import pl.agh.projekt.service.EmployeeManager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by karol on 08.11.14.
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllEmployees() {
        List<Employees> employeesList = employeeManager.employeeList();
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeesList);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
        return jeson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getEmployee(@PathVariable String id, HttpServletRequest httpServletRequest) {

        Employees employees = employeeManager.getEmployee(Integer.valueOf(id));
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
        return jeson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteEmployee(@PathVariable String id, HttpServletRequest httpServletRequest) {
        return employeeManager.delete(Integer.valueOf(id));
    }


}
