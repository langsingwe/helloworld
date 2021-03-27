package head_first设计模式.ch12;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className BeatModelInterface
 * @date 2021.01.30
 */
public interface BeatModelInterface {
    void initialize();

    void on();

    void off();

    void setBPM(int bpm);

    int getBPM();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
