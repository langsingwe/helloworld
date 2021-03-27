package java核心技术.stream;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @ClassName WordCount
 * @Author weilc
 * @Date 2020-11-12
 * @Version 1.0
 */
public class WordCount {
    public static void main(String[] args) {
        File file = new File("/Users/weiliangchun/Downloads/test.txt");
        try {
            String contents = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())),StandardCharsets.UTF_8);
            System.out.println(contents);
            List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
            int cnt = 0;
            for (String word : words) {
                if (word.length() > 4) {
                    System.out.println(word);
                    cnt++;
                }
            }
            System.out.println("cnt=" + cnt);
            long count = words.stream().filter(w -> w.length() > 4).count();
            System.out.println("count=" + count);
        } catch (Exception e) {

        }

    }
}
