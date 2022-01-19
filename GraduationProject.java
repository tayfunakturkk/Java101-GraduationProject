package GraduationProject;
import java.util.Scanner;
public class GraduationProject {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int row,column;
        System.out.println("Welcome the Minefield");
        System.out.println("");
        System.out.print("Enter the Row:");
        row=input.nextInt();
        System.out.print("Enter the Column:");
        column=input.nextInt();
    
    MineField mine=new MineField(row,column);
    mine.run();
    
}
}
