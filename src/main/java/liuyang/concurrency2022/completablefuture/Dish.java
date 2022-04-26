package liuyang.concurrency2022.completablefuture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
@Slf4j
@ToString
public class Dish {
    private String name;
    private int productionTime;

    public void make() {
        try {
            log.info("{}制作中...", this.toString());
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void make(int seconds) {
        try {
            log.info("{}制作中...", this.toString());
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
