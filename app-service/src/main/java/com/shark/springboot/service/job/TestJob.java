package com.shark.springboot.service.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestJob {


    @Scheduled(cron = "0 */1 * * * ?")
//    @Scheduled(fixedDelay = 1000)
    public void job() {
        log.info("＝＝＝＝＝定时更新＝＝＝＝＝");
    }
}
