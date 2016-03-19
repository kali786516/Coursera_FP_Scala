package com.kali.fp.scala

/**
  * Created by kalit_000 on 18/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

trait List[T] {
  def isEmpty:Boolean
  def head:T
  def tail:List[T]
}

class cons[T](val head:T,val tail:List[T]) extends  List[T] {
  def isEmpty=false
}

class Nil[T] extends List[T] {
  def isEmpty:Boolean=true
  def head:Nothing=throw new NoSuchElementException("Nil.head")
  def tail:Nothing=throw new NoSuchElementException("Nil.tail")
}

object List {
  def apply[T](x1:T,x2:T):List[T]=new cons(x1,new cons(x2,new Nil))
  def apply[T]()=new Nil
}


object week_3_course_type_parameters {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    def nth[T](n:Int,xs:List[T]):T= {
      if (xs.isEmpty) throw new IndexOutOfBoundsException
      else if (n == 0) xs.head
      else nth(n - 1, xs.tail)
    }

    val list=new cons(1,new cons(2,new cons(3,new Nil)))
    //def nth(3,list)



  }


}
