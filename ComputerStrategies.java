// class that uses the random computer attacks and the strategic attacks, according to the situation
// strategic means that when the computer hits a ship, it searches the nearby area in the next attacks, until it sinks the ship
// random strategy is used until the computer hits a ship. In this case, it switches to the exploration strategy until the ship is sank

class ComputerStrategies
{
	private StrikeBoard StrikeBoard=new StrikeBoard();
	private RandomStrategy RandomStrategy=new RandomStrategy();
	private ExplorationStrategy ExplorationStrategy=new ExplorationStrategy(StrikeBoard);
	private boolean ExplorationProccess=false;
	
	public ComputerStrategies(RandomStrategy other1,ExplorationStrategy other2)
	{
		this.RandomStrategy=other1;
		this.ExplorationStrategy=other2;
	}
		
	public int[] nextStrike()
	{
		if(ExplorationProccess) // if the previous strike was succesfull, we use the exploration strategy
		{
			return ExplorationStrategy.nextStrike();
		}
		return RandomStrategy.nextStrike(); // else, we use the random strategy
	}
		
	public void update(int[] array,boolean successfulHit)
	{
		RandomStrategy.update(array);
		if(successfulHit)
		{	
			if(ExplorationProccess) // if we are already in the exploration process, we need to update the process, NOT initalise it
			{
				ExplorationStrategy.update(array);
			}
			else
			{
				ExplorationProccess=true;
				ExplorationStrategy.initialize(array); // if we start the process now, we initialise it
			}
		}
	}
		
	public void completeExploration()
	{
		ExplorationProccess=false;
	}
}
