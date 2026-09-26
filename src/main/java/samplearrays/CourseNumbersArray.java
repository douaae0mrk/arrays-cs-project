package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = new int[registeredCourses.length+1];
        for(int i=0 ; i< registeredCourses.length ; i++ ){
            updatedCourses[i]=registeredCourses[i];
        }
        updatedCourses[registeredCourses.length]=2030;
        for(int i:updatedCourses){
            System.out.println(i);
        }
        int x = 2050 ;
        boolean isIn = false ;
        for(int i:updatedCourses){
            if (x==i ){
                System.out.println("The course "+ x + " is in the updatedCourses ");
                isIn = true;
                break ;
            }
        }
        if(!isIn){
            System.out.println("The course "+ x + " is not in the updatedCourses ");
        }

    }
}
