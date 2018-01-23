package dev.machi.katas.diamond

import java.util.{ArrayList, Collections, List}
import java.util.stream.Collectors

import scala.collection.mutable

class Diamond {
  def diamondinize(char: Char): String = {
    val upperPart = this.triangulateUpperPartOfDiamond(char)
    if (upperPart.length == 1) upperPart
    else upperPart.concat("\n").concat(this.triangulateLowerPartOfDiamond(char));
  }

  def triangulateUpperPartOfDiamond(char: Char): String = {
    this.triangulateAsList(char).stream().collect(Collectors.joining("\n"))
  }

  def triangulateLowerPartOfDiamond(char: Char): String = {
    val upperTriangle = this.triangulateAsList(char);
    Collections.reverse(upperTriangle);

    upperTriangle
      .stream()
        .skip(1)
      .collect(Collectors.joining("\n"))
  }

  def triangulateAsList(char: Char): List[String] = {
    val lineLength = this.calculateLineLength(char)
    val list: List[String] = new ArrayList[String]()

    if (lineLength <= 0) return list

    val range = char - 'A'

    for (i <- 0 until (range + 1)) {
      list.add(this.buildLine(('A' + i).toChar, range - i, 2 * i - 1))
    }

    list
  }

  def buildLine(char: Char, outerMargin: Int, innerMargin: Int): String = {
    if (0.equals(outerMargin) && 0.equals(innerMargin)) char.toString()
    else if (0.>=(innerMargin)) " " * outerMargin + char + " " * outerMargin
    else " " * outerMargin + char + " " * innerMargin + char + " " * outerMargin
  }

  def calculateLineLength(char: Char): Int = 2 * (char - 'A') + 1

}
