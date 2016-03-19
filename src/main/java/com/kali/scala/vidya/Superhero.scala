package com.kali.scala.vidya

/**
  * Created by kalit_000 on 19/03/2016.
  */
import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkContext, SparkConf}


case class Superhero (name:String,company:String,fromEarth:Boolean=true)

object superheroobject {

  def main(args: Array[String]) {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)

    val conf = new SparkConf().setMaster("local[*]").setAppName("YOUR_APP_NAME_USER").set("spark.hadoop.validateOutputSpecs", "false")
    val sc = new SparkContext(conf)

  /*
    val spiderman=Superhero("Spider-Man","Marvel")
    val spiderman2=Superhero("Spider-Man","Marvel")
    val batman=Superhero("Batman","DC Comics")
    println(spiderman == spiderman2)
    println(batman == spiderman)
    val superman=batman.copy(name="Superman",company = "DC Comics")
    println(superman)
  */

  val superheros=Vector(
    Superhero("IronMan","Marvel"),
    Superhero("Batman","DC Comics"),
    Superhero("Captain America","Marvel"),
    Superhero("Superman","DC Comics",fromEarth = false),
    Superhero("Thor","Marvel",fromEarth = false),
    Superhero("Hulk","Marvel"),
    Superhero("Wonder Woman","DC Comics"),
    Superhero("Aquaman","DC Comics")
  )

  for (i <- 1 to 10) {
    val randomIndex=scala.util.Random.nextInt(superheros.length-1)
    superheros(randomIndex) match {
      case Superhero(name,company,_) => println(s"This superhero $name belongs to $company" )
    }
  }
    for (i <- 1 to 10) {
      val shuffledSuperheros=scala.util.Random.shuffle(superheros)
      shuffledSuperheros match {
        case Vector(Superhero(name,"Marvel",_),_*) => println(s"First superhero is $name with Marvel.")
        case Vector(Superhero(name,"DC Comics",_),_*) => println(s"First superhero is $name with DC.")
        case _ => println(s"First superhero is with different company altogether")
      }

    }




  }
}


