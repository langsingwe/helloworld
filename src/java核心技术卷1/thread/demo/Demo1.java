package java核心技术卷1. thread.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by weiliangchun on 2019/11/28
 */
public class Demo1 {
    /**
     * 获取商品基本信息
     *
     * @param goodsId
     * @return 商品基本信息
     * @throws InterruptedException
     */
    public String goodsDetailModel(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        return "商品id：" + goodsId + ",商品基本信息.....";
    }

    /**
     * 获取商品图片列表
     *
     * @param goodsId
     * @return
     * @throws InterruptedException
     */
    public List<String> goodsImgsModelList(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        return Arrays.asList("图1", "图2", "图3");
    }

    /**
     * 获取商品描述信息
     *
     * @param goodsId
     * @return
     */
    public String goodsExtModel(long goodsId) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(200);
        return "商品id：" + goodsId + ",商品描述信息.....";
    }

    //创建个线程池
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public Map<String, Object> goodsDetail(long goodsId) throws ExecutionException, InterruptedException {
        Map<String, Object> result = new HashMap<>();
        //异步获取商品基本信息
        Future<String> goodsDetailModelFuture = executorService.submit(() -> goodsDetailModel(goodsId));
        //异步获取商品图片列表
        Future<List<String>> goodsImgsModelListFuture = executorService.submit(() -> goodsImgsModelList(goodsId));
        //异步获取商品描述信息
        Future<String> goodsExtModelFuture = executorService.submit(() -> goodsExtModel(goodsId));

        result.put("goodsDetailModel", goodsDetailModelFuture.get());
        result.put("goodsImgsModelList", goodsImgsModelListFuture.get());
        result.put("goodsExtModel", goodsExtModelFuture.get());
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        Map<String, Object> map = new Demo1().goodsDetail(1L);
        System.out.println(map);
        System.out.println("耗时(ms)：" + (System.currentTimeMillis() - startTime));
    }
}
