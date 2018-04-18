package IOStreams;

import java.io.*;

public class FileIOStreams {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        String fileFromName = "/Users/maximprytyka/Downloads/TestIdea/photo-1.jpg";
        String fileToName = "/Users/maximprytyka/Downloads/TestIdea/photo-2.jpg";
        // String fileFromName = "C:/test/p1.png";
        // String fileToName = "C:/test/p2.png";

        for (int i = 1; i < 64 * 1024; i*=2) {

            try {
                inputStream = new FileInputStream(fileFromName);
                outputStream = new FileOutputStream(fileToName);
                copy(inputStream, outputStream, i);

            } catch (IOException e) {
                throw new IOException("Exception when copying file from " + fileFromName + " to " + fileToName);
            } finally {
                closeQuietly(inputStream);
                closeAndFlushQuietly(outputStream);
            }

        }

    }

    private static void copy(InputStream in, OutputStream out, int bufferSize) throws IOException {

        byte[] buff = new byte[bufferSize];
        int count;
        while ((count = in.read(buff)) != -1) {
            out.write(buff, 0, count);
        }

    }

    private static void closeQuietly(InputStream in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ignore) {
                //do nothing
            }
        }

    }

    private static void closeAndFlushQuietly(OutputStream out) {
        if (out != null) {
            try {
                out.flush();
            } catch (IOException ignore) {
                //do nothing
            }
            try {
                out.close();
            } catch (IOException ignore) {
                //do nothing
            }
        }

    }

}
