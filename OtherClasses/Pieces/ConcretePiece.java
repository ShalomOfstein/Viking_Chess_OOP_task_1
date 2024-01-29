package OtherClasses.Pieces;
import OtherClasses.Interfaces.Piece;
import OtherClasses.Interfaces.Player;
import OtherClasses.Position;

import java.util.LinkedList;

public abstract class ConcretePiece implements Piece {
    protected Player owner;
    protected LinkedList<Position> listOfMoves;
    protected int squares;
    protected int num;



    //constructors
    public ConcretePiece(Player o,int n){
        this.num=n;
        this.owner=o;
        this.squares=0;
        this.listOfMoves = new LinkedList<Position>();
    }
    public ConcretePiece(Player o,int n,Position p){
        this.num=n;
        this.owner=o;
        this.squares=0;
        this.listOfMoves = new LinkedList<Position>();
        this.listOfMoves.add(p);
    }

    //getters and setters fot the squares each piece has moved
    //and an abstract print function for the squares
    public void addSquares(int n){
        this.squares= this.squares+n;
    }
    public void removeSquares(int n){
        this.squares= this.squares-n;
    }
    public int getSquares(){
        return this.squares;
    }
    public abstract void printSquares();



    //getters and setters for the list of moves
    //and an abstract print function for the list of moves

//    public LinkedList<Position> getListOfMoves(){
//        return this.listOfMoves;
//    }
    public void addMove(Position a){
        listOfMoves.add(a);
    }
    public void removeLastMove(){
        listOfMoves.removeLast();
    }
    public int getNumOfMoves(){
        return listOfMoves.size();
    }
    public abstract void printListOfMoves();



    //the implementation of the interface functions
    @Override
    public Player getOwner(){
        return this.owner;
    }
    @Override
    public abstract String getType();



    //getter for the serial number of the piece
    //the serial number is final so there are no setters
    public int getSerialNum(){
        return this.num;
    }
}
