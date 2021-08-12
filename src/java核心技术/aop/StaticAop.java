package java核心技术.aop;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className StaticAop
 * @date 2021.06.23
 */
public class StaticAop {
    public static void main(String[] args) {
        IUserDao userDao = new UserDaoProxy();
        userDao.save();
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

    static class UserDaoProxy implements IUserDao {

        IUserDao userDao = new UserDao();

        @Override
        public void save() {
            System.out.println("打印日志开始");
            userDao.save();
            System.out.println("打印日志结束");
        }
    }
}

