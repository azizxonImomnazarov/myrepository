public class WithoutConcurency {
    public static void main(String[] args) {
        withOutConcurency();
    }

    private static void withOutConcurency() {
        float[] array = new float[100000000];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5)*Math.cos(0.4f + i/2));
        }
        long t2 = System.currentTimeMillis();
        System.out.println("All time " + (t2 - t1));
    }
}
