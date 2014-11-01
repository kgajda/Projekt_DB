package pl.agh.projekt.db.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.agh.projekt.db.orm.Categories;

import java.util.List;

/**
 * Created by karol on 31.10.14.
 */
@Repository
public class CategoriesDAOImpl implements CategoriesDAO {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriesDAOImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    @Override
    public List<Categories> findAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Categories.class);
        return (List<Categories>) criteria.list();
    }

    @Transactional(readOnly = true)
    @Override
    public Categories findById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Categories where categoryId = :id");
        query.setParameter("id", id);
        return (Categories) query.uniqueResult();
    }

    @Transactional
    @Override
    public void save(Categories categories) {
        sessionFactory.getCurrentSession().save(categories);
    }

}
