package ch02;

import org.springframework.stereotype.Component;

/**
 * @author weilc
 * @version 1.0
 * @description
 * @className SgtPeppers
 * @date 2021.04.10
 */
@Component
public class SgtPeppers implements CompactDisc {

    public void play() {
        System.out.println("SgtPeppers play");
    }
}
