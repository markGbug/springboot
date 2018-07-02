package my.controller;

import my.controller.common.BasicController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author zhangbj
 * @version 1.0
 * @Type
 * @Desc
 * @date 2017/12/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new BasicController()).build();
    }

}
