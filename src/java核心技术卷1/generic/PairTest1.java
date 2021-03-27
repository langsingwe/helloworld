package generic;

/**
 * @author weilc
 * @description
 * @className PairTest1
 * @date 2020-05-11
 */
public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = Arrayalg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    static class Arrayalg {
        public static Pair<String> minmax(String[] a) {
            if (a == null || a.length == 0) {
                return null;
            }
            String min = a[0];
            String max = a[0];
            for (int i = 0; i < a.length; i++) {
                if (min.compareTo(a[i]) > 0) {
                    min = a[i];
                }
                if (max.compareTo(a[i]) < 0) {
                    max = a[i];
                }
            }
            return new Pair<>(min, max);
        }
    }

}
