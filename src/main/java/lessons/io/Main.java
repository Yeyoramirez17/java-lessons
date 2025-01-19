package lessons.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try (Reader r = new FileReader("text.txt");
            BufferedReader br = new BufferedReader(r)) {
            String ch = null;

            do {
                ch = br.readLine();
                if(ch != null) {
                    System.out.println(ch);
                }
            } while (ch != null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inputStream() {
        try {
            InputStream fis = new FileInputStream("data.txt");
            int value;
            do {
                value = fis.read();
                if (value != -1) {
                    System.out.println(value);
                } else {
                    System.out.println("Fin de la lectura");
                }
            } while (value != -1);

            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void outputStream() {
        try (OutputStream fos = new FileOutputStream("data.txt")) {

            for (var i = 65; i < 75; i++) {
                fos.write(i);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void objectOutputStream() {
        try (OutputStream fos = new FileOutputStream("object.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(71);
            numbers.add(72);
            numbers.add(73);
            numbers.add(74);

            oos.writeInt(17);
            oos.writeChar('J');
            oos.writeChar('A');
            oos.writeChar('V');
            oos.writeChar('A');
            oos.writeUTF("!Hello Word");
            oos.writeObject(numbers);

            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectInputStream() {
        try (InputStream fis = new FileInputStream("object.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            System.out.println(ois.readInt());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readChar());
            System.out.println(ois.readUTF());

            ArrayList<Integer> numbers = (ArrayList<Integer>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedOutputStream() {
        try (OutputStream os = new FileOutputStream("numbers.txt");
                BufferedOutputStream bos = new BufferedOutputStream(os)) {
            for (int i = 0; i <= 255; i++) {
                bos.write(i);
            }
            bos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void bufferedInputStream() {
        try (InputStream os = new FileInputStream("numbers.txt");
                BufferedInputStream bis = new BufferedInputStream(os)) {
            int value;
            do {
                value = bis.read();

                if (value != -1) {
                    System.out.println(value);
                }
            } while (value != -1);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writer() {
        try (Writer w = new FileWriter("text.txt")) {
            w.write("Hello Word\n");
            w.write("Working With Java\n");
            w.append('J');
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
