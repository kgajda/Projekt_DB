package pl.agh.projekt.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class, DbConfigurationForTests.class})
public class AppConfigurationSpringTest {

    @Test
    public void appConfigurationTest() {
        assertTrue(true);
    }
}