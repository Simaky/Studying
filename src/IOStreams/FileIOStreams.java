package IOStreams;

import java.io.*;

public class FileIOStreams {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        //for macos

        String fileFromName = "/Users/maximprytyka/Downloads/TestIdea/photo-1.jpg";
        String fileToName = "/Users/maximprytyka/Downloads/TestIdea/photo-2.jpg";

        //for windows

        // String fileFromName = "C:/test/p1.png";
        // String fileToName = "C:/test/p2.png";

        try {
            inputStream = new FileInputStream(fileFromName);
            outputStream = new FileOutputStream(fileToName);
            long startTime = System.currentTimeMillis();
            copy(inputStream, outputStream);
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime); //count copying time in milliseconds

        } catch (IOException e) {
            throw new IOException("Exception when copying from " + fileFromName + " to " + fileToName + e);
        } finally {
            closeQuietly(inputStream);
            closeFlushtQuietly(outputStream);

        }
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte buffer[] = new byte[64 * 1024]; //Array 64 kilobytes
        int count;
        while ((count = inputStream.read(buffer)) != -1) { //if read method return -1 then buffer is empty
            outputStream.write(buffer, 0, count); //Write buffer data from 0, count elements.
        }
    }

    private static void closeQuietly(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException ignore) {/*do nothing*/}
        }
    }

    private static void closeFlushtQuietly(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush(); //pull all data which buffered by jvm/os/ect. to output
            } catch (IOException ignore) {/*do nothing*/}
            try {
                outputStream.close(); //close stream
            } catch (IOException ignore) {/*do nothing*/}
        }
    }
}