# 🎓 Student Grade Tracker

A simple, terminal‑based Java application to manage student grades. 
 
It calculates averages, highest/lowest scores, and displays a detailed summary report.

---

## 📁 Project Structure

Task-1-StudentGradeTracker/
├── src/
│ ├── Student.java → Data model (student name & grades)
│ ├── GradeTrackerService.java → Business logic (add, average, stats)
│ └── Main.java → Console user interface
└── README.md


---

## ✨ Features

- Add new students (duplicate names prevented)

- Record multiple grades per student (0‑100)

- View all students with their current average

- Generate a detailed report showing:
  - Each student’s grades, average, highest, lowest
  - Class overall statistics (average, highest  lowest, total grades)
  
- Input validation and user‑friendly error messages

---

## 🚀 How to Compile & Run

1. **Open a terminal** inside the `Task-1-StudentGradeTracker/` folder.

2. **Compile** all source files:

   ```bash
   javac src/*.java

3. Run the Application
    java -cp src Main