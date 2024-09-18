object Main extends App {
  val name = "Arseniy"

  def printMessage(message: String): Unit = {
    println(message + name)
  }

  def printReversedMessage(message: String): Unit = {
    println(message + name.reverse)
  }

  printMessage("Hello Scala! This is ")
  printMessage("Hola Scala! This is ")
  printMessage("guten Tag Scala! This is ")

  printReversedMessage("Hello Scala! This is ")
  printReversedMessage("Hola Scala! This is ")
  printReversedMessage("guten Tag Scala! This is ")
}
