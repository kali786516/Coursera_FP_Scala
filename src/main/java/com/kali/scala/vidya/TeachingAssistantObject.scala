package com.kali.scala.vidya

/**
  * Created by kalit_000 on 19/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object TeachingAssistantObject {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val ta=new TeachingAssistant("Vidya Fat Ass Teacher")
    println(ta.name)
    println(ta.salary)
    println(ta.asssize)




  }


}
