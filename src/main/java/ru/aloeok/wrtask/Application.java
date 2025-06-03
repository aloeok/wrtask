package ru.aloeok.wrtask;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.aloeok.wrtask.model.Subscription;
import ru.aloeok.wrtask.model.User;
import ru.aloeok.wrtask.service.UserSubscriptionService;

@Slf4j
@SpringBootApplication(
        scanBasePackages = {
                "ru.aloeok.wrtask"
        },
        exclude = {
                JacksonAutoConfiguration.class
        }
)
@EnableJpaRepositories(
        basePackages = {
                "ru.aloeok.wrtask.repository"
        }
)
@EntityScan(
        basePackages = {
                "ru.aloeok.wrtask.entity"
        }
)
public class Application {
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Autowired
//    private UserSubscriptionService userSubscriptionService;
//
//    @SneakyThrows
//    @EventListener(ApplicationReadyEvent.class)
//    public void onStartup() {
//        log.info("===================== Creating user");
//        Long uid1 = userSubscriptionService.createUser("u1");
//        log.info("===================== Created user with id={}", uid1);
//
//        log.info("===================== Searching user with id={}", uid1);
//        User user1 = userSubscriptionService.getUser(uid1);
//        log.info("===================== Found user {} with id={}", user1.getUsername(), user1.getId());
//
//
//
//        log.info("===================== Creating subscription");
//        Long sid1 = userSubscriptionService.createSubscription("VK");
//        log.info("===================== created subscription with id={}", sid1);
//
//
//
//        log.info("===================== Adding user[{}] subscription[{}]", uid1, sid1);
//        userSubscriptionService.addUserSubscription(uid1, sid1);
//        log.info("===================== Added user subscription");
//
//
//
//        log.info("===================== Listing subscriptions for user[{}]", uid1);
//        log.info("{}", userSubscriptionService.getUserSubscriptions(uid1)
//                .stream().map(Subscription::getName).toList());
//        log.info("===================== ");
//
//
//
//        log.info("===================== Creating subscription");
//        Long sid2 = userSubscriptionService.createSubscription("Yandex");
//        log.info("===================== created subscription with id={}", sid2);
//
//        log.info("===================== Creating subscription");
//        Long sid3 = userSubscriptionService.createSubscription("Youtube");
//        log.info("===================== created subscription with id={}", sid3);
//
//        log.info("===================== Creating subscription");
//        Long sid4 = userSubscriptionService.createSubscription("Spotify");
//        log.info("===================== created subscription with id={}", sid4);
//
//
//        log.info("===================== Creating user");
//        Long uid2 = userSubscriptionService.createUser("u2");
//        log.info("===================== Created user with id={}", uid2);
//
//
//        log.info("===================== Adding user[{}] subscription[{}]", uid2, sid1);
//        userSubscriptionService.addUserSubscription(uid2, sid1);
//        log.info("===================== Added user subscription");
//
//        log.info("===================== Adding user[{}] subscription[{}]", uid2, sid3);
//        userSubscriptionService.addUserSubscription(uid2, sid3);
//        log.info("===================== Added user subscription");
//
//        log.info("===================== Adding user[{}] subscription[{}]", uid2, sid4);
//        userSubscriptionService.addUserSubscription(uid2, sid4);
//        log.info("===================== Added user subscription");
//
//
//
//        log.info("===================== Listing top subscriptions: {}",
//                userSubscriptionService.getTop3Subscriptions()
//                        .stream().map(Subscription::getName).toList());
//    }
}
