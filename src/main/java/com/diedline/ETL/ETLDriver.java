package com.diedline.ETL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ETLDriver implements Tool {
    private Configuration conf;

    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new ETLDriver(), args);
        System.out.println(run);
    }
    public int run(String[] strings) throws Exception {
        //1.获取Job对象
        Job job = Job.getInstance(getConf());
        //2.封装driver类
        job.setJarByClass(ETLDriver.class);
        //3.关联mapper类
        job.setMapperClass(ETLMapper.class);
        //4.mapper输出kv类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        //5.最终输出类型
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        //6.输入输出路径
        FileInputFormat.setInputPaths(job, new Path(strings[0]));
        FileOutputFormat.setOutputPath(job, new Path(strings[1]));
        //7.提交任务
        boolean result = job.waitForCompletion(true);
        return result ? 0 : 1;
    }

    public void setConf(Configuration configuration) {
        conf = configuration;
    }

    public Configuration getConf() {
        return conf;
    }
}
