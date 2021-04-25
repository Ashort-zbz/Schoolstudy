import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;

public class HDFSFileExist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String fileName = "/user/hadoop/test/.bashrc";
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", "hdfs://master:9000");
			conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
			FileSystem fs = FileSystem.get(conf);
			if(fs.exists(new Path(fileName))) {
				System.out.println("exist");
			}else {
				System.out.println("no exist");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
