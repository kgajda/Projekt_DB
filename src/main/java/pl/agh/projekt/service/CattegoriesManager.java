package pl.agh.projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.projekt.db.dao.CategoriesDAO;
import pl.agh.projekt.db.orm.Categories;

import java.util.List;

/**
 * Created by karol on 01.11.14.
 */
@Service
public class CattegoriesManager {

    @Autowired
    private CategoriesDAO categoriesDAO;

    public List<Categories> getAllCategories() {
        return categoriesDAO.findAll();
    }
}