package com.sixkery.basis.spark

import org.apache.spark.{SparkConf, SparkContext}

/**
 * map 算子
 */
object Operator {

  def main(args: Array[String]): Unit = {

    // 1. 准备环境
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("Operator")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(List(1, 2, 3, 4, 5))

    //    rdd.map((x) => {x * 2}).collect().foreach(println)
    //    rdd.map(x => x * 2).collect().foreach(println)
    rdd.map(_ * 2).collect().foreach(println)

    sc.stop()

  }

}
