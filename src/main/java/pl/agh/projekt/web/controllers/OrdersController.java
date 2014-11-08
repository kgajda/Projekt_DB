/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.Orders;
import pl.agh.projekt.service.OrdersManager;

/**
 *
 * @author karol
 */
@RequestMapping(value = "/orders")
@RestController
public class OrdersController {
    @Autowired
    private OrdersManager ordersManager;
    @Autowired
    private ObjectMapper objectMapper;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);
    
    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public String getAllOrders(){
        List<Orders> orders = ordersManager.findAllOrfers();
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(orders);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public String insertOrders(@RequestBody String string){
        try {
            LOGGER.info("Message: "+string);
            Orders order = objectMapper.readValue(string, Orders.class);
            int id = ordersManager.insertToDB(order);
            return String.valueOf(id);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
            return ex.getMessage();
        }
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    public String getOrder(@PathVariable("id") String id){
        Orders prder = ordersManager.findByID(Integer.valueOf(id));
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(prder);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE,produces = "application/json")
    public void deleteOrder(@PathVariable("id") String id){
        ordersManager.delete(Integer.valueOf(id));
    }
    
}
