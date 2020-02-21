package Utils;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    public static <T> T[] copy(T[] src1, T[] src2, T[] dst) {
        System.arraycopy(src1, 0, dst, 0, src1.length);
        System.arraycopy(src2, 0, dst, src1.length, src2.length);
        return dst;
    }
}
