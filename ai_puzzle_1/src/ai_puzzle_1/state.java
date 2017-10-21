package ai_puzzle_1;

public class state {
	//properties
	private int bigJug;
	private int smallJug;
	private int state_id;
	private boolean visited;
	
	public int[] neigbours;
	private int neigbourCount;
	
	

	public state(int bigVal, int smallVal, int id)
	{
		setBigJug(bigVal);
		setSmallJug(smallVal);
		setState_id(id);
		visited = false; 
		neigbours = new int[6];
		neigbourCount = 0;
	}

	public int[] applyFunction(int funcNo)
	{
		int[] values = new int[2];
		
		if(funcNo == 0)//fill big jug
			{
				values[0] = 10;
				values[1] = smallJug;
			}
		else
			if(funcNo == 1)//fill small jug
				{
					values[0] = bigJug;
					values[1] = 6;
				}
			else
				if(funcNo == 2)//empty big jug
					{
						values[0] = 0;
						values[1] = smallJug;
					}
				else
					if(funcNo == 3)//empty small jug
						{
							values[0] = bigJug;
							values[1] = 0;
						}
					else
						if(funcNo == 4)//pour from small to big jar
						{
							if(10 - bigJug > smallJug )
							{
								values[0] = bigJug + smallJug;
								values[1] = 0;
							}
							else
							{
								values[1] = smallJug - (10-bigJug);
								values[0] = 10;
							}
						}
						else
							if(funcNo == 5)//pour from big to small jar
							{
								if(6 - smallJug > bigJug )
								{
									values[1] = bigJug + smallJug;
									values[0] = 0;
								}
								else
								{
									values[0] = bigJug - (6-smallJug);
									values[1] = 6;
								}
							}
		return values;
	}
	
	public boolean compare(int[] values)//If we don't care about a value it has -1 value
	{
		if(values[0] == bigJug && (values[1] == smallJug  || values[1] == -1))
			return true;
		else
			if( (values[0] == bigJug || values[0] == -1) && values[1] == smallJug  )
				return true;
		return false;
	}
	
	public int getNeigbourCount() {
		return neigbourCount;
	}
	
	
	public void setNeigbour(int stateId)
	{
		neigbours[neigbourCount++] = stateId;
	}
	
	public int getBigJug() {
		return bigJug;
	}


	private void setBigJug(int bigJug) {
		this.bigJug = bigJug;
	}


	public int getSmallJug() {
		return smallJug;
	}


	private void setSmallJug(int smallJug) {
		this.smallJug = smallJug;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public void setVisited(boolean val)
	{
		visited = val;
	}
	public boolean isVisited() {
		return visited;
	}
}
