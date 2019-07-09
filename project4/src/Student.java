public class Student {

  String name;
  String major;
  double gpa;
  int credits;
  int gradePoints;
  int qualitPoints;

  public Student(String name, String major) {
    this.name = name;
    this.major = major;
    this.credits = 0;
    this.qualitPoints = 0;
  }

  public void courseCompleted(String grade, int creditHours) {
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
    qualitPoints += gradePoints;
    credits += creditHours;

    gpa = qualitPoints / credits;
  }

  @Override
  public String toString() {
    return "Name: " + name + "\nMajor: " + major + "\nGPA: " + gpa + "\n";
  }
}
