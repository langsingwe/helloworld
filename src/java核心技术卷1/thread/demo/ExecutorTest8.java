package thread.demo;

import java.util.concurrent.*;

/**
 * @Author wlc
 * @Date 2019-11-24 12:33
 */
public class ExecutorTest8 {
    static class GoodsModel {
        //商品名称
        String name;
        //购物开始时间
        long startTime;
        //送到的时间
        long endtTime;

        public GoodsModel(String name, long startTime, long endtTime) {
            this.name = name;
            this.startTime = startTime;
            this.endtTime = endtTime;
        }

        @Override
        public String toString() {
            return "GoodsModel{" +
                    "name='" + name + '\'' +
                    ", startTime=" + startTime +
                    ", endtTime=" + endtTime +
                    '}';
        }
    }

    /**
     * 将商品搬上楼
     *
     * @param goodsModel
     * @throws InterruptedException
     */
    static void moveUp(GoodsModel goodsModel) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("将商品搬上楼，商品信息：" + goodsModel);
    }

    static Callable<GoodsModel> buyGoods(String name, long costTime) {
        return () -> {
            long startTime = System.currentTimeMillis();
            System.out.println(startTime + "购买" + name + "下单！");
            //模拟送货耗时
            try {
                TimeUnit.SECONDS.sleep(costTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println(startTime + name + "送到了！");
            return new GoodsModel(name, startTime, endTime);
        };
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long st = System.currentTimeMillis();
        System.out.println(st + "开始购物！");
        //创建一个线程池，用于异步下单
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //异步下单购买冰箱
        Future<GoodsModel> bxFuture = executor.submit(buyGoods("冰箱", 5));
        //异步下单购买洗衣机
        Future<GoodsModel> xyjFuture = executor.submit(buyGoods("洗衣机", 2));
        //关闭线程池
        executor.shutdown();
        //等待洗衣机送到
        GoodsModel xyjGoodModel = xyjFuture.get();
        //将洗衣机搬上楼
        moveUp(xyjGoodModel);
        //等待冰箱送到
        GoodsModel bxGoodModel = bxFuture.get();
        //将冰箱搬上楼
        moveUp(bxGoodModel);

        long et = System.currentTimeMillis();
        System.out.println(et + "获取已全部送到家！");
        System.out.println("总耗时：" + (et - st));
    }

}
