package me.ianhe.spring.action;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ian He
 * @since 2018/8/29 12:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("sgt")
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotNull() {
        Assert.assertNotNull(cd);
        cd.play();
    }
}
