
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import  org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.boot.test.context.SpringBootTest;
import  org.springframework.test.context.junit4.SpringRunner;
import com.app.Application;
import com.app.server.Userimpl;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class UserServiceTest {

    @Autowired
    Userimpl userimpl;


    @Test
    public void test1(){
        String userName = userimpl.getUserName("mike");
        System.out.println(userName);
        assertThat(userName, containsString("mike"));
    }

    @Test
    public void test2(){
        String userName = userimpl.getUserName("tom");
        System.out.println(userName);
        assertThat(userName, containsString("other UserService"));
    }

}
