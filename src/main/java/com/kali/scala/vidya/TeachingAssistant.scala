package com.kali.scala.vidya

/**
  * Created by kalit_000 on 19/03/2016.
  */
//some good example

trait SchoolPerson {
  def name:String
  def salary:Double
  def asssize:String
}

trait Student extends SchoolPerson {
  override def salary=0
}

trait Teacher extends SchoolPerson {
  override def salary=70000
  override def asssize="Big & Round"
}
/*
trait Sluggable {
  def slug:String
  protected slug slugify(text:String) =text.toLowercase
}
*/

class TeachingAssistant(val name:String) extends Student with Teacher {
  def title="Teaching Assistant"
  override def toString()=s"${title} ${name}"
}

