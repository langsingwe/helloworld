package java核心技术.proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className UserServiceImpl
 * @date 2021.02.08
 */
public class UserServiceImpl implements IUserService{
    @Override
    public void add(String name) {
        System.out.println("数据库添加: " + name);
    }
}
