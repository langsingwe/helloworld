package java核心技术.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DynamicAop
 * @date 2021.06.23
 */
public class DynamicAop {

    public static void main(String[] args) {
        IUserDao userDao = new UserDao();
        System.out.println("目标对象-" + userDao.getClass());
        IUserDao proxy = (IUserDao) new ProxyFactory(userDao).getProxyInstance();
        System.out.println("代理对象-" + proxy.getClass());
        proxy.save();
    }

    interface IUserDao {
        void save();
    }

    static class UserDao implements IUserDao {

        @Override
        public void save() {
            System.out.println("保存用户信息");
        }
    }

    static class ProxyFactory {
        private Object target;

        public ProxyFactory(Object target) {
            this.target = target;
        }

        public Object getProxyInstance() {
            Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
                System.out.println("开启事务");
                Object result = method.invoke(target, args);
                System.out.println("提交事务");
                return result;
            });
            return instance;
        }
    }
}

