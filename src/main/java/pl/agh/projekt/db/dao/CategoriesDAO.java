package pl.agh.projekt.db.dao;

import pl.agh.projekt.db.orm.Categories;

import java.util.List;

/**
 * Created by karol on 31.10.14.
 */
public interface CategoriesDAO {
    List<Categories> findAll();

    Categories findById(int id);

    void save(Categories categories);

    void delete(int id);
}
