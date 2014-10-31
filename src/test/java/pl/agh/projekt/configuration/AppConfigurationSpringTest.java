package pl.agh.projekt.configuration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationSpring.class,DbConfiguration.class})
public class AppConfigurationSpringTest {

    @Test
    public void appConfigurationTest(){
        assertTrue(true);
    }
}