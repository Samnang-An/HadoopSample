package com.bd.lab.average;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WCAverageMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {

  private final Text ipAddress = new Text();

  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
    String[] s = value.toString().split(" ");
    if (s.length < 9) {
      return;
    }
    ipAddress.set(s[0]);
    double size;
    try {
      size = Double.parseDouble(s[9].trim());
    } catch (NumberFormatException ex) {
      return;
    }
    context.write(ipAddress, new DoubleWritable(size));
  }
}
