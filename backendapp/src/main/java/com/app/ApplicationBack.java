//package com.app;
//
//import com.app.relationaldataaccess.Customer;
//import com.app.server.Receiver;
//import com.app.server.StorageService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import com.app.consumingrest.Quote;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.client.RestTemplate;
//import com.app.server.StorageProperties;
//import com.app.server.StorageService;
////import org.springframework.data.redis.connection.RedisConnectionFactory;
////import org.springframework.data.redis.core.StringRedisTemplate;
////import org.springframework.data.redis.listener.PatternTopic;
////import org.springframework.data.redis.listener.RedisMessageListenerContainer;
////import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
////import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.scheduling.annotation.EnableScheduling;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
////@EnableDiscoveryClient
////@EnableEurekaClient
//
//@EnableScheduling
//@SpringBootApplication
//@RestController
//// mapper 接口类扫描包配置
//@EnableConfigurationProperties(StorageProperties.class)
//
//
//public class Application implements CommandLineRunner {
//
//    private static final Logger log = LoggerFactory.getLogger(Application.class);
//
//
////    @Autowired
////    JdbcTemplate jdbcTemplate;
////
////    @Bean
////    public RestTemplate restTemplate(RestTemplateBuilder builder) {
////        return builder.build();
////    }
//
//
////    @Bean
////    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
////        return args -> {
////            Quote quote = restTemplate.getForObject(
////                    "https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
////            log.info(quote.toString());
////        };
////    }
////
////
////    @Bean
////    CommandLineRunner init(StorageService storageService) {
////        log.info("init ==>");
////        return (args) -> {
////            storageService.deleteAll();
////            storageService.init();
////        };
////    }
//
//
//
//    @Value("${server.port}")
//    String port;
//
//    public int postCount = 0 ;
//
//
//    @GetMapping("/hi")
//    public String home(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {
//        System.out.println("##################### get requests #####################");
//        return "hi " + name + " ,i am from port:" + port;
//    }
//
//    @GetMapping("/getcity")
//    public String getlist(@RequestParam(value = "name", defaultValue = "beijing") String name) {
//        System.out.println(String.format("##################### get getcity %s #####################", String.valueOf(postCount)));
//        postCount ++;
//        String resultString = "{\"result\":" + postCount  + "}";
//        return resultString;
//    }
//
//
//
////    @Bean
////    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
////                                            MessageListenerAdapter listenerAdapter) {
////
////        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
////        container.setConnectionFactory(connectionFactory);
////        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
////
////        return container;
////    }
////
////    @Bean
////    MessageListenerAdapter listenerAdapter(Receiver receiver) {
////        return new MessageListenerAdapter(receiver, "receiveMessage");
////    }
////
////    @Bean
////    Receiver receiver() {
////        return new Receiver();
////    }
////
////    @Bean
////    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
////        return new StringRedisTemplate(connectionFactory);
////    }
//
//    public static void main(String[] args) throws InterruptedException {
//
//        log.info("SpringApplication Start ==> ");
//
//        ApplicationContext ctx = SpringApplication.run(Application.class, args);
////
////        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
////        Receiver receiver = ctx.getBean(Receiver.class);
////
////        System.out.printf(String.valueOf(receiver.getCount()));
////
////        while (receiver.getCount() == 0) {
////
////            log.info("Sending message...");
////            template.convertAndSend("chat", "Hello from Redis!");
////            Thread.sleep(500L);
////        }
////
////        System.exit(0);
//    }
//
//    @Bean
//    public void beantest() {
//        System.out.printf("beantest ==》");
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    }
//
////
////    /***
////     * mysql操作
////     * @param strings
////     * @throws Exception
////     */
////    @Override
////    public void run(String... strings) throws Exception {
////
////        log.info("Creating tables");
////
////        jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
////        jdbcTemplate.execute("CREATE TABLE customers(" +
////                "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
////
////
////        jdbcTemplate.execute("DROP TABLE IF EXISTS student");
////        jdbcTemplate.execute("CREATE TABLE student(" +
////                "id SERIAL, name VARCHAR(255), email VARCHAR(255))");
////
////        // Split up the array of whole names into an array of first/last names
////        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
////                .map(name -> name.split(" "))
////                .collect(Collectors.toList());
////
////        // Use a Java 8 stream to print out each tuple of the list
////        splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
////
////        // Uses JdbcTemplate's batchUpdate operation to bulk load data
////        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
////
////        log.info("Querying for customer records where first_name = 'Josh':");
////        jdbcTemplate.query(
////                "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
////                (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
////        ).forEach(customer -> log.info(customer.toString()));
////    }
//
//
//}
//
