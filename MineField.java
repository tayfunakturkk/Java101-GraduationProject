package GraduationProject;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Objects;
public class MineField {
    int row,col;
    boolean isGameOver=false;
    int[][] map ;
    String[][] game ;
    MineField(int row,int col){
        this.row = row;
        this.col= col;
        this.map = new int[row][col];
        this.game = new String[row][col];
        createGame(col,row );
    }

    private void createGame(int row, int col) {
       int numberOfMine= (col*row)/4;
        Random random = new Random();
        int count= 0;
        while (count<numberOfMine){
          int mineRow= random.nextInt(row);
          int mineCol= random.nextInt(col);
          if(this.map[mineRow][mineCol]!=1){
              this.map[mineRow][mineCol]=1;
              count++;
          }
        }
        for (String[] strings : game) {
            Arrays.fill(strings, "-");

        }
    }

    public void run() {
        printMap();
        Scanner scanner = new Scanner(System.in);
        while (!isGameOver){
          printGame();
          System.out.print("Row:");
         int inputRow= scanner.nextInt();
         System.out.print("Column:");
         int inputCol=scanner.nextInt();
         if(inputCol>=col || inputCol<0){
             System.out.println("Wrong coordinate");
             continue;
         }
            if(inputRow>=row || inputRow<0){
                System.out.println("Wrong coordinate");
                continue;
            }
         select(inputRow,inputCol);
         if(isFinished()){
             System.out.println("You Win!!");
             break;
         }
        }
        if(isGameOver){
            System.out.println("Game Over!!");
            printMap();
        }
    }

    private void printMap() {
        System.out.println("----- map -------");
        for(int[] i : this.map){
            for(int j: i){
               System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("----- map -------");
    }

    private void select(int i, int j){
        int count=0;
        if(map[i][j]==1){
            this.isGameOver=true;
        }
        else {
            for (int k = i-1; k <=i+1 ; k++) {
                for (int l = j-1; l <=j+1 ; l++) {
                    if(k==i && l==j){
                        continue;
                    }
                        try {
                        count+=map[k][l];
                        }catch (Exception ignored){

                    }
                }
            }



        }

        this.game[i][j]=String.valueOf(count);
    }

    private void printGame(){
        System.out.println("-------------");
        for(String[] i : this.game){
            for(String j: i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
    private boolean isFinished(){
        boolean isEmpty=true;
        for(int i= 0; i<game.length;i++){
            for(int j=0; j<game[i].length;j++){
                if (Objects.equals(game[i][j], "-") && map[i][j]==0 ) {
                    isEmpty = false;
                    break;
                }
            }
        }
        return isEmpty;
    }
}





    










