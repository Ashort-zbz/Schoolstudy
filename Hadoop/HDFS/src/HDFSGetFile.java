/*从HDFS中下载指定文件，如果本地文件与要下载的文件同名，则自动对下载的文件重命名*/
import java.io.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;


public class HDFSGetFile {
	
	//下载文件到本地
	//判断本地路径是否已经存在，若已存在，则自动重命名
	public static void copyToLocal(Configuration conf, String remoteFilePath, String localFilePath) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		Path remotePath = new Path(remoteFilePath);
		File f = new File(localFilePath);
		//如果文件名存在，自动重命名（在文件后面加上_0,_1）
		if(f.exists()) {
			System.out.println(localFilePath+" already exists.");
			Integer i = 0;
			while(true) {
				f = new File(localFilePath + "_" + i.toString());
				if(!f.exists()) {
					localFilePath = localFilePath+ "_" + i.toString();
					break;
				}
			}
			System.out.println("rename as "+localFilePath);
		}
		Path localPath = new Path(localFilePath);
		fs.copyToLocalFile(remotePath, localPath);
		fs.close();
	}
	
	
	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://master:9000");
		//本地路径
		String localFilePath = "/home/admin/hadoop/text.txt";
		//HDFS路径
		String remoteFilePath = "/user/hadoop/text.txt";
		try {
			HDFSGetFile.copyToLocal(conf, remoteFilePath, localFilePath);
			System.out.println("download successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
