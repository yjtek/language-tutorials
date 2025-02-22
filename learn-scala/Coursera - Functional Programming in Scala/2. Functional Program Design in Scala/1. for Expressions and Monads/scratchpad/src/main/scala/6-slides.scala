package mod1_slides6

import scala.util.Try
import scala.util.control.NonFatal

def regularTryCatch() = {
  try {
    println(1/0)
  } 
  catch {
    case ex: Exception => println("WTF"); throw ex
  }
}

abstract class Try[+T]
case class Success[+T](x: T) extends Try[T]
case class Failure(ex: Exception) extends Try[Nothing]

def gracefulTry() = {
  ???  
}

@main def main() = {
  println(regularTryCatch())
}