package 设计模式.行为型模式.责任链模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ChainOfResponsibilityPattern
 * @date 2021.08.17
 */

//抽象处理者
abstract class Handler {
    private Handler next;

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler {

    @Override
    void handleRequest(String request) {
        if ("one".equals(request)) {
            System.out.println("具体处理者1负责处理该请求");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求");
            }
        }
    }
}

class ConcreteHandler2 extends Handler {

    @Override
    void handleRequest(String request) {
        if ("two".equals(request)) {
            System.out.println("具体处理者2负责处理该请求");
        } else {
            if (getNext() != null) {
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求");
            }
        }
    }
}

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        handler1.handleRequest("two");
    }
}
