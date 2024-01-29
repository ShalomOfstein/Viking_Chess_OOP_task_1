package OtherClasses;

import OtherClasses.Interfaces.Player;

public class ConcretePlayer implements Player {
    private boolean isPlayerOne;
    private int wins;


    //constructor
    public ConcretePlayer (boolean playerOne){
        this.isPlayerOne =playerOne;
        this.wins = 0;
    }
    //setters
    public void addWin(){
        this.wins = wins + 1;
    }

    // getters
    @Override
    public boolean isPlayerOne() {
        return isPlayerOne;
    }

    @Override
    public int getWins() {
        return wins;
    }





}
