import java.io.IOException;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.util.GenericOptionsParser;

public class Merge {

	public static class Map extends Mapper<Object, Text, Text, Text>{
		private static Text txt= new Text();
		public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
//			txt=value;
			context.write(value, txt);
		}
	}
	
	public static class Reduce extends Reducer<Text, Text, Text, Text>{
		public void reduce(Text key, Iterable<Text>values, Context context) throws IOException, InterruptedException{
			context.write(key, new Text(""));
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
//		conf.set("fs.defaultFS", "hdfs://master:9000");
		String[] otherArgs = (new GenericOptionsParser(conf,args)).getRemainingArgs();
//		String[] otherArgs = new String[] {"/input/A.txt","/input/B.txt","/output"};
		if(otherArgs.length < 2) {
			System.err.println("Usage:merge<in>[..<in>]<out>");
			System.exit(2);
		}
		try {
			Job job=Job.getInstance(conf,"Merge and duplicate removal");
			job.setJarByClass(Merge.class);
//			job.setJar("Merge.jar");
			job.setMapperClass(Map.class);
			job.setCombinerClass(Reduce.class);
			job.setReducerClass(Reduce.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(Text.class);
			for(int i =0; i<otherArgs.length-1; i++) {
				FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
			}
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length-1]));
			System.exit(job.waitForCompletion(true)? 0 : 1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
