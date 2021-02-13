import java.util.Scanner;
import java.util.Random;

class RandomStrategy
{
	private int[][] choices=new int[10][10];
	
	public int[] nextStrike()
	{
		Random randomGenerator=new Random();
		int x=randomGenerator.nextInt(10);
		int y=randomGenerator.nextInt(10);
		int[] strike=new int[2];
		if(choices[x][y]==0)
		{
			strike[0]=x;
			strike[1]=y;
		}
		else
		{
			while(choices[x][y]==1)
			{
				x=randomGenerator.nextInt(10);
				y=randomGenerator.nextInt(10);
			}
			strike[0]=x;
			strike[1]=y;
		}
		return strike;
	}
	
	public void update(int[] array)
	{
		choices[array[0]][array[1]]=1;
	}
}
