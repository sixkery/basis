package com.sixkery.basis.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object MakeSql {

  def main(args: Array[String]): Unit = {
    // 创建 spark session 运行环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount2")
    val spark = SparkSession.builder().config(sparkConf).getOrCreate()

    val df = spark.read.json("/Users/sixkery/Downloads/bigdata/sparkSQL.json")
    // 打印 schema
    df.printSchema()
    // 显示数据
    df.show()

    df.createOrReplaceTempView("studentScore")
    println("小于20岁的人参加考试人数为：")
    spark.sql("SELECT count(*) FROM studentScore where age < 20").show()



    // 关闭环境
    spark.close()

  }

}
