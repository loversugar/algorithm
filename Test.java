public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 2};
        int target = search(arr, 2, 0, arr.length - 1);
        System.out.println(target);

        arr = new int[] {78, 23, 34, 56, 65};
        target = search(arr, 56, 0, arr.length - 1);
        System.out.println(target);

        arr = new int[] {100, 101, 102, 103, 1, 2, 3, 4};
        target = search(arr, 1, 0, arr.length - 1);
        System.out.println(target);

        arr = new int[] {100, 12, 13, 14, 15};
        target = search(arr, 100, 0, arr.length - 1);
        System.out.println(target);
    }

    public static int halfSearch(int[] arr, int number, int left, int right) {
        int mid;
        while(left < right) {
            mid = (left+right) / 2;
            if (number > arr[mid]) {
                left = mid + 1;
            } else if (number < arr[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int search(int[] arr, int number, int left, int right) {
        if (arr[left] == number) {
            return left;
        }
        if (arr[right] == number) {
            return right;
        }

        int mid = (left + right) / 2;

        // 左边无波动
        if (arr[mid] > arr[left]) {

            // 属于无波动部分
            if (number < arr[mid] && number > arr[left]) {
                //二分法查找
                return halfSearch(arr, number, left, mid - 1);
            } else if ((number < arr[mid] && number < arr[right])
                    || (number > arr[mid] && number > arr[right])) {
                // 属于右边有波动部分,可以进行递归
                return search(arr, number, mid + 1, right);

            }
        } else {
            //左边有波动

            if ((number > arr[mid] && number > arr[left])
                || (number < arr[mid] && number < arr[left])) {
                // 属于左边有波动部分, 进行递归
                return search(arr, number, left, mid - 1);

            } else if (number > arr[mid] && number < arr[right]) {
                //　属于右边无波动部分，　二分法查找
                return halfSearch(arr, number, mid + 1, right);

            }
        }

        return mid;
    }
}
