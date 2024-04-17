package com.bd.lab.striprelativefrequency;

import java.io.IOException;
import java.util.Map;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Reducer;

public class RFReducer extends Reducer<Text, MapWritable, Text, MapWritable> {

  public void reduce(Text key, Iterable<MapWritable> values, Context context)
      throws IOException, InterruptedException {
    MapWritable map = new MapWritable();
    values.iterator().forEachRemaining(map::putAll);
    int sum = 0;
    for (Map.Entry<Writable, Writable> entry : map.entrySet()) {
      sum += Integer.parseInt(entry.getValue().toString());
    }
    for (Map.Entry<Writable, Writable> entry : map.entrySet()) {
      entry.setValue(new IntWritable(((IntWritable) entry.getValue()).get() / sum));
    }
    context.write(key, map);
  }
}