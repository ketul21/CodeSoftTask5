package org.example;

import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private ArrayList<Student> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents.size();
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public void listStudents() {
        for (Student student : registeredStudents) {
            System.out.println(student.getName());
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %s\n%s\nCapacity: %d, Available Slots: %d\nSchedule: %s",
                courseCode, title, description, capacity, getAvailableSlots(), schedule);
    }
}
