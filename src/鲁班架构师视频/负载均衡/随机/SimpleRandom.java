package 负载均衡.随机;

import 负载均衡.ServerIp;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Random
 * @date 2021.02.23
 */
public class SimpleRandom {
    public static String getServer() {
        java.util.Random random = new java.util.Random();
        int rand = random.nextInt(ServerIp.LIST.size());
        return ServerIp.LIST.get(rand);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
