import java.text.DateFormat._
import java.util.{Date, Locale}

object FrenchDate {
  def main(args: Array[String]): Unit = {
    val now = new Date;
    val df = getDateInstance(LONG, Locale.FRANCE)
    printf(df.format(now))
  }
}

object Timer {
  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread.sleep(1000)
    }
  }

  def main(args: Array[String]): Unit = {
    oncePerSecond(() => println("YEP"));
  }
}