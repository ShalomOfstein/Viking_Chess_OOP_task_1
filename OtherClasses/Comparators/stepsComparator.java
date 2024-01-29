package OtherClasses.Comparators;

import OtherClasses.Pieces.ConcretePiece;
import OtherClasses.ConcretePlayer;

import java.util.Comparator;

public class stepsComparator implements Comparator<ConcretePiece> {
    private final ConcretePlayer winner;

    public stepsComparator(ConcretePlayer winner) {
        this.winner = winner;
    }

    @Override
    public int compare(ConcretePiece p1, ConcretePiece p2) {
        if (p1.getSquares() > p2.getSquares()) {
            return -1;
        } else if (p1.getSquares() < p2.getSquares()) {
            return 1;
        } else {
            if (p1.getSerialNum() > p2.getSerialNum()) {
                return 1;
            } else if (p1.getSerialNum() < p2.getSerialNum()) {
                return -1;
            } else {
                if (p1.getOwner() == winner && p2.getOwner() != winner) {
                    return -1;
                } else if (p2.getOwner() == winner && p1.getOwner() != winner) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}