package java核心技术.time;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @ClassName TimeTest
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public class TimeTest {
    public static void main(String[] args) throws Exception{
        m1();

    }

    static void m1() throws Exception{
        Instant start = Instant.now();
        TimeUnit.SECONDS.sleep(5);
        Instant end = Instant.now();
        Duration between = Duration.between(start, end);
        long time = between.toMillis();
        System.out.println(time);
    }
}
