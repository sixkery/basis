package com.sixkery.basis.spark.create

import org.apache.spark.{SparkConf, SparkContext}

object Memory {

  def main(args: Array[String]): Unit = {

    // 1. 准备环境
    val memory = new SparkConf().setMaster("local[*]").setAppName("Memory")
    // 2. 创建 SparkContext 对象
    val sc = new SparkContext(memory)
//    val rdd = sc.parallelize(Seq(1, 2, 3, 4, 5))
    val rdd = sc.makeRDD(Seq(1, 2, 3, 4, 5))
    rdd.collect().foreach(println)

    // 关闭资源
//    sc.stop()
  }

}
