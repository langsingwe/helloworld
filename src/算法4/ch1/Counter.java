package ch1;

/**
 * 计数器类
 *
 * @ClassName Counter
 * created by weilc on 2019/12/16 16:33
 */
public class Counter {
    private String id;
    int x = 0;

    public Counter(String id) {
        this.id = id;
    }

    public void increment() {
        x++;
    }

    public int tally() {
        return x;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", x=" + x +
                '}';
    }
}
