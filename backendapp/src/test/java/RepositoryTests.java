import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.app.Application;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepositoryTests {

    @Resource
    private  Application application;

    @Test
    public void testSetGet()  {
        MemcachedClient memcachedClient = application.getClient();
        memcachedClient.set("testkey",1000,"666666");
        System.out.println(" ==> " + memcachedClient.get("testkey").toString());
    }

}
