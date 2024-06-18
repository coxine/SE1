public class LowHighSwap {
    // 请实现swap方法
    public String swap(int[] array) {
        int left = 0;
        int right = array.length - 1;
        for (; left <= right; left++, right--) {
            if (array[left] > array[right]) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
        }
        return array2String(array);
    }

    // 此方法无需修改
    private String array2String(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int n : array) {
            sb.append(n);
        }
        return sb.toString();
    }
}
