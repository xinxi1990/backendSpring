import com.app.Application;
import com.app.controller.UserController;
import com.app.server.StorageService;
import com.app.server.Userimpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@WebAppConfiguration
public class UserTest {

    private static final Log log = LogFactory.getLog(UserTest.class);

    @Autowired
    private WebApplicationContext wac;
    Userimpl userimpl;
    private MockMvc mvc;


    @Before
    public void prepareMockMvc() {
        this.mvc = webAppContextSetup(wac).build();
        System.out.println(this.mvc);
    }



    @Test
    public void getUser() throws Exception {

        this.mvc.perform(get("/getusername").param("name", "mike")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("mike")));
    }

    @Test
    public void userInfo() {
        String userName = userimpl.getUserName("mike");
        Assert.assertEquals(userName, "mike");
        log.info("日志");
    }


}
