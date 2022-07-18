package chapter6_functional_object


// n, d = 클래스 파라미터
class Rational(n: Int, d: Int) {
  require(d != 0) // 선결 조건
  
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g
  
  // 보조 생성자
  def this(n: Int) = this(n, 1)
  
  override def toString: String = s"$n/$d"
  
  // *** 중요 포인트 ***
  // Rational을 변경 불가능한 객체로 만들기 위해서는
  // add 메서드가 객체 자체의 값을 수정해 인자를 더해서는 안 된다.
  def + (that: Rational): Rational =
    new Rational(
      numer * that.numer + that.numer * denom, 
      that.denom
    )
  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)
    
  
  def - (that: Rational): Rational =
    new Rational(
      numer * that.numer - that.numer * denom,
      that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(
      numer * that.numer,
      denom * that.denom
    )

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(
      numer * that.denom,
      denom * that.numer
    )

  def / (i: Int): Rational =
    new Rational(numer, denom * i)
  
    
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
    
  def lessThan(that: Rational) =
    this.numer * that.denom < that.numer * this.denom
    
  def max(that: Rational) =
    if (this.lessThan(that)) that else this
}
