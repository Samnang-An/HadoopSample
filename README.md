# Hadoop Single Node Cluster

### ssh localhost
> ssh localhost

### Format HDFS
> hdfs namenode -format

### Start up
> start-all.sh

### Shut down
> stop-all.sh

### Create input and add file
> hadoop fs -mkdir /input-name

> hadoop fs -put /path/to/your/file.txt /input-name

### Run program
> hadoop jar target/YOUR_JAR_FILE your.package.name.runner.class /input-name/file-name.txt /output


# URL

> http://localhost:9870/

> http://localhost:8088/