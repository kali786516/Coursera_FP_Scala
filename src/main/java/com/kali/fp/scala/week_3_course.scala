package com.kali.fp.scala

/**
  * Created by kalit_000 on 17/03/2016.
  */

import org.antlr.misc.IntSet
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

abstract class IntSet {
  def incl(x:Int):IntSet
  def contains(x:Int):Boolean
  def union(other:IntSet):IntSet
}

class Empty extends IntSet {
  def contains(x:Int):Boolean=false
  def incl(x:Int):IntSet=new NonEmpty(x,new Empty,new Empty)
  override def toString="."
  def union(other:IntSet):IntSet=other

}


class NonEmpty(elem:Int,left:IntSet,right:IntSet) extends IntSet {

  def contains(x:Int):Boolean =
  {
    if (x < elem) left contains x
    else if (x > elem)right contains x
    else true
  }

  def incl(x:Int):IntSet =
  {
    if (x < elem) new NonEmpty(elem,left incl x,right)
    else if (x > elem) new NonEmpty(elem,left,right incl x)
    else this
   }

  def union(other:IntSet):IntSet =
  {
    ((left union right) union other) incl elem
  }

  override def toString="{" + left + elem + right + "}"

}

object week_3_course {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    val t1=new NonEmpty(3,new Empty,new Empty)
    val t2=t1 incl 4
    val t3=new NonEmpty(3,new Empty,new Empty)

    println(t1 contains(3))


  }
}
