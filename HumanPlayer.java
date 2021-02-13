import java.util.Scanner;
import java.util.Random;

class HumanPlayer
{
	private String name;
	private StrikeBoard StrikeBoard=new StrikeBoard();
	private ShipBoard ShipBoard=new ShipBoard();
	
	public HumanPlayer(String name)
	{
		this.name=name;
		System.out.println(name+", please enter your ships:");
		ShipBoard.enterAllShipsManually();
	}
	
	public int[] nextStrike()
	{
		System.out.println(name+", please enter the next position you wish to hit:");
		Scanner input=new Scanner(System.in);
		int x=input.nextInt();
		int y=input.nextInt();
		int[] strike={x,y};
		return strike;
	}
	
	public void update(int[] array,boolean successfulHit)
	{
		StrikeBoard.addStrike(array,successfulHit);
	}
	
	public boolean getStrike(int[] array)
	{
		return ShipBoard.getStrike(array);
	}
	
	public boolean allShipsSank()
	{
		return ShipBoard.allShipsSank();
	}
	
	public boolean lastStrikeSankShip()
	{
		return ShipBoard.lastStrikeSankShip();
	}
	
	public String toString()
	{
		return name;
	}
	
	public void getStrikeBoard()
	{
		System.out.println(name+"'s strikeboard:");
		StrikeBoard.printBoard();
	}
	
	public void getShipBoard()
	{
		ShipBoard.printBoard();
	}
}
