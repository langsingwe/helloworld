package ch02;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className CDPlayerTest
 * @date 2021.04.10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    CompactDisc disc;

    @Test
    public void testNotNull() {
        Assert.assertNotNull(disc);
    }
}
