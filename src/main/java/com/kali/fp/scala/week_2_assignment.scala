package com.kali.fp.scala

/**
  * Created by kalit_000 on 14/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object week_2_assignment {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("week_2_assignment").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    /*2.1 Basic Fucntion on sets*/
    //2.1
    type Set=Int => Boolean

    /*indicates whether a set contains given element*/
    def contains(s:Set,elem:Int):Boolean=s(elem)

    /*returns set of given one element*/

     def singletonset(elem:Int):Set= x => x == elem

    /*returns union of two given sets*/

    def union(s:Set,t:Set):Set=(e:Int) => s(e) || t(e)

    /*intersect two given sets*/

    def intersect(s:Set,t:Set):Set= x => s(x) && t(x)

    /*difference of two given sets*/

    def diff(s:Set,t:Set):Set=x => s(x) && !t(x)



    def filter(s: Set, p: Int => Boolean): Set={elem: Int => contains(s,elem) && contains(p,elem)}

    /*filter */

    //println(singletonset(12))

    //println(union(Set(1,2),Set(1,4)))

    println(diff(Set(1),Set(4)))




  }


}
