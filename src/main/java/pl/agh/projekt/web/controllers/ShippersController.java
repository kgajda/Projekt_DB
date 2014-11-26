package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.Shippers;
import pl.agh.projekt.service.ShippersManager;
import pl.agh.projekt.untils.loggers.NewRequestLogger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by karol on 09.11.14.
 */
@RestController
@RequestMapping(value = "/shippers")
public class ShippersController {
    @Autowired
    private ShippersManager shippersManager;
    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getAllOrders(HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest);
        List<Shippers> orders = shippersManager.findAllOrfers();
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            newRequestLogger.setError(e.getMessage());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        newRequestLogger.end();
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String insertOrders(@RequestBody String string, HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest, string);
        String id;
        try {
            Shippers order = objectMapper.readValue(string, Shippers.class);
            int i = shippersManager.insertToDB(order);
            id = String.valueOf(i);
            newRequestLogger.setResponse(id);
        } catch (IOException ex) {
            newRequestLogger.setError(ex.getMessage());
            LOGGER.error(ex.getMessage(), ex);
            return ex.getMessage();
        }
        newRequestLogger.end();
        return id;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public String getOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        NewRequestLogger newRequestLogger = new NewRequestLogger(httpServletRequest);
        Shippers order = shippersManager.findByID(Integer.valueOf(id));
        String response = null;
        try {
            response = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(order);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            newRequestLogger.setError(e.getMessage());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
        newRequestLogger.end();
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteOrder(@PathVariable("id") String id, HttpServletRequest httpServletRequest) {
        return shippersManager.delete(Integer.valueOf(id));

    }
}
