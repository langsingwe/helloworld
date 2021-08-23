package 设计模式.行为型模式.状态模式;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ThreadState
 * @date 2021.08.18
 */

class ThreadContext {
    private ThreadState state;

    public ThreadContext() {
        state = new New();
    }

    public ThreadState getState() {
        return state;
    }

    public void setState(ThreadState state) {
        this.state = state;
    }

    public void start() {
        ((New) state).start(this);
    }
    public void getCPU() {
        ((Runnable) state).getCPU(this);
    }
    public void suspend() {
        ((Running) state).suspend(this);
    }
    public void stop() {
        ((Running) state).stop(this);
    }
    public void resume() {
        ((Blocked) state).resume(this);
    }
}

abstract class ThreadState {
    String stateName;
}

class New extends ThreadState {
    public New() {
        stateName = "new";
        System.out.println("当前线程处于：new 状态");
    }

    public void start(ThreadContext ctx) {
        System.out.println("调用start()方法 ->");
        if ("new".equals(stateName)) {
            ctx.setState(new Runnable());
        } else {
            System.out.println("当前线程不是 new 状态，不能调用start()方法.");
        }
    }
}

class Runnable extends ThreadState {
    public Runnable() {
        stateName = "runnable";
        System.out.println("当前线程处于：runnable 状态");
    }

    public void getCPU(ThreadContext ctx) {
        System.out.println("获取cpu");
        if ("runnable".equals(stateName)) {
            ctx.setState(new Running());
        } else {
            System.out.println("当前线程不是 runnable 状态，不能获取cpu.");
        }
    }
}

class Running extends ThreadState  {
    public Running() {
        stateName = "running";
        System.out.println("当前线程处于：running 状态");
    }

    public void suspend(ThreadContext ctx) {
        System.out.println("调用suspend()方法");
        if (stateName.equals("running")) {
            ctx.setState(new Blocked());
        } else {
            System.out.println("当前线程不是运行状态，不能调用suspend()方法.");
        }
    }

    public void stop(ThreadContext hj) {
        System.out.print("调用stop()方法-->");
        if (stateName.equals("running")) {
            hj.setState(new Dead());
        } else {
            System.out.println("当前线程不是运行状态，不能调用stop()方法.");
        }
    }
}

class Blocked extends ThreadState {
    public Blocked() {
        stateName = "blocked";
        System.out.println("当前线程处于：阻塞状态.");
    }
    public void resume(ThreadContext hj) {
        System.out.print("调用resume()方法-->");
        if (stateName.equals("blocked")) {
            hj.setState(new Runnable());
        } else {
            System.out.println("当前线程不是阻塞状态，不能调用resume()方法.");
        }
    }
}

class Dead extends ThreadState {
    public Dead() {
        stateName = "dead";
        System.out.println("当前线程处于：死亡状态.");
    }
}


public class ThreadStateTest {
    public static void main(String[] args) {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}
