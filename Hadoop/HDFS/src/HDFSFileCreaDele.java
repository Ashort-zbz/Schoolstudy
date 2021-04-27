/*提供一个HDFS內的文件的路径，对该文件进行创建和删除操作
 * 如果文件所在目录不存在，自動创建/
 * */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;

public class HDFSFileCreaDele {

	//判断路径是否存在
    public static boolean ifExist(Configuration conf, String path) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        return fs.exists(new Path(path));
    }

    //创建目录
    public static boolean mkDir(Configuration conf, String remoteDir) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        Path dirPath = new Path(remoteDir);
        boolean result = fs.mkdirs(dirPath);
        fs.close();
        return result;
    }

    //创建文件
    public static void creatFile(Configuration conf, String remoteFilePath) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        Path remotePath = new Path(remoteFilePath);
        FSDataOutputStream outputStream = fs.create(remotePath);
        outputStream.close();
        fs.close();
    }

    //删除文件
    public static boolean deleFile(Configuration conf, String remoteFilePath) throws IOException {
        FileSystem fs = FileSystem.get(conf);
        Path remotePath = new Path(remoteFilePath);
        boolean result = fs.delete(remotePath, false);
        fs.close();
        return result;
    }

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://master:9000");
		String remoteFilePath = "/user/hadoop/input/text.txt"; // HDFS路径
		String remoteDir = "/user/hadoop/input"; // HDFS路径对应的目录
		
		try {
			//判断路径是否存在，存在则删除，不存在则创建
			if(HDFSFileCreaDele.ifExist(conf, remoteFilePath)) {
				HDFSFileCreaDele.deleFile(conf, remoteFilePath);
				System.out.println("delet: " + remoteFilePath);
			}else {
				if(!HDFSFileCreaDele.ifExist(conf, remoteDir)) {//判断目录是否存在，如果目录不存在，则先创建目录
					HDFSFileCreaDele.mkDir(conf, remoteDir);
					System.out.println("creare dir: " + remoteDir);
				}
				HDFSFileCreaDele.creatFile(conf, remoteFilePath);
				System.out.println("creare : " + remoteFilePath);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
