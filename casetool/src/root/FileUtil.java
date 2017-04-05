package root;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;

import demo.CheckBoxTreeNode;

public class FileUtil {
    private static final int BUFFER_SIZE = 0x300000;// 缓冲区大小为3M

    public static CheckBoxTreeNode makeTree(File file) throws IOException {
        if (file.isFile()) {
            return (new CheckBoxTreeNode(file.getParentFile().getName().toUpperCase()));
        } else {
            CheckBoxTreeNode parentNode = new CheckBoxTreeNode(file.getName());

            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File tmpFile : files) {
                    CheckBoxTreeNode tmpNode = makeTree(tmpFile);
                    if (tmpFile.isDirectory()) {
                        parentNode.add(tmpNode);
                    }
                }
            }

            return parentNode;
        }
    }


    private boolean isXmlFile(File file) {
        if (file != null) {
            return file.getName().endsWith(".xml");
        }
        return false;
    }

    public static String readFile(String filePath) throws IOException {
        FileInputStream fin = null;
        FileChannel channel = null;
        StringBuffer fileContent = new StringBuffer();
        try {
            fin = new FileInputStream(filePath);
            channel = fin.getChannel();
            System.out.println(fin.available());
            MappedByteBuffer inputBuffer = channel.map(MapMode.READ_ONLY, 0, fin.available());
            byte[] dst = new byte[BUFFER_SIZE];// 每次读出3M的内容
            for (int offset = 0; offset < inputBuffer.capacity(); offset += BUFFER_SIZE) {

                if (inputBuffer.capacity() - offset >= BUFFER_SIZE) {

                    for (int i = 0; i < BUFFER_SIZE; i++)

                        dst[i] = inputBuffer.get(offset + i);

                } else {

                    for (int i = 0; i < inputBuffer.capacity() - offset; i++)

                        dst[i] = inputBuffer.get(offset + i);

                }

                int length = (inputBuffer.capacity() % BUFFER_SIZE == 0) ? BUFFER_SIZE
                        : inputBuffer.capacity() % BUFFER_SIZE;

                Charset cs = Charset.defaultCharset();
                //new String(dst,0,length)这样可以取出缓存保存的字符串，可以对其进行操作
                fileContent.append(cs.decode(ByteBuffer.wrap(new String(dst, 0, length).getBytes())));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                channel.close();
            }

            if (fin != null) {
                fin.close();
            }
        }

        return fileContent.toString();
    }

    public boolean writeFile(String filePath, String content) throws IOException {
        FileOutputStream fout = null;
        FileChannel channel = null;
        try {
            fout = new FileOutputStream(filePath);
            channel = fout.getChannel();
            ByteBuffer data = ByteBuffer.wrap(content.getBytes());
            data.flip();
            return channel.write(data) == data.capacity();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (channel != null) {
                channel.close();
            }

            if (fout != null) {
                fout.close();
            }
        }
        return false;
    }
}
