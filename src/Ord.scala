trait Ord {
  def < (that: Any): Boolean
  def <= (that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >= (that: Any): Boolean = !(this < that)
}

case class Date(y: Int, m: Int, d: Int) extends Ord {
  def year: Int = y
  def month: Int = m
  def day: Int = d

  override def toString = s"$year-$month-$day"

  override def equals(that: Any): Boolean = that match {
    case Date(y, m, d) => y == year && m == month && d == day
    case _ => false
  }

  def <(that: Any): Boolean = that match {
    case Date(y, m, d) => year < y || (year == y && (month < m || (month == m && day < d)))
    case _ => sys.error(s"Cannot compare $that and a Date.")
  }
}
