package 负载均衡.随机;

import 负载均衡.ServerIp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Random
 * @date 2021.02.23
 */
public class WeightRandom2 {
    public static String getServer() {
        int totalWeight = 0;
        for (Integer weight : ServerIp.WEIGHT_LIST.values()) {
            totalWeight += weight;
        }
        Random random = new Random();
        int pos = random.nextInt(totalWeight);
        for (String ip : ServerIp.WEIGHT_LIST.keySet()) {
            int weight = ServerIp.WEIGHT_LIST.get(ip);
            if (pos < weight) {
                return ip;
            }
            pos = pos - weight;
        }
        return "";
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
