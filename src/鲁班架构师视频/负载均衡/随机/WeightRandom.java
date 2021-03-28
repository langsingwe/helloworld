package 负载均衡.随机;

import 负载均衡.ServerIp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Random
 * @date 2021.02.23
 */
public class WeightRandom {
    public static String getServer() {
        List<String> ips = new LinkedList<>();
        for (String ip : ServerIp.WEIGHT_LIST.keySet()) {
            Integer weight = ServerIp.WEIGHT_LIST.get(ip);
            for (int i = 0; i < weight; i++) {
                ips.add(ip);
            }
        }
        java.util.Random random = new java.util.Random();
        int rand = random.nextInt(ips.size());
        return ips.get(rand);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
