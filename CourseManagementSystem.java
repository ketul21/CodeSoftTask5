package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManagementSystem {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private Scanner scanner;

    public CourseManagementSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void listCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void registerStudentForCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.registerForCourse(course)) {
            System.out.println("Successfully registered for the course.");
        } else {
            System.out.println("Failed to register. The course may be full.");
        }
    }

    public void dropStudentFromCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (student.dropCourse(course)) {
            System.out.println("Successfully dropped the course.");
        } else {
            System.out.println("Failed to drop the course.");
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Adding sample courses
        cms.addCourse(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science.", 30, "Mon/Wed 10-11am"));
        cms.addCourse(new Course("MATH101", "Calculus I", "Introduction to calculus.", 40, "Tue/Thu 2-3:30pm"));

        // Adding sample students
        cms.addStudent(new Student("S001", "Alice"));
        cms.addStudent(new Student("S002", "Bob"));

        // Main menu loop
        boolean exit = false;
        while (!exit) {
            System.out.println("\nCourse Management System Menu:");
            System.out.println("1. List Courses");
            System.out.println("2. Register Student for Course");
            System.out.println("3. Drop Student from Course");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = cms.scanner.nextInt();
            cms.scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    cms.listCourses();
                    break;
                case 2:
                    cms.registerStudentForCourse();
                    break;
                case 3:
                    cms.dropStudentFromCourse();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Goodbye!");
    }
}

