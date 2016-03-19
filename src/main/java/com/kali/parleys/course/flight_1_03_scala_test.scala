package com.kali.parleys.course

/**
  * Created by kalit_000 on 18/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}
import org.scalatest.Matchers

//1. Has class parameters real and imaginary
class ComplexNum(val real:Double,val imaginary:Double) {

  //2. an auxilliary constructor that takes just a real double and creates a
  //    complex number with a 0 imaginary value
  def this(real:Double)=this(real,0)

  //3. has an overridden toString method that prints out the number in the form
  //    "<real> + <imaginary>i", e.g. 2.0 + 8.1i
  override def toString=s"${real}+${imaginary}i"

  //4. has a + method that creates a new complex number with a real
  //    part containing the sum of the real parts, and an imaginary part containing
  //    the sum of the imaginary parts
  def +(other:ComplexNum):ComplexNum=new ComplexNum(other.real+real,other.imaginary+imaginary)

  //5 has a second overloaded + method that creates a new complex number by taking
  //    a double and adding the double to the real part
  def +(other:Double):ComplexNum=new ComplexNum(real+other,imaginary)

}

object flight_1_03_scala_test {

def main(args: Array[String]) {

  Logger.getLogger("org").setLevel(Level.WARN)
  Logger.getLogger("akka").setLevel(Level.WARN)

  val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
  val sc = new SparkContext(conf)

  val comples=new ComplexNum(3,4)




}
}
