package OtherClasses.Comparators;

import OtherClasses.Pieces.ConcretePiece;
import OtherClasses.ConcretePlayer;

import java.util.Comparator;

public class moveComparator implements Comparator<ConcretePiece> {
private ConcretePlayer winner;

    public moveComparator(ConcretePlayer winner) {
        this.winner = winner;
    }
    @Override
    public int compare(ConcretePiece k1, ConcretePiece k2) {
        if(k1.getOwner() == winner && k2.getOwner()!=winner) {return -1;}
        if(k2.getOwner() == winner && k1.getOwner()!=winner) {return 1;}
        else {
            if (k1.getNumOfMoves() > k2.getNumOfMoves()) {return 1;}
            else if (k1.getNumOfMoves() < k2.getNumOfMoves()) {return -1;}
            else {
                if (k1.getSerialNum() > k2.getSerialNum()){return 1;}
                else if (k1.getSerialNum()< k2.getSerialNum()) {return -1;}
                else {return 0;}
            }
        }
    }
}
