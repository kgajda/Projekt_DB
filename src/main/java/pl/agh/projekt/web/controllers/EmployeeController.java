package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.agh.projekt.db.orm.Employee;
import pl.agh.projekt.service.EmployeeManager;
import pl.agh.projekt.untils.loggers.NewRequestLogger;

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
    public String getAllEmployes(HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest);
        List<Employee> employeeList = employeeManager.employeeList();
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);
        } catch (JsonProcessingException e) {
            newRequestLogger.setError(e.getMessage());
            return e.getMessage();
        }
        newRequestLogger.end();
        return jeson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getAllEmployes(@PathVariable String id, HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest);
        Employee employee = employeeManager.getEmployee(Integer.valueOf(id));
        String jeson;
        try {
            jeson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
        } catch (JsonProcessingException e) {
            newRequestLogger.setError(e.getMessage());
            return e.getMessage();
        }
        newRequestLogger.end();
        return jeson;
    }


}
