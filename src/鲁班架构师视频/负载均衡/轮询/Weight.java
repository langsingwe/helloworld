package 负载均衡.轮询;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Weight
 * @date 2021.02.23
 */
public class Weight {
    private String ip;
    private int weight;
    private int currentWeight;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Weight(String ip, int weight, int currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public Weight() {
    }
}
