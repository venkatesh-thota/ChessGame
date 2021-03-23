package com.ncr.chess;

import java.util.Objects;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if(movementType==MovementType.CAPTURE){
            if(this.getPieceColor().equals(PieceColor.WHITE) && Math.abs(newX-this.xCoordinate)==1
                    && (newY == this.yCoordinate+1 || newY == this.yCoordinate+2)){
                this.xCoordinate = newX;
                this.yCoordinate = newY;
            }
            else if(this.getPieceColor().equals(PieceColor.BLACK) && Math.abs(newX-this.xCoordinate)==1 &&
                    (newY == this.yCoordinate-1 || newY == this.yCoordinate-2)){
                this.xCoordinate = newX;
                this.yCoordinate = newY;
            }
        } else{
            if(this.getPieceColor().equals(PieceColor.WHITE) &&
                    newX==this.xCoordinate && newY == this.yCoordinate+1){
                this.xCoordinate = newX;
                this.yCoordinate = newY;
            }
            else if(this.getPieceColor().equals(PieceColor.BLACK) &&
                    newX==this.xCoordinate && newY == this.yCoordinate-1){
                this.xCoordinate = newX;
                this.yCoordinate = newY;
            }
        }


    }

    @Override
    public String toString() {
        return getCurrentPositionAsString();
    }

    protected String getCurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return xCoordinate == pawn.xCoordinate &&
                yCoordinate == pawn.yCoordinate &&
                pieceColor == pawn.pieceColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate, pieceColor);
    }
}
