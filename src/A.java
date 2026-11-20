// import java.io.FileReader;

// public class A {
//     public class A {
//     @Override
// public void loadFromFile() {
//     try {
//         FileReader fr = new FileReader("C:/Temp/book.txt");

//         int data;
//         String temp = "";
//         int count = 0;

//         while ((data = fr.read()) != -1) {

//             if (data == 13) {
//                 continue;
//             }

//             if (data == 10) {

//                 if (count == 0) {
//                     listId.add(Integer.parseInt(temp));
//                 } else if (count == 1) {
//                     listTitle.add(temp);
//                 } else if (count == 2) {
//                     listAuthor.add(temp);
//                 }

//                 temp = "";
//                 count++;

//                 if (count == 3) {
//                     count = 0;
//                 }

//             } else {
//                 temp += (char) data;
//             }
//         }

//         fr.close();

//     } catch (Exception e) {
//         System.out.println("에러뜸");
//     }
// }
// }
// }
