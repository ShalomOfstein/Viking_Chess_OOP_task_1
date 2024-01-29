package OtherClasses;

import OtherClasses.Pieces.ConcretePiece;

public class Position {
     private final int X;
     private final int Y;
     private ConcretePiece piece;
     private final int[] pieces;


    //constructor
    public Position(int x, int y) {
        this.X = x;
        this.Y = y;
        this.piece = null;
        this.pieces = new int[37];

    }

    //
    public void addPiece(ConcretePiece p){
        this.piece = p;
    }
    public void removePiece(){
        this.piece = null;
    }


    //getters
    public ConcretePiece getPiece(){
        return this.piece;
    }
    public int getX(){
        return this.X;
    }
    public int getY(){
        return this.Y;
    }

    public void addPieceTolist(ConcretePiece p){
        if(p.getOwner().isPlayerOne()) {
            this.pieces[p.getSerialNum()-1]++;
        }
        else{
            this.pieces[p.getSerialNum()+12]++;
        }
    }
    public void removePieceFromList(ConcretePiece p){
        if(p.getOwner().isPlayerOne()) {
            this.pieces[p.getSerialNum()-1]--;
        }
        else{
            this.pieces[p.getSerialNum()+12]--;
        }
    }
    public int numOfPieces(){
        int count=0;
        for(int p: this.pieces){
            if(p>0) count++;
        }
        return count;
    }
    public void printPieces(){
        String str ="("+this.X+", "+this.Y+")"+this.numOfPieces()+" pieces";
        System.out.println(str);
    }
    public boolean isCorner(){
        if(this.X==0 && this.Y==0) return true;
        if(this.X==0 && this.Y==10) return true;
        if(this.X==10 && this.Y==0) return true;
        if(this.X==10 && this.Y==10) return true;
        return false;
    }
}
