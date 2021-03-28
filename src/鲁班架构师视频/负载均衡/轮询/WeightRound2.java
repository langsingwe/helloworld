package 负载均衡.轮询;

import 负载均衡.ServerIp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weilc
 * @version 1.0
 * @description 平滑加权轮询
 * @className Random
 * @date 2021.02.23
 */
public class WeightRound2 {
    private static Map<String, Weight> weightMap = new HashMap<>();
    public static String getServer() {
        int totalWeight = 0;
        for (Integer weight : ServerIp.WEIGHT_LIST.values()) {
            totalWeight += weight;
        }
        if (weightMap.isEmpty()) {
            ServerIp.WEIGHT_LIST.forEach((k,v) -> {
                weightMap.put(k, new Weight(k, v, 0));
            });
        }
        for (Weight weight : weightMap.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }
        Weight maxCurrentWeight = null;
        for (Weight weight : weightMap.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getWeight() - totalWeight);
        return maxCurrentWeight.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
