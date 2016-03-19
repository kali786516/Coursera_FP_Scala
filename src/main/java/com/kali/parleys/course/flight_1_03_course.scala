package com.kali.parleys.course

/**
  * Created by kalit_000 on 18/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

class Rational(val numer:Int,val denom:Int) {

  require(denom !=0,"Zero Denom")

  override def toString:String =s"${numer}/${denom}"
  def add(that:Rational):Rational =
  new Rational(numer * that.denom + that.numer * denom,denom* that.denom)
}


object flight_1_03_course {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val a=new Rational(1,23)
    val b=new Rational(3,34)

    println(a.add(b))




  }


}
