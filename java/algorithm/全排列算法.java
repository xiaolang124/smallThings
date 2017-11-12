
//所有元素均无相同的情况
public class Main {

    public static void main(String[] args) {
        int[] hi = {1,2,3};
        int len = hi.length;
        fullArray(hi,0,len-1);


    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                ArrayUtils.swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                ArrayUtils.swap(array, cursor, i);
            }
        }
    }
}

//存在相同元素的情况
private static boolean swapAccepted(int[] array, int start, int end) {
	for (int i = start; i < end; i++) {
		if (array[i] == array[end]) {
			return false;
		}
	}
	return true;
}

private static void fullArray(int[] array, int cursor, int end) {
	if (cursor == end) {
		System.out.println(Arrays.toString(array));
	} else {
		for (int i = cursor; i <= end; i++) {
			if (!swapAccepted(array, cursor, i)) {
				continue;
			}
			ArrayUtils.swap(array, cursor, i);
			fullArray(array, cursor + 1, end);
			ArrayUtils.swap(array, cursor, i); // 用于对之前交换过的数据进行还原
		}
	}
}
