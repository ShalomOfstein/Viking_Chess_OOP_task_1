package OtherClasses.Pieces;

import OtherClasses.Interfaces.Player;
import OtherClasses.Position;

public class Pawn extends ConcretePiece{

private int kills; //number of kills the pawn has made


//constructors
    public Pawn(Player owner, int serial){
        super(owner,serial);
        this.kills =0;
    }
    public Pawn(Player owner, int serial, Position p){
        super(owner,serial,p);
        this.kills =0;
    }


    //the implementation of the abstract functions to print the list of moves
    @Override
    public void printListOfMoves() {
        String str ="";
        if(this.owner.isPlayerOne()) str=str+"D";
        if(!this.owner.isPlayerOne()) str=str+"A";
        str=str+this.num+": [";
        for(int i=0; i< this.listOfMoves.size()-1;i++){
            Position po = this.listOfMoves.get(i);
           str=str + "("+po.getX()+", "+po.getY()+"), ";
        }
        Position po = this.listOfMoves.getLast();
        str=str + "("+po.getX()+", "+po.getY()+")]";
        System.out.println(str);
    }

    // function to print the number of kills the pawn has made
    public void printKills(){
        String str ="";
        if(this.owner.isPlayerOne()) str=str+"D";
        if(!this.owner.isPlayerOne()) str=str+"A";
        str=str+this.num+": "+this.kills+" kills";
        System.out.println(str);
    }
    // implementation of the abstract function to print the type of the piece fot the GUI
    @Override
    public String getType() {
        if(this.owner.isPlayerOne()) return "♙";
        else {
            return "♟";
        }
    }


    //getters and setters fot the number of kills the pawn has made
    public void addKill(){
        this.kills++;
    }
    public void removeKill(){
        this.kills--;
    }
    public int getKills(){
        return this.kills;
    }


    //implementation of the abstract function to print the squares the piece has moved
    public void printSquares(){
        String str ="";
        if(this.owner.isPlayerOne()) str=str+"D";
        if(!this.owner.isPlayerOne()) str=str+"A";
        str=str+this.num+": "+this.squares+" squares";
        System.out.println(str);
    }

}
