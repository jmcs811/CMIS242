public class Student {

  private String name;
  private String major;
  private double gpa;
  private int credits;
  private int gradePoints;
  private int qualityPoints;

  Student(String name, String major) {
    this.name = name;
    this.major = major;
    this.credits = 0;
    this.qualityPoints = 0;
  }

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
