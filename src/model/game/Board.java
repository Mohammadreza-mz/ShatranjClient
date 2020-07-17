package model.game;

import java.io.Serializable;

public class Board implements Serializable {
    public Piece[][] cells= new Piece[8][8];

    public Board() {
        //
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
