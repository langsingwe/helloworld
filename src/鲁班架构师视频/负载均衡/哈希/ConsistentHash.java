package 负载均衡.哈希;

import 负载均衡.ServerIp;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ConsistentHash
 * @date 2021.02.24
 */
public class ConsistentHash {

    private static TreeMap<Integer, String> nodes = new TreeMap<>();
    private static final int NODES_COUNT = 160;

    static {
        for (String ip : ServerIp.LIST) {
            for (int i = 0; i < NODES_COUNT; i++) {
                int hash = getHash(ip + "VN" + i);
                nodes.put(hash, ip);
            }
        }
    }

    public static String getServer(String clientInfo) {
        int hash = getHash(clientInfo);
        SortedMap<Integer, String> sortedMap = nodes.tailMap(hash);
        if (null == sortedMap) {
            return nodes.get(nodes.firstKey());
        }
        return nodes.get(sortedMap.firstKey());
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}
