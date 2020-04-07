package com.app;

import com.app.server.MemcacheSource;
import com.app.server.StorageProperties;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetSocketAddress;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties(StorageProperties.class)
public class Application  implements CommandLineRunner {

    protected Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Resource
    private MemcacheSource memcacheSource;

    private MemcachedClient client = null;

    @Lazy
    public static void main(String[] args) {
        // 全局懒加载写法一
        SpringApplication sa = new SpringApplication(Application.class);
        sa.setLazyInitialization(true);
        sa.run(args);

    }

    @Override
    public void run(String... args) throws Exception {
        try {
            client = new MemcachedClient(new InetSocketAddress(memcacheSource.getIp(),memcacheSource.getPort()));
        } catch (IOException e) {
            logger.error("inint MemcachedClient failed ",e);
        }
    }

    public MemcachedClient getClient() {
        return client;
    }

}
