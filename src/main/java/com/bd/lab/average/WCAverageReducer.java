package com.bd.lab.average;

import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WCAverageReducer extends Reducer<Text, IntWritable, Text, DoubleWritable> {

  private final DoubleWritable result = new DoubleWritable();

  public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
      throws IOException, InterruptedException {
    int sum = 0, count = 0;
    for (DoubleWritable val : values) {
      sum += val.get();
      count += 1;
    }
    result.set(sum / count);
    context.write(key, result);
  }
}