import java.util.*;
public class JavaLife {
	static boolean xy;
	private static boolean test_game(int[][] seed,int num_of_iterations, int[][] expected_state){
		int w_size=seed.length;
		int w_size1=seed[0].length;
		int x_size=expected_state.length;
		int x_size1=expected_state[0].length;
		World w= new World(seed, w_size, w_size1);
		World x= new World(expected_state, x_size, x_size1);
		String second= x.toString();
	
		for (int j=0; j < num_of_iterations; j++) {
		    w = w.iterate();
			System.out.println("Iteration " + (j + 1) + ":");
		    System.out.println(w.toString());
	}
		String first= w.toString();
		if(second.equals(first)){
			xy = true;
		}
		else{
		xy = false;
		}
		System.out.print(xy+"\n");
		return xy;
	}

	
	//public javaLife(int[][] seed, int num_of_iterations, int[][] expected_state){
		
	//}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the initial state of the World \n");
		System.out.println("row \n");
		int m=sc.nextInt();
	
		System.out.println("column \n");
		int n=sc.nextInt();

		int  maxIterations = 0;
		int seed[][]=new int[m][n];
		//int seed[][] = {{0,1,1,1},{1,1,1,0},{0,0,1,0}};
		System.out.println("enter the states \n");

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				seed[i][j]=sc.nextInt();
				
			}
		}
	
		System.out.println("Enter the number of iterations\n");
		maxIterations=sc.nextInt();
		//maxIterations = 2;
		System.out.println("Enter the Expected state of the World after the iterations \n");
		System.out.println("row\n");
		int m1=sc.nextInt();
		
		System.out.println("column\n");
		int n1=sc.nextInt();
	
		int expected_state[][]=new int[m1][n1];
		//int expected_state[][]={{1,1,0,0},{1,0,1,0},{0,1,0,0}};
		System.out.println("enter the states \n");
	
		for(int i=0;i<m1;i++){
			for(int j=0;j<n1;j++){
				expected_state[i][j]=sc.nextInt();
				
			}
		}
	
		System.out.println("Do you want to test the answer(Y/N) \n");
		String ans= sc.next();
		//String ans = "Y";
		if (ans.equals("Y")){
			JavaLife j1 = new JavaLife();
			j1.test_game(seed, maxIterations, expected_state);	
		}
		
		
		
		
		
		
	    }
		// TODO Auto-generated method stub
}



