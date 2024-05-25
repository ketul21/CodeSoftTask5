package org.example;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public boolean registerForCourse(Course course) {
        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            return true;
        } else {
            return false;
        }
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.removeStudent(this);
            return true;
        } else {
            return false;
        }
    }

    public void listCourses() {
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}




