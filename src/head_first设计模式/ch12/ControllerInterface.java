package head_first设计模式.ch12;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className ControllerInterface
 * @date 2021.01.30
 */
public interface ControllerInterface {
    void start();

    void stop();

    void setBPM(int bpm);

    void increaseBPM();

    void decreaseBPM();
}
