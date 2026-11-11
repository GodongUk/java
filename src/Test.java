// import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] num = new int[arr.length];
        int z = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            num[z] = arr[i];
            z++;

        }

        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
// // import java.util.Scanner;

// public class Test {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 4, 7, 8, 10, 13 };
//         int y = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if(arr[i] % 2 == 0){
//                 y++;
//             }
//         }
//         System.out.println(y);

//     }
// }

// import java.util.Scanner;

// public class Test {
//     public static void main(String[] args) {
//         int[] arr = { 23, 45, 12, 89, 34, 67 };
//         int max = 0;
//         for (int i = 0; i < arr.length; i++) {
//             if (arr[i] > max) {
//                 max = arr[i];
//             }
//         }
//         System.out.println(max);

//     }
// }

// 1번 // import java.util.Scanner;

// public class Test {
//     public static void main(String[] args) {
//         int[] arr = { 10, 20, 30, 40, 50 };
//         int sum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             sum += arr[i];
//         }
//         System.out.println(sum);

//     }
// }