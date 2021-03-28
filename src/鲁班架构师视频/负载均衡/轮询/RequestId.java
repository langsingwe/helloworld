package 负载均衡.轮询;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className RequestId
 * @date 2021.02.23
 */
public class RequestId {
    public static int id = 0;
    public static Integer getAndIncrement() {
        return id++;
    }
}
