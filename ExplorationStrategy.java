
class ExplorationStrategy
{
	private StrikeBoard StrikeBoard=new StrikeBoard();
	private int[] hitRangeStart=new int[2];
	private int[] hitRangeEnd=new int[2];
	
	public ExplorationStrategy(StrikeBoard other)
	{
		this.StrikeBoard=other;
	}
	
	public void initialize(int[] array)
	{
		int x=array[0];
		int y=array[1];
		if(x>=0 && x<=9 && y>=0 && y<=9)
		{
			hitRangeStart[0]=x;
			hitRangeStart[1]=y;
			hitRangeEnd[0]=x;
			hitRangeEnd[1]=y;
		}
	}
	
	public int[] nextStrike()
	{
		int[] right={hitRangeStart[0],hitRangeStart[1]+1};
		int[] left={hitRangeStart[0],hitRangeStart[1]-1};
		int[] above={hitRangeStart[0]-1,hitRangeStart[1]};
		int[] below={hitRangeStart[0]+1,hitRangeStart[1]};
		if(hitRangeStart[0]==hitRangeEnd[0] & hitRangeStart[1]==hitRangeEnd[1])
		{
			if(StrikeBoard.isValidCandidate(right))
			{
				return right;
			}
			if(StrikeBoard.isValidCandidate(left))
			{
				return left;
			}
			if(StrikeBoard.isValidCandidate(above))
			{
				return above;
			}
			if(StrikeBoard.isValidCandidate(below))
			{
				return below;
			}
		}
		if(hitRangeStart[0]==hitRangeEnd[0] & hitRangeStart[1]<hitRangeEnd[1])
		{
			int[] nextHit={hitRangeEnd[0],hitRangeEnd[1]+1};
			if(StrikeBoard.isValidCandidate(nextHit))
			{
				return nextHit;
			}
			int[] alternativeHit={hitRangeStart[0],hitRangeStart[1]-1};
			return alternativeHit;
		}
		if(hitRangeStart[0]==hitRangeEnd[0] & hitRangeStart[1]>hitRangeEnd[1])
		{
			int[] nextHit={hitRangeEnd[0],hitRangeEnd[1]-1};
			if(StrikeBoard.isValidCandidate(nextHit))
			{
				return nextHit;
			}
			int[] alternativeHit={hitRangeStart[0],hitRangeStart[1]+1};
			return alternativeHit;
		}
		if(hitRangeStart[1]==hitRangeEnd[1] & hitRangeStart[0]>hitRangeEnd[0])
		{
			int[] nextHit={hitRangeEnd[0]-1,hitRangeEnd[1]};
			if(StrikeBoard.isValidCandidate(nextHit))
			{
				return nextHit;
			}
			int[] alternativeHit={hitRangeStart[0]+1,hitRangeStart[1]};
			return alternativeHit;
		}
		if(hitRangeStart[1]==hitRangeEnd[1] & hitRangeStart[0]<hitRangeEnd[0])
		{
			int[] nextHit={hitRangeEnd[0]+1,hitRangeEnd[1]};
			if(StrikeBoard.isValidCandidate(nextHit))
			{
				return nextHit;
			}
			int[] alternativeHit={hitRangeStart[0]-1,hitRangeStart[1]};
			return alternativeHit;
		}
		return null;
	}	
	public void update(int[] array)
	{
		int x=array[0];
		int y=array[1];
		hitRangeEnd[0]=x;
		hitRangeEnd[1]=y;
	}
	
}
