package dev.machi.katas.diamond

import org.junit._
import Assert._

class DiamondTest {
  var diamond: Diamond = null;

  @Test
  def whenPassedAnAlphabet_A_SizeShouldBe_1(): Unit = {
    assertEquals("Size should be 1 ", 1, diamond.calculateLineLength('A'))
  }

  @Test
  def whenPassedAnAplhabet_B_SizeShouldBe_3(): Unit = {
    assertEquals("Size should be 3", 3, diamond.calculateLineLength('B'))
  }

  @Test
  def whenPassedAnAplhabet_C_SizeShouldBe_5(): Unit = {
    assertEquals("Size should be 5", 5, diamond.calculateLineLength('C'))
  }

  @Test
  def whenPassedAnAplhabet_A_ShouldSendA(): Unit = {
    assertEquals("Should be A", "A", diamond.buildLine('A', 0, 0))
  }

  @Test
  def whenPassedAnAplhabet_A_WithZeroInnerMarginShouldContainOnlyOneA(): Unit = {
    val line: String = diamond.buildLine('A', 1, 0)
    assertEquals("Should be false", false, line.matches("\\s*A{1}\\s*A{1}\\s*"))
  }

  @Test
  def whenPassedAnAplhabet_A_WithNegativeInnerMarginShouldContainOnlyOneA(): Unit = {
    val line: String = diamond.buildLine('A', 1, -1)
    assertEquals("Should be false", false, line.matches("\\s*A{1}\\s*A{1}\\s*"))
  }

  @Test
  def whenPassedAnAplhabet_B_ShouldWith0OutsideSpaceAndOneInnerSpaceShouldReturnB_B(): Unit = {
    assertEquals("Should be B", "B B", diamond.buildLine('B', 0, 1))
  }

  @Test
  def whenPassedAnAplhabet_B_ShouldWith2OutsideSpaceAnd2InnerSpaceShouldReturn__B__B__(): Unit = {
    assertEquals("Should be \"  B  B  \"", "  B  B  ", diamond.buildLine('B', 2, 2))
  }

  @Test
  def whenPassedAnAlpabet_A_ItShouldReturnADot_A_(): Unit = {
    assertEquals("Should be A", "A", diamond.triangulateUpperPartOfDiamond('A'))
  }

  @Test
  def whenPassedAnAlpabet_B_ItShouldReturnATriangulateUpperPartOfDiamond_A0B_B(): Unit = {
    assertEquals("Should be \"A \nB B\"", " A \nB B", diamond.triangulateUpperPartOfDiamond('B'))
  }

  @Test
  def whenPassedAnAlpabet_C_ItShouldReturnATrianglateUpperPartOfDiamond__A__0_B_B_0C___C(): Unit = {
    assertEquals("Should be \"  A  \n B B \nC   C\"", "  A  \n B B \nC   C", diamond.triangulateUpperPartOfDiamond('C'))
  }

  @Test
  def whenPassedAnAlpabet_B_ItShouldReturnATriangulateLowerPartOfDiamondAs_A(): Unit = {
    assertEquals("Should be \" A \"", " A ", diamond.triangulateLowerPartOfDiamond('B'))
  }

  @Test
  def whenPassedAnAlpabet_C_ItShouldReturnATrianglateLowerPartOfDiamondAs_B_B__A__(): Unit = {
    assertEquals("Should be \" B B \n  A  \n\"", " B B \n  A  ", diamond.triangulateLowerPartOfDiamond('C'))
  }

  @Test
  def whenPassed_A_ShouldReturnDiamondA(): Unit = {
    assertEquals("Should be \"A\"", "A", diamond.diamondinize('A'))
  }

  @Test
  def whenPassed_B_ShouldReturnDiamond_A_B_B_A_(): Unit = {
    assertEquals("Should be \" A \nB B\n A \"", " A \nB B\n A ", diamond.diamondinize('B'))
  }

  @Before
  def setup(): Unit = {
    diamond = new Diamond
  }
}
