package ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weilc
 * @description
 * @className HeapOOM
 * @date 2020-07-27
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
