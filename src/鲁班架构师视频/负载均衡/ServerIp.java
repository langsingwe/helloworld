package 负载均衡;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ServerIp
 * @date 2021.02.23
 */
public class ServerIp {
    public static final List<String> LIST = Arrays.asList(
            "127.0.0.1",
            "127.0.0.2",
            "127.0.0.3",
            "127.0.0.4",
            "127.0.0.5",
            "127.0.0.6",
            "127.0.0.7",
            "127.0.0.8",
            "127.0.0.9",
            "127.0.0.10"
    );

    public static final Map<String,Integer> WEIGHT_LIST = new LinkedHashMap<>();
    static {
        WEIGHT_LIST.put("A", 5);
        WEIGHT_LIST.put("B", 1);
        WEIGHT_LIST.put("C", 1);
//        WEIGHT_LIST.put("127.0.0.4", 2);
//        WEIGHT_LIST.put("127.0.0.5", 5);
//        WEIGHT_LIST.put("127.0.0.6", 6);
//        WEIGHT_LIST.put("127.0.0.7", 7);
//        WEIGHT_LIST.put("127.0.0.8", 6);
//        WEIGHT_LIST.put("127.0.0.9", 1);
//        WEIGHT_LIST.put("127.0.0.10", 11);
    }
}
