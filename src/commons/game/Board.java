package commons.game;

import java.io.Serializable;

public class Board implements Serializable {
    public Piece[][] cells= new Piece[8][8];

    public Board() {
        cells[0][0]=new Rook(0,0, Color.BLACK,this);
        cells[7][0]=new Rook(7,0, Color.BLACK,this);

        cells[1][0]=new Knight(1,0, Color.BLACK,this);
        cells[6][0]=new Knight(6,0, Color.BLACK,this);

        cells[2][0]=new Bishop(2,0, Color.BLACK,this);
        cells[5][0]=new Bishop(5,0, Color.BLACK,this);

        cells[3][0]=new Queen(3,0, Color.BLACK,this);
        cells[4][0]=new King(4,0, Color.BLACK,this);

        for(int i=0;i<8;i++)
            cells[i][1]= new Pawn(i,1,Color.BLACK,this);

        cells[0][7]=new Rook(0,7, Color.WHITE,this);
        cells[7][7]=new Rook(7,7, Color.WHITE,this);

        cells[1][7]=new Knight(1,7, Color.WHITE,this);
        cells[6][7]=new Knight(6,7, Color.WHITE,this);

        cells[2][7]=new Bishop(2,7, Color.WHITE,this);
        cells[5][7]=new Bishop(5,7, Color.WHITE,this);

        cells[3][7]=new King(3,7, Color.WHITE,this);
        cells[4][7]=new Queen(4,7, Color.WHITE,this);

        for(int i=0;i<8;i++)
            cells[i][6]= new Pawn(i,6,Color.WHITE,this);

    }

    public Color occupiedByColor(int x,int y){
        if(!Pawn.fitInBoard(x,y))
            return null;
        if(cells[x][y]==null)
            return null;
        return cells[x][y].color;
    }

    public boolean canMove(int fromX,int fromY, int toX, int toY){
        if(!Pawn.fitInBoard(fromX,fromY) || !Pawn.fitInBoard(toX,toY))
            return false;
        if(cells[fromX][fromY]== null)
            return false;
        return cells[fromX][fromY].canMoveTo(toX,toY);
    }
    public boolean Move(int fromX,int fromY, int toX, int toY) {
        if(!canMove(fromX,fromY,toX,toY))
            return false;
        if(cells[toX][toY]!=null)
            cells[toX][toY].setNotPlaying();
        cells[fromX][fromY].moveTo(toX,toY);
        cells[toX][toY]=cells[fromX][fromY];
        cells[fromX][fromY]=null;
        return true;
    }
}
