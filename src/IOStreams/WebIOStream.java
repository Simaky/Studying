package IOStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;

public class WebIOStream {

    public static void main(String[] args) throws IOException {
        InputStream inputStream;


        inputStream = new URL("http://google.com").openStream();
        // readFullyByByte(inputStream);
        readByteBuff(inputStream);

    }

    private static void readFullyByByte(InputStream in) throws IOException {
        while (true) {
            int x = in.read();

            if (x != -1) { //method read() return -1 when it is empty;
                System.out.print((char) x); //x is byte, byte to char = symbol
            } else {
                System.out.println("end");
                return;
            }
        }
    }

    private static void readByteBuff(InputStream in) throws IOException {
        byte buffer[] = new byte[64 * 1024];

        while (true) {
            int count = in.read(buffer);
            if (count != -1) {
                System.out.println(new String(buffer, 0, count, "UTF-8"));
            } else {
                break;
            }
        }

    }
}
