package com.kali.fp.scala

/**
  * Created by kalit_000 on 13/03/2016.
  */

import breeze.numerics.abs
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object week_1_course {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("week_1_course").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    /* SQUARE ROOT ALGORITHM:-
    * estimate     quotient            mean
    * 1             2/1=2              1.5
    * 1.5           2/1.5=1.33         1.4167
    * 1.4167        2/1.4167=1.4118    1.4142
    * *     *   *    * */

    def sqrt(x:Double)= {
      def sqrtiter(guess:Double,x:Double):Double=
      {
        if(isgoodenough(guess,x)) guess  //checks square root of guess whether close to x or not
        else sqrtiter(improve(guess,x),x) //
      }

      /*is good enough:-
      * take square root of guess and the value should be very close to x it returns boolean true or false
      * */

      def isgoodenough(guess:Double,x:Double)={
        abs(guess * guess - x)/x < 0.001
      }

      /*improve Mean of current value of guess and divided by quotient of x divided by guess
      * */

      def improve(guess:Double,x:Double)={
        (guess+x/guess)/2
      }
      sqrtiter(1.0, x)
    }

    /*Factorial Formula:- n*(n-1)
    ** */

    def factorial(n:Int):Int={
      if (n == 0) 1
      else
        n * factorial(n-1)
    }

    def gcd(a:Int,b:Int):Int ={
      if(b==0) a
      else
      gcd(a,a%b)
    }

    println(2%4)
    println(sqrt(4))
    println(sqrt(2))
    println(gcd(2,4))




  }


}
