import java.util.Scanner;
import java.util.Random;

class ShipBoard
{
	private int[] size={2,3,3,4,5}; // the sizes oh each ship in the game, reduced every time one gets hit
	private int[][] ships=new int[10][10]; // the game board will be a 10x10 matrix of integers, where 0 represents empty space and each ship is represented by its size number in each block
	private boolean[][] hitShips=new boolean[10][10]; // pos true for hit, false for never hit
	private boolean lastSankShip=false; 
	
	private void enterShipRandomly(int id) // enter one ship in a random position (the computer us that)
	{
		String direction;
		Random randomGenerator=new Random();
		boolean directionHelper=randomGenerator.nextBoolean();
		if(directionHelper==true)
		{
			direction="horizontal";
		}
		else
		{
			direction="vertical";
		}
		if(direction.equals("horizontal"))
		{
			int x=randomGenerator.nextInt(10);
			int y=randomGenerator.nextInt(11-size[id-1]);
			for(int i=0;i<size[id-1];i++)
			{
				while(ships[x][y+i]!=0)
				{
					x=randomGenerator.nextInt(10);
					y=randomGenerator.nextInt(11-size[id-1]);
					i=0;
				}
			}
			for(int i=0;i<size[id-1];i++)
			{
				ships[x][y+i]=id;
			}
		}
		if(direction.equals("vertical"))
		{
			int x=(size[id-1]-1)+randomGenerator.nextInt(11-size[id-1]);
			int y=randomGenerator.nextInt(10);
			for(int i=0;i<size[id-1];i++)
			{
				while(ships[x-i][y]!=0)
				{
					x=(size[id-1]-1)+randomGenerator.nextInt(11-size[id-1]);
					y=randomGenerator.nextInt(10);
					i=0;
				}
			}
			for(int i=0;i<size[id-1];i++)
			{
				ships[x-i][y]=id;
			}
		}
	}
	
	public void enterAllShipsRandomly() // for computer use
	{
		for(int i=1;i<6;i++)
		{
			enterShipRandomly(i);
		}
	}
	
	private void enterShipManually(int id) // enter a ship through keyboard input
	{
		System.out.println("Please enter the starting position (two numbers) and direction (horizontal/vertical) for ship Number "+id+" with size="+size[id-1]+":");
		Scanner input=new Scanner(System.in);
		int x=input.nextInt();
		int y=input.nextInt();
		String direction=input.next();
		while((!direction.equals("horizontal")&!direction.equals("vertical")) || (x<0 || x>9 || y<0 || y>9) )
		{
			System.out.println("The direction must strictly be entered as either horizontal or vertical and the numbers must be between 0 and 9, please enter everything again:");
			x=input.nextInt();
			y=input.nextInt();
			direction=input.next();	
		}
		if(direction.equals("horizontal"))
		{ 
			for(int i=0;i<size[id-1];i++)
			{
				if((y+i)>9)
				{
					System.out.println("Ship out of bounds, please enter another starting position (without entering direction):");
					x=input.nextInt();
					y=input.nextInt();	
					i=0;
				}
			}
			for(int i=0;i<size[id-1];i++)
			{
				if(ships[x][y+i]!=0)
				{
					System.out.println("This ship meets another ship, please enter another starting position (without entering direction):");
					x=input.nextInt();
					y=input.nextInt();
					i=0;
				}
			}
			for(int i=0;i<size[id-1];i++)
			{
				ships[x][y+i]=id;
			}
		}
		if(direction.equals("vertical"))
		{
			for(int i=0;i<size[id-1];i++)
			{
				if((x-i)<0)
				{
					System.out.println("Ship out of bounds, please enter another starting position (without entering direction):");
					x=input.nextInt();
					y=input.nextInt();	
					i=0;
				}
			}			
			for(int i=0;i<size[id-1];i++)
			{
				while(ships[x-i][y]!=0)
				{
					System.out.println("This ship meets another ship, please enter another starting position (without entering direction):");
					x=input.nextInt();
					y=input.nextInt();
				}
			}
			for(int i=0;i<size[id-1];i++)
			{
				ships[x-i][y]=id;
			}
		}
		return;
	}
	
	public void enterAllShipsManually() // calls the enterShipManually function 5 times in order to enable user to position each ship
	{
		for(int i=1;i<6;i++)
		{
			enterShipManually(i);
		}
	}
	
	public boolean getStrike(int[] array) // gets the opposition's strike position
	{
		int x=array[0];
		int y=array[1];
		if(hitShips[x][y]==false)
		{
			hitShips[x][y]=true;
			if(ships[x][y]!=0)
			{
				size[ships[x][y]-1]--;
				if(size[ships[x][y]-1]==0)
					{
						lastSankShip=true;
						System.out.println("A shot at ("+x+","+y+") hit a ship and it sank it!");
					}
					else
					{
						System.out.println("A shot at ("+x+","+y+") hit a ship, but it didn't sink it!");
						lastSankShip=false;
					}
				return true;
			}
			else
			{
				System.out.println("An unfortunate shot at ("+x+","+y+") didn't hit a ship.");
				lastSankShip=false;
			}
		}
		return false;
	}
	
	public boolean allShipsSank() // returns true if every ship has been hit, used for finising the game
	{
		for(int i=0;i<5;i++)
		{
			if(size[i]!=0)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean lastStrikeSankShip() // used for terminal interaction and also computer strategy
	{
		return lastSankShip;
	}
	
	public void printBoard() // print the board
	{
		for(int x=0;x<10;x++)
		{
			for(int y=0;y<10;y++)
			{
				System.out.print(" "+ships[x][y]+" ");
			}
			System.out.println("");
		}
	}

}
