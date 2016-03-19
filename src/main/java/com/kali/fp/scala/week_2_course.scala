package com.kali.fp.scala

/**
  * Created by kalit_000 on 14/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object week_2_course {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("week_2_course").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    //EX 1:- Sum of numbers between a...b

    def sum(a:Int,b:Int):Int ={
      if (a > b) 0
      else
        a + sum(a+1,b)
    }

    println(sum(1,1))

    //EX 2:- Sum of Cubes

    def cube(x:Int):Int=x*x*x

    def sumcubes(a:Int,b:Int):Int =
    {
      if (a > b) 0
      else
        cube(a) + sumcubes(a+1,b)
    }

    println(sumcubes(1,3))

   // Ex:-3 sum of factorials
   //b (SIGMA) n=a f(n)
    def fact(n:Int):Int={
      if(n==0) 1
      else
        n*fact(n-1)
    }

    def sumFact(a:Int,b:Int):Int= {
      if (a > b) 0
      else
        fact(a)+ sumFact(a+1,b)
    }

    println(sumFact(1,2))

    /*LETS RE WRITE IN HIGHER ORDER FUCNTIONS*/

    def highsum(f:Int=>Int,a:Int,b:Int):Int={
      if (a>b)0
      else
        f(a) + highsum(f,a+1,b)
    }

    def id(x:Int):Int=x
    def cubehigh(x:Int):Int=x*x*x
    def facthigh(x:Int):Int=if(x ==0)1 else facthigh(x-1)

    def sumInt(a:Int,b:Int):Int =highsum(id,a,b)
    def sumcubeshigh(a:Int,b:Int):Int =highsum(cubehigh,a,b)
    def sumfacthigh(a:Int,b:Int):Int =highsum(facthigh,a,b)

    println(sumInt(1,2))
    println(sumcubeshigh(1,2))
    println(sumfacthigh(1,2))

    /*Anonymous functions*/
    /*Below anonymous function example*/
    //(x:Int)=> x*x*x

    def sumIntAnnon(a:Int,b:Int):Int =highsum(x => x,a,b)
    def sumcubeshighAnnon(a:Int,b:Int):Int =highsum(x=> x*x*x,a,b)

    /*sum fucntion using tail recurssion*/

      def sumtailrecusion(f: Int => Int,a: Int, b: Int)= {
        def loop(a: Int, acc: Int): Int =
          if (a > b) acc
          else loop(a+1,f(a) + acc)
        loop(a,0)
      }

    println(sumtailrecusion(d => d*d,3,5))

    /*currying.....*/

    def sumcurry(f:Int => Int):(Int,Int) => Int ={
      def sumFcurry(a:Int,b:Int):Int=
      if(a > b) 0
      else  f(a)+sumFcurry(a+1,b)
      sumFcurry
      }

    def sumopcurry=sumcurry(x => x)
    def sumcubescurry =sumcurry(x => x*x*x)
    def sumfactcurry=sumcurry(facthigh)

    /*product*/

    def product(f:Int => Int)(a:Int,b:Int):Int ={
      if (a > b) 1
      else f(a) * product(f) (a+1,b)
    }

    println(product(x => x *x)(3,7))

    def factcurry(n:Int)=product(x => x)(1,n)

    println(factcurry(5))


  }
}
