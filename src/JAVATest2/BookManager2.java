package JAVATest2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookManager2 implements Manageable2 {

    // 도서 정보를 저장하는 리스트
    List<Book2> books = new ArrayList<Book2>();

    // 파일 경로
    String fileName = "books.txt";

    // 도서 등록
    @Override
    public void addItem(Book2 book) {

        books.add(book);

        System.out.println("결과: 성공적으로 등록되었습니다.");

    }

    // 전체 도서 목록 조회
    @Override
    public void displayAll() {

        if (books.size() == 0) {

            System.out.println("등록된 도서가 없습니다.");

        } else {

            System.out.println("======================================");
            System.out.println("ID\t제목\t\t저자");
            System.out.println("======================================");

            for (int i = 0; i < books.size(); i++) {

                System.out.println(
                        books.get(i).getId() + "\t" +
                                books.get(i).getTitle() + "\t" +
                                books.get(i).getAuthor());

            }
            System.out.println("======================================");

        }

    }

    // 파일에 도서 정보 저장
    @Override
    public void saveToFile() {

        try {

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < books.size(); i++) {

                bw.write(books.get(i).toFileString());
                bw.newLine();

            }

            bw.close();
            fw.close();

            System.out.println("저장 및 종료되었습니다.");

        } catch (IOException e) {

            System.out.println("파일 저장 중 오류가 발생했습니다.");

        }

    }

    // 파일에서 도서 정보 불러오기
    @Override
    public void loadFromFile() {

        File file = new File(fileName);

        if (!file.exists()) {

            System.out.println("저장된 도서 파일이 없습니다.");

            return;

        }

        try {

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",", -1);

                if (data.length == 3) {

                    int id = Integer.parseInt(data[0]);

                    String title = data[1];

                    String author = data[2];

                    Book2 book = new Book2(id, title, author);

                    books.add(book);

                }

            }

            br.close();
            fr.close();

            System.out.println("도서 데이터를 불러왔습니다.");

        } catch (IOException | NumberFormatException e) {

            System.out.println("파일을 읽는 중 오류가 발생했습니다.");

        }

    }

    // 아이디로 도서 검색
    public void searchById(int id) {

        boolean found = false;

        for (int i = 0; i < books.size(); i++) {

            if (books.get(i).getId() == id) {

                System.out.println("==============================");
                System.out.println("ID : " + books.get(i).getId());
                System.out.println("제목 : " + books.get(i).getTitle());
                System.out.println("저자 : " + books.get(i).getAuthor());
                System.out.println("==============================");
                found = true;
            }
        }
        if (found == false) {
            System.out.println("해당 아이디의 도서가 없습니다.");
        }

    }

}