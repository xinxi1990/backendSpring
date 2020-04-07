import com.app.Application;
import com.app.server.StudentService;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;

import javax.annotation.Resource;

public class SynchronizedTest {

    @Resource
    private Application application;

    @Test
    public void testGetSynchronizedTime()  {
        final StudentService studentService = new StudentService();
        Thread ta = new Thread(new Runnable() {
            @Override
            public void run() {
                studentService.getSynchronizedTime();
            }
        }, "A");



        Thread tb = new Thread(new Runnable() {
            @Override
            public void run() {
                studentService.getSynchronizedTime();
            }
        }, "B");

        ta.start();
        tb.start();

    }

    @Test
    public void testGetTime()  {
        final StudentService studentService = new StudentService();
        Thread ta = new Thread(new Runnable() {
            @Override
            public void run() {
                studentService.getTime();
            }
        }, "A");


        Thread tb = new Thread(new Runnable() {
            @Override
            public void run() {
                studentService.getTime();
            }
        }, "B");

        ta.start();
        tb.start();

    }

}
