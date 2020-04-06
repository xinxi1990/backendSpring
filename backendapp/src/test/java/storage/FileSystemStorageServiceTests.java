package storage;

import java.util.Random;

import com.app.Application;
import com.app.server.FileSystemStorageService;
import com.app.server.StorageException;
import com.app.server.StorageProperties;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FileSystemStorageServiceTests {

    private static StorageProperties properties = new StorageProperties();
    private static FileSystemStorageService service;

    @BeforeClass
    public static void init() {
        properties.setLocation("target/files/" + Math.abs(new Random().nextLong()));
        service = new FileSystemStorageService(properties);
        service.init();
    }

    @Test
    public void loadNonExistent() {
        assertThat(service.load("foo.txt")).doesNotExist();
    }

    @Test
    public void saveAndLoad() {
        service.store(new MockMultipartFile("foo", "foo.txt", MediaType.TEXT_PLAIN_VALUE,
                "Hello, World".getBytes()));
        assertThat(service.load("foo.txt")).exists();
    }

    @Test
    public void saveNotPermitted() {
        assertThrows(StorageException.class, () -> {
            service.store(new MockMultipartFile("foo", "../foo.txt",
                    MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
        });
    }

    @Test
    public void savePermitted() {
        service.store(new MockMultipartFile("foo", "bar/../foo.txt",
                MediaType.TEXT_PLAIN_VALUE, "Hello, World".getBytes()));
    }

}
