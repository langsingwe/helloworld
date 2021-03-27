package java核心技术.proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className UserServiceProxy
 * @date 2021.02.08
 */
public class  UserServiceProxy  implements IUserService{

    private IUserService target;

    public UserServiceProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void add(String name) {
        System.out.println("准备向数据库中插入数据");
        target.add(name);
        System.out.println("插入结束");
    }

    public static void main(String[] args) {
        IUserService target = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy(target);
        proxy.add("小王");
    }
}
