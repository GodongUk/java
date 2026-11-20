package JAVAtest;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements Manageable {
    Scanner scanner = new Scanner(System.in);
    List<Book> books = new ArrayList<>();

    private List<Integer> listId = new ArrayList<Integer>();
    private List<String> listTitle = new ArrayList<String>();
    private List<String> listAuthor = new ArrayList<String>();
    private int id;
    private String title;
    private String author;
    Book book = new Book();

    @Override
    public void addItem(Book book) {
        try {
            System.out.print("ID: ");
            String id_1 = scanner.nextLine();
            id = Integer.parseInt(id_1);
            listId.add(id);
            System.out.print("제목: ");
            title = scanner.nextLine();
            listTitle.add(title);
            System.out.print("저자: ");
            author = scanner.nextLine();
            listAuthor.add(author);
            System.out.println("결과: 성공적으로 등록되었습니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력해주세요");
        }

    }

    @Override
    public void displayAll() {
        if (listId.size() == 0) {
            System.out.println("등록된 도서가 없습니다.");
        } else {

            for (int i = 0; i < listId.size(); i++) {
                System.out.println("ID : " + listId.get(i));
                System.out.println("제목 : " + listTitle.get(i));
                System.out.println("저자 : " + listAuthor.get(i));
                System.out.println("====================================");
            }
        }

    }

    @Override
    public void saveToFile() {
        try {
            File file = new File("C:/Temp/books.txt");
            FileWriter fw = new FileWriter(file);
            for (int i = 0; i < listId.size(); i++) {
                fw.write(listId.get(i) + "\r\n");
                fw.write(listTitle.get(i) + "\r\n");
                fw.write(listAuthor.get(i) + "\r\n");
                fw.flush();
            }
            fw.close();
            System.out.println("저장 및 종료되었습니다.");
        } catch (Exception e) {
            System.out.println("오류뜸");
        }
    }

    @Override
    public void loadFromFile() {
        try {
            FileReader fr = new FileReader("C:/Temp/books.txt");

            int data;
            String temp = "";
            int count = 0;
            while ((data = fr.read()) != -1) {
                if (data == 13) {
                    continue;
                }
                if (data == 10) {
                    if (count == 0) {
                        listId.add(Integer.parseInt(temp));
                    } else if (count == 1) {
                        listTitle.add(temp);
                    } else if (count == 2) {
                        listAuthor.add(temp);
                    }
                    temp = "";
                    count++;
                    if (count == 3) {
                        count = 0;
                    }
                } else {
                    temp += (char) data;
                }
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("에러뜸");
        }
    }
}
