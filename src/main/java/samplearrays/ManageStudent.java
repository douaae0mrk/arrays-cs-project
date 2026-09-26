package samplearrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import samplearrays.Student ;

import static java.lang.Float.NaN;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest=students[0];
        for (int i = 1 ; i<students.length; i++){
            if (students[i].getAge()>oldest.getAge()){
                oldest= students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count=0;
        for (int i = 1 ; i<students.length; i++){
            if (students[i].getAge()>=18){
                count++ ;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students.length == 0 ){
            return NaN ;
        }
        double average = 0 ;
        for (Student student : students){
            average+=student.getGrade();
        }
        average= average/students.length;
        return average ;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student : students){
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return  null ;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, (s1, s2) -> -(s1.getGrade()- s2.getGrade()));

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student student : students ){
            if (student.getGrade()>= 15 ){
                System.out.println(student.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student student : students ){
            if (student.getId()>= id ){
                student.setGrade(newGrade);
                return true ;
            }
        }
        return false ;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (int i = 0 ; i<students.length-1; i++){
            for(int j = i+1 ; j<students.length ; j++){
                if (students[i].getName().equals(students[j].getName())){
                    System.out.println("Duplicates found");
                    return true ;
                }
            }
        }
        return false ;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] students1 = new Student[students.length+1];
        for (int i = 0 ; i<students.length; i++){
            students1[i]=students[i];
        }
        students1[students.length]=newStudent;
        return students1;
    }


    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] students= new Student[5];
        students[0]= new Student(1, "Mohammed");
        students[1]= new Student(2, "Nabila" , 30);
        students[2]= new Student(3, "Haitam", 20 , 18 );
        students[3]= new Student(4, "Ilham" , 15);
        students[4]= new Student(5, "Soulaymane", 21 , 15 );



        // Print all
        System.out.println("== All Students ==");
        for (Student s : students) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        Student oldest = findOldest(students);
        System.out.println("The oldest student name is " + oldest.getName() + ", age is " + oldest.getAge() );

        // 3) Count adults
        System.out.println("The number of adults is  " +countAdults(students));

        // 4) Average grade
        System.out.println("The average grade of students " +averageGrade(students));

        // 5) Find by name
        String name = "Ilham";
        if (findStudentByName(students,name)!=null ){
            System.out.println("Their is a student with the name " + name + " who is : "+findStudentByName(students,name) ) ;
        }else {
            System.out.println("Their is no student called " + name + " in the list " ) ;
        }

        // 6) Sort by grade desc
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        sortByGradeDesc(students);
        for (Student s : students ) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(students);

        // 8) Update grade by id
        boolean updated = updateGrade(students, 4, 11 );
        System.out.println("\nUpdated id=4? " + updated);


        // 9) Duplicate names
        System.out.println("\nDuplicate? "+hasDuplicateNames(students));


        // 10) Append new student
        Student student =new  Student(1,"Dina" , 12 , 20);
        Student[] students1= appendStudent(students,student);

        // 11)
        Student[][] school = new Student[2][3];
        int k = 0 ;
        for(int i = 0 ; i< school.length ; i++) {
            for (int j = 0 ; j<school[i].length ; j++){
                school[i][j]=students1[k];
                k++;
            }
        }

        for(int i = 0 ; i< school.length ; i++) {
            System.out.println("Class " +(i+1) );
            for (int j = 0 ; j<school[i].length ; j++){
                System.out.println(school[i][j]);
            }
        }
        for(int i = 0 ; i< school.length ; i++) {
            sortByGradeDesc(school[i]);
            System.out.println("The Top Student in class " +(i+1) +" is : "+ school[i][0]);

        }


    }
}

