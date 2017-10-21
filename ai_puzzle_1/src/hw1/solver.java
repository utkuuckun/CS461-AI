package hw1;
import java.util.Stack;


public class solver {
	//properties
	state start;
	int stateCount;
	state[] states;
	int[] goalVals;
	Stack stack;
	
	
	public solver(int startBigJug, int startSmallJug, int endBigJug, int endSmallJug)
	{
		states = new state[100];	//Holds the graph
		stateCount = 0;
		start = new state(startBigJug, startSmallJug, stateCount++);
		states[0] = start;
		goalVals = new int[2];
		goalVals[0] = endBigJug; 
		goalVals[1] = endSmallJug;
		stack = new Stack();	//Holds the first found solution
	}
	
	
	public void createNet()
	{
		for(int i = 0; i < stateCount; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				boolean temp = true;	//for making sure if the state is a new state, we create it and add it to the net
				int[] values = states[i].applyFunction(j);
				for(int k = 0; k < stateCount && temp; k++)
				{
					if(states[k].compare(values))
					{
						if(i != k)
							states[i].setNeigbour(k);
						temp = false;
					}
				}
				if(temp) //The state is a new state/creating a new state. 
				{
					//This is where we can draw the state on the state graph
					
					
					states[i].setNeigbour(stateCount);
					states[stateCount] = new state(values[0], values[1], stateCount);
					stateCount++;
				}
			}
		}
		
	}
	
	
	
	public boolean DFS(state current)	//Depth-First Traversal to find the solution in graph. Returns false if it cannot fount a solution
	{
		
		//This is where we can highlight the node to red. Then, we need turn it's color to normal before all return statements
		
		
		if(current.isVisited())
			return false;
		if(current.compare(goalVals))
		{
			stack.push(current);
			return true;
		}
		else
		{	
			
			for(int i = 0; i < current.getNeigbourCount(); i++)	
			{
				current.setVisited(true);
				if(DFS(states[current.neigbours[i]]))
				{
					stack.push(current);
					return true;
				}
			}
			return false;
		}
	}
}
