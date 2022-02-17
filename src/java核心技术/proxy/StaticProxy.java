package java核心技术.proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className StaticProxy
 * @date 2022.02.17
 */
public class StaticProxy {

    public static void main(String[] args) {
        SmsService smsService = new SmsServiceImpl();
        ProxySms proxySms = new ProxySms(smsService);
        proxySms.send();
    }
}

interface SmsService {
    void  send();
}

class SmsServiceImpl implements SmsService {

    @Override
    public void send() {
        System.out.println("send msg");
    }
}

class ProxySms implements SmsService {

    private SmsService smsService;

    public ProxySms(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public void send() {
        System.out.println("before send: proxy");
        smsService.send();
        System.out.println("after send: proxy");
    }
}