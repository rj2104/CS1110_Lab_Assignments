import java.util.*;
public class n_queen_ {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] chess = new int[n][n];
		print_chess (chess, "", 0);
		System.out.println(count);
	}
	public static void print_chess(int[][] chess, String qsf, int row) { 
		if(row == chess.length) {
			System.out.println(qsf);		
			count++;
			return ;
		}
		for (int col = 0; col< chess.length; col++){
			if(Safe_queen_pt (chess, row, col) == true){
				chess[row][col] = 1; 
				print_chess (chess, qsf + row + "-"+ col + ",", row + 1);
				chess[row][col] = 0;	
			}		
		}
	}	
	public static boolean Safe_queen_pt(int[][] chess, int row, int col){ 
		for (int i = row - 1, j = col; i >= 0; i--){
			if(chess[i][j] == 1){
				return false;
			}
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >=0; i--, j--){ 
			if (chess[i][j] == 1) {
				return false;
			}
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){ 
			if (chess[i][j] == 1) {
				return false;
			}
		}
		return true;
	}
	
}
	
	
