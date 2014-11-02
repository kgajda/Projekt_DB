package pl.agh.projekt.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import pl.agh.projekt.db.orm.Categories;
import pl.agh.projekt.service.CattegoriesManager;

import java.util.List;

/**
 * Created by karol on 01.11.14.
 */
@RestController
public class CategoriesController {
    @Autowired
    private CattegoriesManager cattegoriesManager;
    @Autowired
    private ObjectMapper objectMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesController.class);

    @RequestMapping(value = "/categories", method = RequestMethod.GET, produces = "application/json")
    public String getCategories() {
        List<Categories> categorieses = cattegoriesManager.getAllCategories();
        try {
            return objectMapper.writeValueAsString(categorieses);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new HttpServerErrorException(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
