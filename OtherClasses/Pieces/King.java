package OtherClasses.Pieces;

import OtherClasses.Interfaces.Player;
import OtherClasses.Position;

public class King extends ConcretePiece{
//constructor
    public King(Player p){
        super(p,7);
    }
    public King(Player p, Position po){
        super(p,7,po);
    }

    @Override
    public void printListOfMoves() {

        String str ="K7: [";
        for(int i=0; i< this.listOfMoves.size()-1;i++){
            Position po = this.listOfMoves.get(i);
            str=str + "("+po.getX()+", "+po.getY()+"), ";
        }
        Position po = this.listOfMoves.getLast();
        str=str + "("+po.getX()+", "+po.getY()+")]";
        System.out.println(str);
    }
    public void printSquares(){
        String str ="K7: "+this.squares+" squares";
        System.out.println(str);
    }

    @Override
    public String getType() {
        return "♔";
    }
}
