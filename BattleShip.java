import java.util.Scanner;
import java.util.Random;

class BattleShip
{
	private static void HumanVsComputer()
	{
		HumanPlayer player=new HumanPlayer("Nick");
		ComputerPlayer computer=new ComputerPlayer();
		player.getShipBoard();
		//computer.getShipBoard(); I first used that to test the game
		while(!player.allShipsSank() && !computer.allShipsSank())
		{
			int[] playerStrike=player.nextStrike();
			System.out.println("Your move:");
			boolean computerHit=computer.getStrike(playerStrike);
			player.update(playerStrike,computerHit);
			player.getStrikeBoard();
			if(computer.allShipsSank())
			{
				System.out.println(computer+", all your ships are sunk! "+player+" wins!");
				break;
			}
			int[] computerStrike=computer.nextStrike();
			System.out.println("Computer's move:");
			boolean playerHit=player.getStrike(computerStrike);
			computer.update(computerStrike,playerHit);
			//computer.getStrikeBoard(); I used that to test the game too
			if(player.lastStrikeSankShip())
			{
				computer.completeExploration();
			}
			if(player.allShipsSank())
			{
				System.out.println(player+", all your ships are sunk! "+computer+" wins!");
				break;
			}
		}
	}
	
	private static void HumanVsHuman()
	{
		HumanPlayer playerOne=new HumanPlayer("Nick");
		HumanPlayer playerTwo=new HumanPlayer("Alex");
		while(!playerOne.allShipsSank() && !playerTwo.allShipsSank())
		{
			int[] playerOneStrike=playerOne.nextStrike();
			System.out.println(playerOne+"'s move:");
			boolean playerTwoHit=playerTwo.getStrike(playerOneStrike);
			playerOne.update(playerOneStrike,playerTwoHit);
			playerOne.getStrikeBoard();
			if(playerTwo.allShipsSank())
			{
				System.out.println(playerTwo+", all your ships are sunk! "+playerOne+" wins!");
				break;
			}
			int[] playerTwoStrike=playerTwo.nextStrike();
			System.out.println(playerTwo+"'s move:");
			boolean playerOneHit=playerOne.getStrike(playerTwoStrike);
			playerTwo.update(playerTwoStrike,playerOneHit);
			playerTwo.getStrikeBoard();
			if(playerOne.allShipsSank())
			{
				System.out.println(playerOne+", all your ships are sunk! "+playerTwo+" wins!");
				break;
			}
		}
	}
	
    public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to the Battleship game! Enter 1 for Player vs Computer mode or 2 for Player vs Player mode:");
		int answer=input.nextInt();
		while(answer!=1 && answer!=2)
		{
			System.out.println("Remember, enter 1 for Player vs Computer mode or 2 for Player vs Player mode:");
			answer=input.nextInt();
		}
		if(answer==1)
		{
			HumanVsComputer();
		}
		if(answer==2)
		{
			HumanVsHuman();
		}
	}
}
