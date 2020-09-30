import java.util.*;

class twel {
	static int r;
	static int c;
	static int a[][];
	static int b[][];

	public static void main(String[] args) {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("->");
		System.out.println("Enter 0 if the path is obstacle free");
		System.out.println("Enter 1 to introduce a snake");
		System.out.println("Enter 2 to introduce a ladder");
		System.out.println("->");
		System.out.println("Enter the height of game");
		r = sc.nextInt();
		System.out.println("Enter the width of game");
		c = sc.nextInt();
		a = new int[r][c];
		b = new int[r][c];
		int player[]=new int[4];
		int dice = 0, locr = 0, locc = 0, size = 0, currplayer = 0,
				i = 0, j = 0, k = 0, w = 0;
		size = r * c;
		System.out.println("Enter the values for snakes/ladder/neither and the advantage/penalty(if applicable)");
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				a[i][j] = sc.nextInt();
				if (a[i][j] == 0)
					b[i][j] = 0;
				if (a[i][j] == 1) {
					System.out.println("Enter the penalty");
					int p = sc.nextInt();
					b[i][j] = p;
				}
				if (a[i][j] == 2) {
					System.out.println("Enter the advantage");
					int ad = sc.nextInt();
					b[i][j] = ad;
				}
			}
		}
		while (w != 1) {
			for (k = 0; k < 4; k++) {
				dice = random.nextInt(6) + 1;
				System.out.println("Value of dice: " + dice);
				currplayer = player[k];
				player[k] = winner(currplayer, dice);
				System.out.println("Present value of Player"+(k+1)+": " + player[k]);
				if (player[k] >= size) {
					System.out.println("Player "+(k+1)+" Wins!");
					w = 1;
					break;
				}
			}
		}
	}

	static int winner(int currplayer, int dice) {
		int co = 0, i = 0, j = 0;
		currplayer += dice;
		for (i = 0; i < r; i++) {
			for (j = 0; j < c; j++) {
				co++;
				if (co == currplayer) {
					if (a[i][j] == 1 || a[i][j] == 2)
						currplayer += b[i][j];
					if (currplayer < 0)
						currplayer = 0;
				}
			}
		}
		return currplayer;
	}
}
