public class Alogithm {
    public static void main(String[] args) {
        int[] arr = {3, 4, 3, 6, 1, 9, 23, 41, 6, 8};
        // bubbleSort(arr);
        // insertSort(arr);
        // selectionSort(arr);
        mergeSort(arr);
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
    //思想：将数组从中间分成前后两部分，然后再分成前后两部分，再将排好序的两部分合并在一起
    //核心思想是分治自相，分支是解决方案，递归是一种编程技巧
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int mid = (begin + end) / 2;
        sort(arr, begin, mid);
        sort(arr, mid + 1, end);

        //合并数组
        int[] temp = new int[arr.length];
        merge(arr, begin, mid, end, temp);
    }
    private static void merge(int[] arr, int begin, int mid, int end, int[] temp) { 
        int minB = begin;
        int minMid = mid + 1;
        int location = 0;

        while(minB <= mid && minMid <= end) {
            if (arr[minB] < arr[minMid]) {
                temp[location++] = arr[minB++];
            } else {
                temp[location++] = arr[minMid++];
            }
        }

        while (minB <= mid) {
            temp[location++] = arr[minB++];
        }

        while (minMid <= end) {
            temp[location++] = arr[minMid++];
        }

        location = 0;
        while(begin <= end) {
            arr[begin++] = temp[location++];
        }
    } 

    //快速排序
    public static void quickSort(int[] arr) {

    }

    //堆排序
    public static void heapSort(int[] arr) {

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}