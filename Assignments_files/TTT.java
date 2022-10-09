import java.util.Scanner;
public class TTT {
    
    public static void printBoard(char[][] ttt) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ttt[i][j]);
            }
            System.out.println();
        }
    }
    public static char Winner(char[][] ttt) {

        for (int i = 0; i < 3; i++) {
            if (ttt[i][0] == ttt[i][1] && ttt[i][1] == ttt[i][2] && ttt[i][0] != '-') {
                return ttt[i][0];
            }
        }
        for (int j = 0; j < 3; j++) {
            if (ttt[0][j] == ttt[1][j] && ttt[1][j] == ttt[2][j] && ttt[0][j] != '-') {
                return ttt[0][j];
            }
        }
        if (ttt[0][0] == ttt[1][1] && ttt[1][1] == ttt[2][2] && ttt[0][0] != '-') {
            return ttt[0][0];
        }
        if (ttt[2][0] == ttt[1][1] && ttt[1][1] == ttt[0][2] && ttt[2][0] != '-') {
            return ttt[2][0];
        }
        return ' ';
    }
    public static boolean is_draw(char[][] ttt) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ttt[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] ttt = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ttt[i][j] = '-';
            }
        }
        System.out.print("Player1 name: ");
        String p1 = sc.nextLine();
        System.out.print("Player2 name: ");
        String p2 = sc.nextLine();
        boolean player1 = true;
        char c1 = '-';
        char c2 = '-';
        System.out.println(p1 + " Choose x or o");
        c1 = sc.next().charAt(0);
        if (c1 == 'x') {
            c2 = 'o';
        } else {
            c2 = 'x';
        }
        boolean tillnow = false;
        while (!tillnow) {
            printBoard(ttt);
            if (player1) {
                System.out.println(p1 + " turn(" + c1 + ") ");
            } else {
                System.out.println(p2 + " turn(" + c2 + ") ");
            }
            int row = 0;
            int col = 0;
            while (true) {
                System.out.print("Enter row: ");
                row = sc.nextInt();
                System.out.print("Enter col: ");
                col = sc.nextInt();
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("not accurate , try again!");
                } else if (ttt[row][col] != '-') {
                    System.out.println("occupied , try again!");
                } else {
                    break;
                }
            }
            if(player1)
            ttt[row][col] = c1;
            else
            ttt[row][col] = c2;
            if (Winner(ttt) == c1) {
                System.out.println(p1 + " won!");
                tillnow = true;
            } else if (Winner(ttt) == c2) {
                System.out.println(p2 + " won!");
                tillnow = true;
            } else {
                if (is_draw(ttt)) {
                    System.out.println("draw!");
                    tillnow = true;
                } else {
                    player1 = !player1;
                }
            }
        }
        printBoard(ttt);
    }
}