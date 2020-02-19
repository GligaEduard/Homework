import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) throws IOException {
        File file = new File("src/students.txt");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\n");
        FileWriter writter = new FileWriter("src/statistics.txt");
        Student[] arrayOfStudents;
        arrayOfStudents = new Student[10];
        for (int i = 0; i < arrayOfStudents.length; i++) {
            String[] firstStudentInformation = scanner.next().split(", ");
            arrayOfStudents[i] = new Student(firstStudentInformation[0], firstStudentInformation[1], Integer.valueOf(firstStudentInformation[2]), firstStudentInformation[3], Double.valueOf(firstStudentInformation[4]));
        }
        writter.write("Students with grades above 6.5: \n");
        for (int j = 0; j < arrayOfStudents.length; j++) {
            if (arrayOfStudents[j].grades > 6.5) {
                writter.write(arrayOfStudents[j].firstName + " " + arrayOfStudents[j].lastName + "\n");
            }
        }
//
           writter.write("\nStudents with age higher than 22: \n");
           for (int k = 0 ; k < arrayOfStudents.length; k++){
               if (arrayOfStudents[k].age < 22) {
                   writter.write(arrayOfStudents[k].firstName + " " + arrayOfStudents[k].lastName + "\n");
               }

           }

           writter.write("\nStudents with grade higher than 5 and are in the informatica department: \n");
           for (int l = 0; l < arrayOfStudents.length ; l++){
               if (arrayOfStudents[l].grades < 5 && arrayOfStudents[l].department.equals("Informatica") ){
                   writter.write(arrayOfStudents[l].firstName + " " + arrayOfStudents[l].lastName + "\n");
               }
           }
           writter.write("\nStudents wich failed the exam: \n");
           for(int m = 0; m < arrayOfStudents.length; m++ ){
               if(arrayOfStudents[m].grades < 5){
                   writter.write(arrayOfStudents[m].firstName + " " + arrayOfStudents[m].lastName + "\n");
               }
           }

           writter.write("\nStudents wich have last name longer than 5 characters: \n");
           for (int n = 0; n < arrayOfStudents.length; n++){
               if(arrayOfStudents[n].lastName.length() > 5){
                   writter.write(arrayOfStudents[n].lastName + "\n");
               }
           }
           writter.write("\nStudents which are in the Matematica department and are older than 22 and have grades higher than 6 : \n");
           for(int o = 0; o < arrayOfStudents.length; o++){
               if (arrayOfStudents[o].department.equals("Matematica")  && arrayOfStudents[o].age > 22 && arrayOfStudents[o].grades > 6 ){
                   writter.write(arrayOfStudents[o].firstName + " " + arrayOfStudents[o].lastName + "\n");
               }
           } writter.close();
    }
}