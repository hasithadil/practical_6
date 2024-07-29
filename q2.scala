package practical_6

import scala.io.StdIn

object q2 {

    def getStudentInfo(): (String, Int, Int, Int, Int, Double, Char) = {
      print("Enter the Student name :")
      var n: String = StdIn.readLine()

      print("Enter the Student mark1 :")
      var m1: Int = StdIn.readInt()

      print("Enter the Student mark1 :")
      var m2: Int = StdIn.readInt()

      print("Enter the Student mark1 :")
      var m3: Int = StdIn.readInt()

      val temp = (n, m1, m2, m3)

      //if he input correctly at the 1st time
      if (validateInput(temp)) {
        val total1 = m1 + m2 + m3;
        val total: Double = (total1 * 100) / 300

        //default is absent
        var g: Char = 'm'
        if (total >= 90) {
          g = 'A'
        }
        else if (total >= 75) {
          g = 'B'
        }
        else if (total >= 50) {
          g = 'C'
        }
        else {
          g = 'D'
        }
        (n, m1, m2, m3, total1, total, g)
      }

      //if he input after many tries
      else {
        println("Invalid Input entered. Enter detail again")
        val temp2 = getStudentInfoWithRetry()

        val total2 = temp2._2 + temp2._4 + temp2._3
        val total3: Double = (total2 * 100) / 300

        //default is absent
        var g: Char = 'm'
        if (total3 >= 90) {
          g = 'A'
        }
        else if (total3 >= 75) {
          g = 'B'
        }
        else if (total3 >= 50) {
          g = 'C'
        }
        else {
          g = 'D'
        }
        (n, m1, m2, m3, total2, total3, g)

      }
    }

    def printStudentRecord(stud: (String, Int, Int, Int, Int, Double, Char)): Unit = {
      println(s"Student name = ${stud._1}  Mark1 = ${stud._2} Mark2 = ${stud._3} Mark3 = ${stud._4} Total Marks = ${stud._5} Percentage = ${stud._6} Grade = ${stud._7}")
    }

    def validateInput(stud: (String, Int, Int, Int)): Boolean = {
      stud match {
        case (name, marks1, marks2, marks3) =>
          name.nonEmpty &&
            marks1 >= 0 && marks1 <= 100 &&
            marks2 >= 0 && marks2 <= 100 &&
            marks3 >= 0 && marks3 <= 100
      }
    }

    def getStudentInfoWithRetry(): (String, Int, Int, Int) = {
      print("Enter the Student name :")
      var n: String = StdIn.readLine()

      print("Enter the Student mark1 :")
      var m1: Int = StdIn.readInt()

      print("Enter the Student mark2 :")
      var m2: Int = StdIn.readInt()

      print("Enter the Student mark3 :")
      var m3: Int = StdIn.readInt()

      val ret = (n, m1, m2, m3)

      if (validateInput(ret)) {
        ret
      }
      else {
        getStudentInfoWithRetry()
      }
    }

    def main(args: Array[String]): Unit = {
      var x = getStudentInfo()

      printStudentRecord(x)

    }
}
