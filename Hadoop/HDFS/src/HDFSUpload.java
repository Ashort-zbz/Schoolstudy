/*
 * 向HDFS上传任意文本文件，如果指定的文件存在，由用户指定是追加到原有的文件末尾还是覆盖原有文件
 * */
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import java.io.*;
/*笔记
 * 在第一次运行程序时，出现错误：
 * Permission denied: user=***, access=WRITE, inode ="/":root:supergroup:drwxr-xr-x
 * 原因是 运行HDFS上边的文件没有权限
 * 解决方法：只需要给HDFS文件权限就可以使用了，简单有效
 * 具体实现：
 * Linux 命令行中输入
 * [root@master hadoop]# hadoop fs -chmod -R 777 /
 * 就可以解决问题
 * */

public class HDFSUpload {
	
	// 判断路径是否存在
	public static boolean test(Configuration conf, String path) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		return fs.exists(new Path(path));
	}
	
	//复制文件到指定路径，如果已经存在，则覆盖
	public static void copyFromLocalFile(Configuration conf, String localFilePath, String remoteFilePath) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		Path localPath = new Path(localFilePath);
		Path remotePath = new Path(remoteFilePath);
		//fs.copyFromLocalFile 第一个参数表示是否删除源文件，第二个参数表示是否覆盖
		fs.copyFromLocalFile(false, true, localPath, remotePath);
		fs.close();
	}
	
	//追加文件内容
	public static void appendToFile(Configuration conf, String localFilePath, String remoteFilePath) throws IOException{
		FileSystem fs = FileSystem.get(conf);
		Path remotePath = new Path(remoteFilePath);
		//创建一个文件读入流
		FileInputStream in = new FileInputStream(remoteFilePath);
		//创建一个文件输出流，输出的内容追加到文件末尾
		FSDataOutputStream out = fs.append(remotePath);
		//读写文件内容
		byte[] data = new byte[1024];
		int read = -1;
		while((read = in.read(data))>0) {
			out.write(data, 0, read);
		}
		out.close();
		in.close();
		fs.close();
	}
	
	//主函数
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://master:9000");
		String localFilePath = "/home/user/hadoop/text.txt";//本地路径
		String remoteFilePath = "/user/hadoop/text.txt";//HDFS路径
		String choice = "append";		//若文件存在则追加到文件末尾
//		String choice = "overwrite";		//若文件存在则覆盖
		try {
			//判断文件是否存在
			Boolean fileExists = false;
			if(HDFSUpload.test(conf, remoteFilePath)) {
				fileExists = true;
				System.out.println(remoteFilePath + "already existed.");
			}else {
				System.out.println(remoteFilePath + " doesn't exist.");
			}
			//进行处理
			if(!fileExists) {
				//文件不存在，上传
				HDFSUpload.copyFromLocalFile(conf, localFilePath, remoteFilePath);
				System.out.println(localFilePath +" has already uploaded "+ remoteFilePath);
			}else if (choice.equals("append")) {
				//选择追加
				HDFSUpload.appendToFile(conf, localFilePath, remoteFilePath);
				System.out.println(localFilePath +" has already appended to "+ remoteFilePath);
			}else if(choice.equals("overwrite")) {
				HDFSUpload.copyFromLocalFile(conf, localFilePath, remoteFilePath);
				System.out.println(localFilePath +" has already overwriten in "+ remoteFilePath);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
