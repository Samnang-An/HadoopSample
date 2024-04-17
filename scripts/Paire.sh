# enter the Paire directory 
cd src/main/java/com/bd/lab/Paire/

# execute this to generate *.class files
hadoop com.sun.tools.javac.Main relativeoccurencepaire.java
# generate jar from *.class
 jar cf rop.jar relativeoccurencepaire*.class

 # execute the program
  hadoop jar rop.jar relativeoccurencepaire /home/kortez/bigdata/input output

# check output in output directory