class StrikeBoard
{
	private int[][] strikeBoard=new int[10][10];
	
	public void addStrike(int[] array,boolean successfulHit)
	{
		int x=array[0];
		int y=array[1];
		if(successfulHit)
		{
			strikeBoard[x][y]=1;
		}
		else
		{
			strikeBoard[x][y]=-1;
		}
	}
	
	public boolean isValidCandidate(int[] array)
	{
		int x=array[0];
		int y=array[1];
		if(x>=0 && x<=9 && y>=0 && y<=9)
		{
			if(strikeBoard[x][y]==0)
			{
				return true;
			}
		}
		return false;
	}
	
	public void printBoard()
	{
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{
				if(strikeBoard[x][y]>=0)
				{
					System.out.print(" "+strikeBoard[x][y]+" ");
				}
				else
				{
					System.out.print(strikeBoard[x][y]+" ");
				}
			}
			System.out.println("");
		}
	}
}
