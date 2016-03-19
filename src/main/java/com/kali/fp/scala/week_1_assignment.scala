package com.kali.fp.scala

/**
  * Created by kalit_000 on 13/03/2016.
  */

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}

object week_1_assignment {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

    /*EX:1
    * */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    println(pascal(0,2))
    println(pascal(1,2))

    /*EX 2:-
    * */
    def balance(chars: List[Char]): Boolean = {
      def balanceWithCounter(chars: List[Char], openParen: Int): Boolean = {
        if (chars.isEmpty) openParen == 0
        else {
          val num =
            if (chars.head == '(') openParen + 1
            else if (chars.head == ')') openParen - 1
            else openParen
          if (num >= 0) balanceWithCounter(chars.tail, num)
          else false
        }
      }
      balanceWithCounter(chars, 0)
    }

    /*EX 3:-
    * */
    def countChange(money: Int, coins: List[Int]): Int =
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }


}
