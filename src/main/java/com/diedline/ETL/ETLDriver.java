package com.diedline.ETL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;

public class ETLDriver implements Tool {
    private Configuration conf;

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

        //6.输入输出路径

        //7.提交任务
        return 0;
    }

    public void setConf(Configuration configuration) {
        conf = configuration;
    }

    public Configuration getConf() {
        return conf;
    }
}
