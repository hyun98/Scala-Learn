package chapter4_class_and_object.models

import scala.collection.mutable

// 동반 클래스
// 파라미터를 받아서 생성 가능
class CheckSumAccumulator {
  private var sum = 0

  // sum 을 변경하는 '부수효과'를 위해 실행된다.
  // 부수 효과만을 위해 실행되는 메서드를 '프로시저'(procedure)라고 부른다.
  def add(b: Byte): Unit =  sum += b

  def checksum: Int = ~(sum & 0xFF) + 1
}

// 스칼라가 자바보다 더 객체지향적인 이유 중 하나는 스칼라 클래스에는 static 멤버가 없다는 것이다.
// 대신 스칼라는 싱글톤 객체(singleton object) 를 제공한다.
// 싱글톤 객체 정의는 클래스와 같아 보이지만 class 라는 키워드 대신에 object 라는 키워드로 시작한다.
// 싱글톤 객체는 타입을 지정할 수 없다.
// CheckSumAccumulator 라는 타입은 싱글톤 객체의 동반 클래스를 정의해야만 생긴다.
// but, 싱글톤 객체는 슈퍼 클래스나 믹스인 trait 의 인스턴스다.
// 싱글톤 객체는 파라미터를 받을 수 없음.

// 동반 클래스가 없는 싱글톤 클래스를 '독립 객체' 라고 부른다.
// 독립 객체는 여러 목적으로 활용 가능한데,
// 1. 필요한 도구 메서드를 한데 모아둘 수 있다.
// 2. 스칼라 애플리케이션의 진입점을 만들 때 사용할 수 있다.
object CheckSumAccumulator {
  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s)) cache(s)
    else {
      // new 키워드는 클래스를 인스턴스화 할때만 사용하기 때문에 이름이 같은 싱글톤 객체의 인스턴스가 아니다.
      val acc = new CheckSumAccumulator
      for (c <- s) acc.add(c.toByte)
      val cs = acc.checksum
      cache += (s -> cs)
      cs
    }
}
