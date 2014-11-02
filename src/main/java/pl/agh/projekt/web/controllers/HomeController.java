/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.agh.projekt.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author karol
 */
@RestController
public class HomeController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getWork(){
        return "Server is working";
    }
}
