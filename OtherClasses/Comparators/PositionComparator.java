package OtherClasses.Comparators;


import OtherClasses.Position;

import java.util.Comparator;

public class PositionComparator implements Comparator<Position> {

    public PositionComparator() {
    }
    @Override
    public int compare(Position p1, Position p2) {
        if (p1.numOfPieces() > p2.numOfPieces()) {
            return -1;
        } else if (p1.numOfPieces() < p2.numOfPieces()) {
            return 1;
        } else {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() < p2.getX()) {
                return -1;
            } else {
                if (p1.getY() > p2.getY()) {
                    return 1;
                } else if (p1.getY() < p2.getY()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
