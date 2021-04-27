/*将HDFS中指定文件内容输出到终端*/
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;

public class HDFSOutputFile {
    
     // 读取文件内容
    public static void cat(Configuration conf, String remoteFilePath) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        Path remotePath = new Path(remoteFilePath);
        FSDataInputStream in = fs.open(remotePath);
        BufferedReader d = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ( (line = d.readLine()) != null ) {
            System.out.println(line);
        }
       d.close();
       in.close();
       fs.close();
    }

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.set("fs.default.name","hdfs://master:9000");
        String remoteFilePath = "/user/hadoop/text.txt";    // HDFS路径

        try {
            System.out.println("read file: " + remoteFilePath);
            HDFSOutputFile.cat(conf, remoteFilePath);
            System.out.println("\nread successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

