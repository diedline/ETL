package com.diedline.ETL;

/**
 * 1.过滤脏数据
 * 2.将类别字段中“ ” 替换为 “”
 * 3.替换关联视频的分割符
 */
public class ETLUtils {

    public static String etlStr(String line) {
        //切割数据
        String[] split = line.split("\t");
        //1.过滤脏数据
        if (split.length < 9) {
            return null;
        }
        //2.去掉类别字段中的空格
        split[3] = split[3].replaceAll(" ", "");
        //3.替换分隔符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i < 9) {
                //如果已经是最后一个
                if (i == split.length - 1) {
                    sb.append(split[i]);
                } else {
                    sb.append(split[i]).append("\t");
                }
            } else {
                //如果已经是最后一个
                if (i == split.length - 1) {
                    sb.append(split[i]);
                } else {
                    sb.append(split[i]).append("&");
                }
            }

        }
        return sb.toString();
    }
}
