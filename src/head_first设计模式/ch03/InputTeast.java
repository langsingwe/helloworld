package head_first设计模式.ch03;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Description
 * @ClassName InputTeast
 * @Author weilc
 * @Date 2020-12-13
 * @Version 1.0
 */
public class InputTeast {
    public static void main(String[] args) {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream(
                            new FileInputStream("/Users/weiliangchun/Workspace/java/helloworld/src/design/ch03/test.txt")));
            while ((c = in.read()) > 0) {
                System.out.print((char)c);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
