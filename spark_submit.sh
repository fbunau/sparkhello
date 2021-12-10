#!/bin/bash

# /usr/local/Cellar/apache-spark/3.2.0/libexec/sbin/start-all.sh
# /usr/local/Cellar/apache-spark/3.2.0/libexec/sbin/start-slave.sh spark://0.0.0.0:7077
CLUSTER_URL="spark://0.0.0.0:7077"

echo "Compiling and assembling application..."
sbt assembly

# package
JARFILE=`pwd`/target/scala-2.12/sparktest_2.12_0.0.1.jar

# echo "Running on" $CLUSTER_URL
# spark-submit --class com.leadiq.sparktest.HelloWorld --master $CLUSTER_URL $JARFILE

echo "Running on standalone"
spark-submit --class com.sparktest.HelloWorld --master local $JARFILE

