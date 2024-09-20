package com.sixkery.basis.spark

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

class WordCount2 {


  case class StudentScore(class: String, name: String, score: Int)

  def main(args: Array[String]): Unit = {


    // 创建 spark 运行配置对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL_demo_01")


    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    val sc = spark.sparkContext

    val value = sc.textFile("/Users/sixkery/Downloads/bigdata/sparkSQL.json")

    value.map(x=>Str)
    frame.createOrReplaceTempView("user")
  }

}
