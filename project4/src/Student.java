/////////////////////////////////////////////
// File: Student.java
// Author: Justin Casey
// Date: July 10, 2019
// Purpose: Class defines the
// student object and the course
// completed function and the
// to string function
//

public class Student {

  // var needed for the Student class
  private String name;
  private String major;
  private double gpa;
  private int credits;
  private int gradePoints;
  private int qualityPoints;

  // Constructor
  Student(String name, String major) {
    this.name = name;
    this.major = major;
    this.credits = 0;
    this.qualityPoints = 0;
  }

  // add course grade info
  void courseCompleted(String grade, int creditHours) {
    grade = grade.toUpperCase();
    switch (grade) {
      case "A":
        gradePoints = 4;
        break;
      case "B":
        gradePoints = 3;
        break;
      case "C":
        gradePoints = 2;
        break;
      case "D":
        gradePoints = 1;
        break;
    }

    gradePoints = gradePoints * creditHours;
    qualityPoints += gradePoints;
    credits += creditHours;

    gpa = qualityPoints / credits;
  }

  @Override
  public String toString() {
    return "Name: " + name + "\nMajor: " + major + "\nGPA: " + gpa + "\n";
  }
}
