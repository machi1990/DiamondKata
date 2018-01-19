package dev.machi.katas.diamond

object Main extends  App {
  if (args.length == 0) {
      println("Run the program by entering an alphabet.")
      System.exit(1)
  } else if (args(0).charAt(0) < 'A' || args(0).charAt(0) > 'Z') {
    println("Only capital letters can be used.")
    System.exit(1)
  }

  val diamond = new Diamond
  println("-----------Your diamond is-----------")
  println(diamond.diamondinize(args(0).charAt(0)))
  println("-----------Congratualations on your diamond-----------")
}
