package head_first设计模式.ch12;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className DJTest
 * @date 2021.01.30
 */
public class DJTest {
    public static void main(String[] args) {
        BeatModel model = new BeatModel();
        BeatController controller = new BeatController(model);
    }
}
