package java核心技术卷1. thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by weiliangchun on 2019/11/27
 */
public class ThreadLocalTest1 {
    static AtomicInteger threadIndex = new AtomicInteger(1);
    //创建处理请求的线程池
    static ThreadPoolExecutor disposeRequestExecutor = new ThreadPoolExecutor(3, 3, 60, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(),
            r -> {
                Thread thread = new Thread(r);
                thread.setName("disposeRequestThread-" + threadIndex.getAndIncrement());
                return thread;
            }
    );

    //记录日志
    public static void log(String msg) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        System.out.println("****" + System.currentTimeMillis() + ",[线程:" + Thread.currentThread().getName() + "]," + stack[1] + ":" + msg);
    }

    //模拟controller
    public static void controller(List<String> dataList) {
        log("接受请求");
        service(dataList);
    }

    //模拟service
    public static void service(List<String> dataList) {
        log("执行任务");
        dao(dataList);
    }

    //模拟dao
    public static void dao(List<String> dataList) {
        log("执行数据库操作");
        //模拟插入数据
        for (String s : dataList) {
            log("插入数据" + s + "成功");
        }
    }

    public static void main(String[] args) {
        //需要插入的数据
        ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            dataList.add("数据" + i);
        }
        //模拟5个请求
        int requestCount = 5;
        for (int i = 0; i < requestCount; i++) {
            disposeRequestExecutor.execute(() -> controller(dataList));
        }
        disposeRequestExecutor.shutdown();
    }
}
