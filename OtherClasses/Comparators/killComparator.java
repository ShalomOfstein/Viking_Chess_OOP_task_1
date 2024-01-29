package OtherClasses.Comparators;

import OtherClasses.Pieces.ConcretePiece;
import OtherClasses.ConcretePlayer;
import OtherClasses.Pieces.King;
import OtherClasses.Pieces.Pawn;

import java.util.Comparator;

public class killComparator implements Comparator<ConcretePiece> {
    private ConcretePlayer winner;

    public killComparator(ConcretePlayer winner) {
        this.winner = winner;
    }
    @Override
    public int compare(ConcretePiece k1, ConcretePiece k2) {
        if (k1 instanceof King) {return 1;}
        else if (k2 instanceof King) {return -1;}
        else if(k1 instanceof Pawn p1 && k2 instanceof Pawn p2){
            if (p1.getKills() > p2.getKills()) {return -1;}
            else if (p1.getKills() < p2.getKills()) {return 1;}
            else {
                if(p1.getSerialNum() > p2.getSerialNum()){return 1;}
                else if(p1.getSerialNum() < p2.getSerialNum()){return -1;}
                else{
                    if(p1.getOwner() == winner && p2.getOwner()!=winner) {return -1;}
                    else if(p2.getOwner() == winner && p1.getOwner()!=winner) {return 1;}
                    else {return 0;}
                }
            }
        }
        return 0;
    }
}
