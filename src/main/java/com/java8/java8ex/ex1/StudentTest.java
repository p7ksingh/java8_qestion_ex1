package com.java8.java8ex.ex1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class StudentTest {
        public static void main(String[] args) {
                List<Student> list = Arrays.asList(
                                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai",
                                                122),
                                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi",
                                                67),
                                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala",
                                                164),
                                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014,
                                                "Kerala", 26),
                                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023,
                                                "Karnataka", 90),
                                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014,
                                                "Karnataka", 324),
                                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka",
                                                433),
                                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018,
                                                "Karnataka", 7),
                                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017,
                                                "Mumbai", 98));
                new Student(10, "Shubham", "Pankaj", 30, "Male", "computer Engineering", 2017, "Delhi", 304);
                System.out.println("=".repeat(40));
                // Find list of students whose first name starts with alphabet A

                List<Student> lstStuName = list.stream().filter(dt -> dt.getFirstName().startsWith("A"))
                                .collect(Collectors.toList());
                System.out.println("List of students whose name starts with letter A : " +
                                lstStuName);
                System.out.println("=".repeat(40));
                // Group The Student By Department Names
                Map<String, List<Student>> mapData1 = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName));
                Map<String, List<Student>> mapData = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName));
                System.out.println("Sydents grouped by Depertment name" + mapData);
                System.out.println("=".repeat(40));
                // Find the total count of student using stream
                long count = list.stream().count();
                System.out.println("Total Student count: " + count);
                System.out.println("=".repeat(40));
                // Find the max age of student
                OptionalInt maxAge = list.stream().mapToInt(age -> age.getAge()).max();
                System.out.println("Max age of Student : " + maxAge);
                System.out.println("=".repeat(40));
                // Find all departments names
                List<String> departName = list.stream().map(dt -> dt.getDepartmantName()).distinct()
                                .collect(Collectors.toList());
                System.out.println("Departments Nmae : " + departName);
                System.out.println("=".repeat(40));

                // Find the count of student in each department
                Map<String, Long> countStudentInEachDeptMap = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
                System.out.println("Student count in each department: " + countStudentInEachDeptMap);
                System.out.println("=".repeat(40));
                // Find the list of students whose age is less than 30
                List<Student> listOfStudent = list.stream().filter(dt -> dt.getAge() < 30).collect(Collectors.toList());
                System.out.println("Student whose age is less than 30 is : " + listOfStudent);
                System.out.println("=".repeat(40));
                // Find the list of students whose rank is in between 50 and 100
                List<Student> lStudents = list.stream().filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                                .collect(Collectors.toList());
                System.out.println("List of students whose rank is in between 50 and 100 : " + lStudents);

                System.out.println("=".repeat(40));
                // Find the list of students whose rank is in between 50 and 100
                Long studentsCount = list.stream().filter(dt -> dt.getRank() > 50 && dt.getRank() < 100)
                                .collect(Collectors.counting());

                System.out.println("Total Number of students whose rank is in between 50 and 100 : " + studentsCount);
                System.out.println("=".repeat(40));
                // Find the average age of male and female students
                Map<String, Double> avgAge = list.stream()
                                .collect(Collectors.groupingBy(Student::getGender,
                                                Collectors.averagingInt(Student::getAge)));
                System.out.println("Average age : " + avgAge);
                System.out.println("=".repeat(40));
                // Find the department who is having maximum number of students
                Entry<String, Long> entry = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()))
                                .entrySet().stream()
                                .max(Map.Entry.comparingByValue()).get();
                System.out.println("Deoartment having maximum number of students : " + entry);
                System.out.println("=".repeat(40));
                // Find the Students who stays in Delhi and sort them by their names
                List<Student> stuPlace = list.stream().filter(dt -> dt.getCity().equals("Delhi"))
                                .sorted(Comparator.comparing(Student::getFirstName))
                                .collect(Collectors.toList());
                System.out.println("List of students who stay in Delhi and sorted them by their names" + stuPlace);
                System.out.println("=".repeat(40));
                // Find the average rank in all departments
                Map<String, Double> avgRank = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName,
                                                Collectors.averagingInt(Student::getRank)));
                System.out.println("Average rank of all departments :" + avgRank);
                System.out.println("=".repeat(40));
                // Find the highest rank in each department
                Map<String, Optional<Student>> studentRankData = list.stream()
                                .collect(Collectors.groupingBy(Student::getDepartmantName,
                                                Collectors.maxBy(Comparator.comparing(Student::getRank))));
                System.out.println("Higest Rank in each department : " + studentRankData);
                System.out.println("=".repeat(40));
                // Find the list of students and sort them by their rank
                List<Student> listOfStuByRank = list.stream().sorted(Comparator.comparing(Student::getRank))
                                .collect(Collectors.toList());
                System.out.println("List of students sorted by rank: " + listOfStuByRank);

                System.out.println("=".repeat(40));
                // Find the student who has second rank

                Student secondRankStu = list.stream().sorted(Comparator.comparing(Student::getRank)).skip(1).findFirst()
                                .get();
                System.out.println("Second Higest Rank Student: " + secondRankStu);
        }
}
