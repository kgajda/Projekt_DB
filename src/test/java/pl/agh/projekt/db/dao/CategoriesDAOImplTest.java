package pl.agh.projekt.db.dao;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import pl.agh.projekt.configuration.AppConfigurationSpring;
import pl.agh.projekt.configuration.DbConfigurationForTests;
import pl.agh.projekt.db.orm.Categories;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class, DbConfigurationForTests.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/sources.xml")
@DatabaseTearDown(value = "/sources.xml", type = DatabaseOperation.DELETE_ALL)
public class CategoriesDAOImplTest {

    @Autowired
    private CategoriesDAO categoriesDAO;

    @Test
    public void testFindAll() throws Exception {
        List<Categories> categorieses = categoriesDAO.findAll();
        assertTrue(!categorieses.isEmpty());
    }

    @Test
    public void testFindById() throws Exception {
        Categories categories = categoriesDAO.findById(1);
        assertEquals(categories.getCategoryId(), 1);
    }

    @Test
    public void testSave() throws Exception {
        Categories categories = new Categories();
        categories.setCategoryId(2);
        categoriesDAO.save(categories);
    }
}