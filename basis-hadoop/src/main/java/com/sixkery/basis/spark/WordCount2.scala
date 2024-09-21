package com.sixkery.basis.spark

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

case class StudentScore(className: String, name: String, age: Int, gender: String, subject: String, score: Int)

object WordCount2 {


  def main(args: Array[String]): Unit = {

    // 创建 spark 运行配置对象
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount2")

    val spark: SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    // 直接读取 JSON 文件
    val studentScoreDF = spark.read.csv("/Users/sixkery/Downloads/bigdata/sparkSQL.csv")

    // 转换为 DataSet[StudentScore]
//    val studentScoreDS = studentScoreDF.as[StudentScore]
    //
    //    // 显示数据
//    studentScoreDS.show()

    // 关闭 SparkSession
    spark.stop()
  }
}