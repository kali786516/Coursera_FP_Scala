package com.kali.parleys.course

/**
  * Created by kalit_000 on 18/03/2016.
  */

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest._

@RunWith(classOf[JUnitRunner])
class flight_1_03_test_case extends FunSuite with Matchers with BeforeAndAfterAll{

  test ("Create a new Complex number and check the values for the real/imaginary parts") {
    val complex = new ComplexNum(4, 2)

    complex.real should be (4)
    complex.imaginary should be (2)
  }

  test ("Create a new complex number with double values and check those values") {
    val complex = new ComplexNum(6.2, -1.5)

    complex.real should be (6.2)
    complex.imaginary should be (-1.5)
  }

  test ("Create a complex number from a real number, imaginary part should be 0") {
    val complex = new ComplexNum(-3.2)

    complex.real should be (-3.2)
    complex.imaginary should be (0)
  }

  test ("complex number should be printed in the form R.R + I.Il") {
    val complex=new ComplexNum(6,3)
    val complex2=new ComplexNum(5.4,7.8)

    complex.toString should be ("6.0+3.0i")
    complex2.toString should be ("5.4+7.8i")

  }

  test ("Adding complex numbers") {
    val complex=new ComplexNum(6,3)
    val complex2=new ComplexNum(5.4,7.8)
    val complex3=complex+complex2

    complex3.real should be (11.4)
    complex3.imaginary should be (10.8)
  }

  /*test ("Adding comples number to a Double") {
    val complex=new ComplexNum(6.5,3.2) + 5.5

    complex.real should be (12)
    complex.imaginary should be (3.2)

  }*/

   /*test ("Format for negative imaginary part should be R.R - I.Ii") {
    val complex = new ComplexNum(5, -6)
    val complex2 = new ComplexNum(5.5, -6.6)

    complex.toString should be ("5.0 - 6.0i")
    complex2.toString should be ("5.5 - 6.6i")
  }*/

}
