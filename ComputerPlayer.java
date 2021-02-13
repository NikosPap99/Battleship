// the class that implement the computer logic
class ComputerPlayer
{
	private ShipBoard ShipBoard=new ShipBoard();
	private StrikeBoard StrikeBoard=new StrikeBoard();
	private String name="HAL";
	private RandomStrategy RandomStrategy=new RandomStrategy();
	private ExplorationStrategy ExplorationStrategy=new ExplorationStrategy(StrikeBoard);
	private ComputerStrategies ComputerStrategies=new ComputerStrategies(RandomStrategy,ExplorationStrategy); 
	
	public ComputerPlayer()
	{
		ShipBoard.enterAllShipsRandomly(); // the computer places the ships randomly
	}
	
	public int[] nextStrike()
	{
		return ComputerStrategies.nextStrike();
	}
	
	public void update(int[] array,boolean successfulHit) // update the strikeboard and the strategies with the correct information about the previous strike
	{
		StrikeBoard.addStrike(array,successfulHit);
		ComputerStrategies.update(array,successfulHit);
	}
	
	public boolean getStrike(int[] array) // update the shipboard with the opponent's strike
	{
		return ShipBoard.getStrike(array);
	}
	
	public boolean allShipsSank() 
	{
		return ShipBoard.allShipsSank();
	}
	
	public String toString()
	{
		return name;
	}
	
	public void getStrikeBoard() // used for console interaction
	{
		System.out.println("Computer's strikeboard:");
		StrikeBoard.printBoard();
	}
	
	public void getShipBoard() // used for console interaction
	{
		System.out.println("Computer's shipboard:");
		ShipBoard.printBoard();
	}
	
	public void completeExploration()
	{
		ComputerStrategies.completeExploration();
	}
}
