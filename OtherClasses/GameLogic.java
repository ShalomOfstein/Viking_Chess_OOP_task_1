package OtherClasses;

import OtherClasses.Comparators.PositionComparator;
import OtherClasses.Comparators.killComparator;
import OtherClasses.Comparators.moveComparator;
import OtherClasses.Comparators.stepsComparator;
import OtherClasses.Interfaces.Piece;
import OtherClasses.Interfaces.PlayableLogic;
import OtherClasses.Interfaces.Player;
import OtherClasses.Pieces.ConcretePiece;
import OtherClasses.Pieces.King;
import OtherClasses.Pieces.Pawn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class GameLogic implements PlayableLogic {
    private final Position[][] board;
    private final int boardSize;
    private final ConcretePlayer player1;
    private final ConcretePlayer player2;
    private final ConcretePiece king;
    private Position KingPosition;
    private boolean isSecondTurn;
    private final Stack <Memory> memory;
    private final ArrayList<ConcretePiece> allPieces;
    private final ArrayList<Position> allPositions;
    private ConcretePlayer winner;


    //constructor
    public GameLogic(){
        this.allPositions = new ArrayList<>();
        this.isSecondTurn = true;
        this.boardSize = 11;
        this.board = new Position[boardSize][boardSize];
        for(int x = 0 ; x < boardSize; x++){
            for(int y=0 ; y < boardSize; y++){
                board[x][y]=new Position(x,y);
                allPositions.add(board[x][y]);
            }
        }
        this.allPieces = new ArrayList<>();
        this.player1 = new ConcretePlayer(true);
        this.player2 = new ConcretePlayer(false);
        this.king = new King(player1,board[5][5]);
        setAllPieces();
        memory= new Stack<Memory>();
        this.winner = null;

    }

    public void setAllPieces(){
        //initiate the king
        board[5][5].addPiece(king);
        KingPosition = board[5][5];
        //initiate the attackers 1-6
        board[3][0].addPiece(new Pawn(player2,1,board[3][0]));
        board[4][0].addPiece(new Pawn(player2,2,board[4][0]));
        board[5][0].addPiece(new Pawn(player2,3,board[5][0]));
        board[6][0].addPiece(new Pawn(player2,4,board[6][0]));
        board[7][0].addPiece(new Pawn(player2,5,board[7][0]));
        board[5][1].addPiece(new Pawn(player2,6,board[5][1]));
        //initiate the attackers on left side
        board[0][3].addPiece(new Pawn(player2,7,board[0][3]));
        board[0][4].addPiece(new Pawn(player2,9,board[0][4]));
        board[0][5].addPiece(new Pawn(player2,11,board[0][5]));
        board[0][6].addPiece(new Pawn(player2,15,board[0][6]));
        board[0][7].addPiece(new Pawn(player2,17,board[0][7]));
        board[1][5].addPiece(new Pawn(player2,12,board[1][5]));
        //initiate the attackers on right side
        board[10][3].addPiece(new Pawn(player2,8,board[10][3]));
        board[10][4].addPiece(new Pawn(player2,10,board[10][4]));
        board[10][5].addPiece(new Pawn(player2,14,board[10][5]));
        board[10][6].addPiece(new Pawn(player2,16,board[10][6]));
        board[10][7].addPiece(new Pawn(player2,18,board[10][7]));
        board[9][5].addPiece(new Pawn(player2,13,board[9][5]));
        //initiate the attackers 19-24
        board[3][10].addPiece(new Pawn(player2,20,board[3][10]));
        board[4][10].addPiece(new Pawn(player2,21,board[4][10]));
        board[5][10].addPiece(new Pawn(player2,22,board[5][10]));
        board[6][10].addPiece(new Pawn(player2,23,board[6][10]));
        board[7][10].addPiece(new Pawn(player2,24,board[7][10]));
        board[5][9].addPiece(new Pawn(player2,19,board[5][9]));
        //initiate the attackers 19-24
        board[5][3].addPiece(new Pawn(player1,1,board[5][3]));
        board[4][4].addPiece(new Pawn(player1,2,board[4][4]));
        board[5][4].addPiece(new Pawn(player1,3,board[5][4]));
        board[6][4].addPiece(new Pawn(player1,4,board[6][4]));
        board[3][5].addPiece(new Pawn(player1,5,board[3][5]));
        board[4][5].addPiece(new Pawn(player1,6,board[4][5]));
        board[6][5].addPiece(new Pawn(player1,8,board[6][5]));
        board[7][5].addPiece(new Pawn(player1,9,board[7][5]));
        board[4][6].addPiece(new Pawn(player1,10,board[4][6]));
        board[5][6].addPiece(new Pawn(player1,11,board[5][6]));
        board[6][6].addPiece(new Pawn(player1,12,board[6][6]));
        board[5][7].addPiece(new Pawn(player1,13,board[5][7]));

        //add all the pieces to the array list allPieces
        for(int x = 0 ; x < boardSize; x++){
            for(int y=0 ; y < boardSize; y++){
                if(board[x][y].getPiece()!=null) {
                    allPieces.add((ConcretePiece) board[x][y].getPiece());
                    board[x][y].addPieceTolist((ConcretePiece) board[x][y].getPiece());
                }
            }
        }
    }
    @Override
    public boolean move(Position a, Position b) {
        int xa = a.getX();
        int ya = a.getY();
        int xb = b.getX();
        int yb = b.getY();
        b=board[xb][yb];
        a=board[xa][ya];
        ConcretePiece p = (ConcretePiece) getPieceAtPosition(a);
        if(isSecondTurn!=(p.getOwner()==player2))return false;
        //if the position is the same
        if(xa==xb&&ya==yb) return false;
        //if the position is diagonal
        if(xa!=xb&&ya!=yb) return false;
        //if the pawn is trying to enter a corner
        boolean corner = (xb==0&&yb==0)||(xb==10&&yb==0)||(xb==0&&yb==10)||(xb==10&&yb==10);
        if((p!=king)&&corner) return false;
        //check the path is clear
        if(xa==xb){
            if(ya<yb){
                for(int k=ya+1;k<=yb;k++){
                    if(board[xa][k].getPiece()!=null) return false;
                }
            }
            if(ya>yb){
                for(int k=yb;k<ya;k++){
                    if(board[xa][k].getPiece()!=null) return false;
                }
            }
        }
        if(ya==yb){
            if(xa<xb){
                for(int k=xa+1;k<=xb;k++){
                    if(board[k][ya].getPiece()!=null) return false;
                }
            }
            if(xa>xb){
                for(int k=xb;k<xa;k++){
                    if(board[k][ya].getPiece()!=null) return false;
                }
            }
        }

        board[xa][ya].removePiece();
        board[xb][yb].addPiece(p);
        p.addMove(b);
        p.addSquares(calculateSquares(a,b));
        b.addPieceTolist(p);
        if(p==king) KingPosition = board[xb][yb];
        ConcretePiece[] kills = checkIfAte(p,b);
        isSecondTurn = !isSecondTurn;
        Memory move= new Memory(b,a,kills);
        memory.push(move);
        if(isGameFinished()) PrintStats(this.winner);
        return true;
    }

    public int calculateSquares(Position a,Position b){
        if(a.getX()==b.getX()) return Math.abs(a.getY()-b.getY());
        if(a.getY()==b.getY()) return Math.abs(a.getX()-b.getX());
        return 0;
    }

    public ConcretePiece[] checkIfAte(Piece p, Position a){
        ConcretePiece[] kills = new ConcretePiece[4];
        if(p instanceof Pawn) {
            boolean upIsEmpty = (a.getY() - 1 >= 0) ;
            if (upIsEmpty) {
                Position up = board[a.getX()][a.getY() - 1];
                if (up.getPiece() != null && up.getPiece().getOwner() != p.getOwner()&& up.getPiece()!=king) {
                    if ((a.getY()-2 < 0)||(board[a.getX()][a.getY() - 2].isCorner())||(board[a.getX()][a.getY() - 2].getPiece() != null && board[a.getX()][a.getY() - 2].getPiece().getOwner() == p.getOwner()&& board[a.getX()][a.getY() - 2].getPiece()!= king)) {
                        kills[0]=up.getPiece();
                        up.removePiece();
                        ((Pawn) p).addKill();
                    }
                }
            }
            boolean DownIsEmpty = (a.getY() + 1 <= 10);
            if (DownIsEmpty) {
                Position down = board[a.getX()][a.getY() + 1];
                if (down.getPiece() != null && down.getPiece().getOwner() != p.getOwner() && down.getPiece()!=king) {
                    if ((a.getY()+2 >10)||(board[a.getX()][a.getY() + 2].isCorner())||(board[a.getX()][a.getY() + 2].getPiece() != null && board[a.getX()][a.getY() + 2].getPiece().getOwner() == p.getOwner()&& board[a.getX()][a.getY() + 2].getPiece()!= king)) {
                        kills[2]=down.getPiece();
                        down.removePiece();
                        ((Pawn) p).addKill();
                    }
                }
            }
            boolean LeftIsEmpty = (a.getX() - 1 >= 0);
            if (LeftIsEmpty) {
                Position left = board[a.getX() - 1 ][a.getY()];
                if (left.getPiece() != null && left.getPiece().getOwner() != p.getOwner() && left.getPiece()!=king) {
                    if ((a.getX()-2 <0)||(board[a.getX()-2][a.getY()].isCorner())||(board[a.getX() - 2 ][a.getY()].getPiece() != null && board[a.getX() - 2 ][a.getY()].getPiece().getOwner() == p.getOwner()&& board[a.getX() - 2 ][a.getY()].getPiece()!=king)) {
                        kills[3]= left.getPiece();
                        left.removePiece();
                        ((Pawn) p).addKill();
                    }
                }
            }
            boolean RightIsEmpty = (a.getX() + 1 <= 10);
            if (RightIsEmpty) {
                Position right = board[a.getX() + 1 ][a.getY()];
                if (right.getPiece() != null && right.getPiece().getOwner() != p.getOwner() && right.getPiece()!=king) {
                    if ((a.getX()+2 > 10)||(board[a.getX()+2][a.getY()].isCorner())||(board[a.getX() + 2 ][a.getY()].getPiece() != null && board[a.getX() + 2 ][a.getY()].getPiece().getOwner() == p.getOwner()&& board[a.getX() + 2 ][a.getY()].getPiece()!=king)) {
                        kills[1]=right.getPiece();
                        right.removePiece();
                        ((Pawn) p).addKill();
                    }
                }
            }
        }
        return kills;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        return board[position.getX()][position.getY()].getPiece();
    }

    @Override
    public Player getFirstPlayer() {
        return player1;
    }

    @Override
    public Player getSecondPlayer() {
        return player2;
    }

    public boolean isKingSurrounded(){
        boolean kingUp= (KingPosition.getY()-1<0 || (board[KingPosition.getX()][KingPosition.getY()-1].getPiece()!=null&&(board[KingPosition.getX()][KingPosition.getY()-1].getPiece().getOwner()==player2)));
        boolean kingDown= (KingPosition.getY()+1>10 || (board[KingPosition.getX()][KingPosition.getY()+1].getPiece()!=null&&(board[KingPosition.getX()][KingPosition.getY()+1].getPiece().getOwner()==player2)));
        boolean kingLeft= (KingPosition.getX()-1<0 || (board[KingPosition.getX()-1][KingPosition.getY()].getPiece()!=null&&(board[KingPosition.getX()-1][KingPosition.getY()].getPiece().getOwner()==player2)));
        boolean kingRight= (KingPosition.getX()+1>10 || (board[KingPosition.getX()+1][KingPosition.getY()].getPiece()!=null&& (board[KingPosition.getX()+1][KingPosition.getY()].getPiece().getOwner()==player2)));
        return (kingUp&&kingDown&&kingLeft&&kingRight);
    }

    //there is still more to do in this method!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public boolean isGameFinished() {
        boolean kingInCorner = ((board[0][0].getPiece()==king)||(board[10][10].getPiece()==king)||(board[0][10].getPiece()==king)||(board[10][0].getPiece()==king));
        if (kingInCorner) {
            player1.addWin();
            this.winner = player1;
            return true;
        }
        boolean kingIsSurrounded = isKingSurrounded();
        if (kingIsSurrounded) {
            player2.addWin();
            this.winner = player2;
            return true;
        }
        return false;
    }

    @Override
    public boolean isSecondPlayerTurn(){
        return isSecondTurn;
    }

    @Override
    public void reset() {
        for(int x=0; x<boardSize;x++){
            for(int y=0; y<boardSize;y++){
                board[x][y].removePiece();
            }
        }
        allPieces.clear();
        setAllPieces();
        isSecondTurn=true;
        this.winner= null;
        memory.clear();
    }

    @Override
    public void undoLastMove() {
        if(!memory.isEmpty()){
            Memory move = memory.pop();
            ConcretePiece p = (ConcretePiece) getPieceAtPosition(move.get_now()) ;
            board[move.get_last().getX()][move.get_last().getY()].addPiece(p);
            board[move.get_now().getX()][move.get_now().getY()].removePiece();
            for(int i=0; i<4;i++){
                if(move.get_kills()[i]!=null){
                    if (i==0)  board[move.get_now().getX()][move.get_now().getY()-1].addPiece(move.get_kills()[0]);
                    if (i==1)  board[move.get_now().getX()+1][move.get_now().getY()].addPiece(move.get_kills()[1]);
                    if (i==2)  board[move.get_now().getX()][move.get_now().getY()+1].addPiece(move.get_kills()[2]);
                    if (i==3)  board[move.get_now().getX()-1][move.get_now().getY()].addPiece(move.get_kills()[3]);
                    if(p instanceof Pawn) ((Pawn) p).removeKill();
                }
            }
            move.get_now().removePieceFromList(p);
            p.removeLastMove();
            p.removeSquares(calculateSquares(move.get_last(),move.get_now()));
            isSecondTurn=!isSecondTurn;
        }
    }

    @Override
    public int getBoardSize() {
        return boardSize;
    }

    public void PrintStats(ConcretePlayer winner){
        //sort the pieces by the winning team first
        //and then by the amount of moves they made
        //and then by the serial number
        //print the moves of all the pieces that moved more than once
        Comparator<ConcretePiece> moveComparator = new moveComparator(winner);
        allPieces.sort(moveComparator);
        for(ConcretePiece piece:allPieces){
            if(piece.getNumOfMoves()>1) {
                piece.printListOfMoves();
            }
        }
        for(int i =0; i<75;i++){
            System.out.print("*");
        }
        System.out.println();

        //sort the pieces by the amount of kills they made
        //and then by the serial number
        //and then by the winning team first
        //print the moves of all the pieces that moved more than once
        Comparator<ConcretePiece> killComparator = new killComparator(winner);
        allPieces.sort(killComparator);
        for(ConcretePiece piece:allPieces){
            if(piece instanceof Pawn p){
                if(p.getKills()>0) {
                    p.printKills();
                }
            }
        }
        for(int i =0; i<75;i++){
            System.out.print("*");
        }
        System.out.println();

        //sort the pieces by the amount of squares they moved
        //and then by the serial number
        //and then by the winning team first
        //print the moves of all the pieces that moved more than once
        Comparator<ConcretePiece> stepsComparator = new stepsComparator(winner);
        allPieces.sort(stepsComparator);
        for(ConcretePiece piece:allPieces){
            if(piece.getSquares()>0){
                piece.printSquares();
            }
        }
        for(int i =0; i<75;i++){
            System.out.print("*");
        }
        System.out.println();

        Comparator<Position> PositionComparator = new PositionComparator();
        allPositions.sort(PositionComparator);
        for(Position po:allPositions){
            if(po.numOfPieces()>1){
                po.printPieces();
            }
        }
        for(int i =0; i<75;i++){
            System.out.print("*");
        }
        System.out.println();
    }
}
