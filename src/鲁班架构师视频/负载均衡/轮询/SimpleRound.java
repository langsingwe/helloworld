package 负载均衡.轮询;

import 负载均衡.ServerIp;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className Random
 * @date 2021.02.23
 */
public class SimpleRound {
    private static int pos = 0;
    public static String getServer() {
        if (pos >= ServerIp.LIST.size()) {
            pos = 0;
        }
        String ip = ServerIp.LIST.get(pos);
        pos++;
        return ip;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
