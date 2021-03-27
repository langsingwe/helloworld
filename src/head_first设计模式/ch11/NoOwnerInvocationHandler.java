package head_first设计模式.ch11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description
 * @ClassName OwnerInvocationHandler
 * @Author weilc
 * @Date 2021-01-28
 * @Version 1.0
 */
public class NoOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NoOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("get")) {
            return method.invoke(person, args);
        } else if (method.getName().equals("setHotOrNotRating")) {
            return method.invoke(person, args);
        } else if (method.getName().startsWith("set")) {
            throw new IllegalAccessException();
        }
        return null;
    }
}
