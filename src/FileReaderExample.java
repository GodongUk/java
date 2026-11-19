import java.io.FileReader;

public class FileReaderExample {
    public static void main(String[] args) throws Exception {
        String asd = "C:\\\\java_go\\\\godonguk\\\\src\\\\FileReaderExample.java";
        FileReader fr = new FileReader(asd);

        int readCharNo;
        char[] cbuf = new char[100];
        while ((readCharNo = fr.read(cbuf)) != -1) {
            String data = new String(cbuf, 0, readCharNo);
            System.out.print(data);
        }
        fr.close();
    }
}
