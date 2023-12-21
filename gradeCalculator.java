import java.util.Scanner;
public class gradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter the number of subjects: ");
        int numOfSubject = sc.nextInt();

        int totalMarks = 0;

        for(int i = 1; i <= numOfSubject; i++){
            System.out.println("Enter the marks for subject "+ i + " between 0 - 100: ");
            int marks = sc.nextInt();

            if(marks < 0 || marks > 100){
                System.out.println("Invalid marks!");
                return;
            }

            totalMarks += marks;
        }

        double averagePercentage = (double)totalMarks / numOfSubject;

        System.out.println("Results: ");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);

        String grade = calculateGrade(averagePercentage);
        System.out.println("Grade: "+ grade);
    }

    public static String calculateGrade(double averagePercentage){
        if(averagePercentage >= 90){
            return "A+";
        }
        else if(averagePercentage >= 80){
            return "A";
        }
        else if(averagePercentage >= 70){
            return "B";
        }
        else if(averagePercentage >= 60){
            return "C";
        }
        else if(averagePercentage >= 50){
            return "D";
        }
        else{
            return "E";
        }
    }
}