package com.sixkery.basis.spark.create

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}
case class StudentScore(classname: String, name: String, age: Int, gender: String, subject: String,Score: Int )


object FileRdd {
  def main(args: Array[String]): Unit = {
    // 1. 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("FileRdd")


    val spark = SparkSession.builder().config(sparkConf).getOrCreate()
    val sc: SparkContext = spark.sparkContext


    val rdd = sc.textFile("/Users/sixkery/Downloads/bigdata/sparkSQL.csv").map(x=>x.split(" "))
    val value = rdd.map(x => StudentScore(x(0), x(1), x(2).toInt, x(3), x(4), x(5).toInt))

    // 把 value 转换成 dataframe
    value.toDF().show()
    value.foreach(println)
    value.toDF

  }

}
