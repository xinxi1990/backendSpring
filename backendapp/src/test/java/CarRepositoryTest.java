import com.app.model.Car;
import com.app.server.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.app.Application;
import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)


public class CarRepositoryTest {


    @Autowired
    private CarRepository carRepository;


    @Test
    public void test() throws Exception {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);

        String regTime = carRepository.findByUserName("aa1").getRegTime();
        System.out.println(regTime);

        if (regTime == null){
            Car car = new Car();
            car.setUserName("aa1");
            car.setEmail("aa@126.com");
            car.setNickName("aa");
            car.setPassWord("123321");
            car.setRegTime(formattedDate);

            carRepository.save(car);
        }

        System.out.println(carRepository.findAll().size());

        System.out.println(regTime);

        //carRepository.delete(carRepository.findByUserName("aa1"));

    }

}
