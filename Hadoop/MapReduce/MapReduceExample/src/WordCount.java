import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {
	
	public WordCount() {
		
	}
	public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable>{
		private static final IntWritable one = new IntWritable(1);
		private Text word = new Text();
		public TokenizerMapper() {
			
		}
		public void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException{
			StringTokenizer itr = new StringTokenizer(value.toString());
			while(itr.hasMoreTokens()) {
				this.word.set(itr.nextToken());
				context.write(this.word, one);
			}
		}
	}
	
	public static class IntSumReduce extends Reducer<Text, IntWritable, Text, IntWritable>{
		private IntWritable result = new IntWritable();
		public IntSumReduce() {
			
		}
		public void reducer(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) 
				throws IOException, InterruptedException{
			int sum = 0;
			IntWritable val;
			for(Iterator i$ = values.iterator(); i$.hasNext(); sum+=val.get()) {
				val = (IntWritable)i$.next();
			}
			this.result.set(sum);
			context.write(key, this.result);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		String[] otherArgs = (new GenericOptionsParser(conf, args)).getRemainingArgs();
		if(otherArgs.length<2) {
			System.err.println("Usage:wordcount<in>[<in>...]<out>");
			System.exit(2);
		}
		Job job = Job.getInstance(conf,"word count");
		job.setJarByClass(WordCount.class);
		job.setMapperClass(WordCount.TokenizerMapper.class);
		job.setCombinerClass(WordCount.IntSumReduce.class);
		job.setReducerClass(WordCount.IntSumReduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		for(int i = 0; i < otherArgs.length-1; ++i) {
			FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length-1]));
			System.exit(job.waitForCompletion(true)? 0:1);
		}
	}

}
