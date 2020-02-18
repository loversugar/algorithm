public class Alogithm {
    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 6, 1, 9, 23, 41, 6, 8};
        // bubbleSort(arr);
        // insertSort(arr);
        selectionSort(arr);
        for (int temp : arr) {
            System.out.println(temp);
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            //如果遍历一遍没有数据需要未知更换，则说明数据已经排好序
            boolean isStop = true;

            for (int j=1; j<arr.length-i; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
                    isStop = false;
                }
            }

            if (isStop) {
                break;
            }
        }
    }


    //插入排序
    public static void insertSort(int[] arr) {
        //未排序数组
        for (int i=1; i<arr.length; i++) {
            //已经排序的数组
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }


    //选择排序:思想两个数组，在未排序中数据中挑选最小的插入到
    //排好序的数组中
    public static void selectionSort(int[] arr) {
        //排好序的数组
        for (int i=0; i<arr.length-1; i++) {
            //选取未排序数组中最小的值
            int min = arr[i];
            int locationMin = i;

            //未排好序的数组
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    locationMin = j;
                }
            }

            swap(arr, i, locationMin);
        }
    }


    //归并排序
    public static void mergeSort(int[] arr) {

    }


    //快速排序
    public static void quickSort(int[] arr) {

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}