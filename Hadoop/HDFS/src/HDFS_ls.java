/*显示HDFS中指定的文件的读写权限/大小/创建时间/路径等信息*/

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class HDFS_ls {
	
	//显示指定文件的信息
	public static void ls(Configuration conf, String remoteFilePath) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		Path remotePath = new Path(remoteFilePath);
		FileStatus[] fileStatuses = fs.listStatus(remotePath);
		for(FileStatus s : fileStatuses) {
			System.out.println("Path: " + s.getPath().toString());
			System.out.println("Privilege: " + s.getPermission().toString());
			System.out.println("Size: " + s.getLen());
			// 返回的是时间戳,转化为时间日期格式
			Long timeStamp = s.getModificationTime();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = format.format(timeStamp);
			System.out.println("Time: " + date);
		}
		fs.close();
	}
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://master:9000");
		String remoteFilePath = "/user/hadoop/text.txt"; // HDFS路径
		try {
			System.out.println("read information of file: " + remoteFilePath);
			HDFS_ls.ls(conf, remoteFilePath);
			System.out.println("\nread complete!");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
