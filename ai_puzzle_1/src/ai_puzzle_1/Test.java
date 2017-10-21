package ai_puzzle_1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		solver solv = new solver(0,0,8,-1);
		
		solv.createNet();
		
		solv.DFS(solv.start);
		System.out.print("done");
	}

}
