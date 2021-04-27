/*给定HDFS中某一个目录，输出该目录的所有文件的读写权限/大小/创建时间/路径等信息
 * 如果该文件是目录，则递归输出该目录下所有文件相关信息
 * */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class HDFSLsDir {
	
	//显示指定文件夹所有文件的信息（递归）
	public static void lsDir(Configuration conf, String remoteDir) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		Path dirPath = new Path(remoteDir);
		//递归获取目录下所有文件，容器类
		RemoteIterator<LocatedFileStatus>remoteIterator = fs.listFiles(dirPath, true);
		//输出每个文件的信息
		while(remoteIterator.hasNext()) {
			FileStatus s = remoteIterator.next();
			System.out.println("Path: " + s.getPath().toString());
			System.out.println("Privilege: " + s.getPermission().toString());
			System.out.println("Size: " + s.getLen());
			// 返回的是时间戳,转化为时间日期格式 
			Long timeStamp = s.getModificationTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = format.format(timeStamp);
			System.out.println("Time: " + date);
			System.out.println();
		}
		fs.close();
	}
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://master:9000");
		String remoteDir = "/user/hadoop"; // HDFS路径

		try {
			System.out.println("(recursively)read all the file information in the dir: " + remoteDir);
			HDFSLsDir.lsDir(conf, remoteDir);
			System.out.println("read complete!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
