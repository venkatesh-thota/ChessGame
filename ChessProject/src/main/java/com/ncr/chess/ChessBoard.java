package com.ncr.chess;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];
    }

    public void addPiece(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        if(xCoordinate>=MAX_BOARD_WIDTH || yCoordinate>=MAX_BOARD_HEIGHT || xCoordinate<0 || yCoordinate<0){
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }
        if(pieces[xCoordinate][yCoordinate]==null){
            pawn.setXCoordinate(xCoordinate);
            pawn.setYCoordinate(yCoordinate);
            pieces[xCoordinate][yCoordinate] = pawn;
        } else {
            //if(pieces[xCoordinate][yCoordinate].getPieceColor().equals(pieceColor)){
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            //}
        }
        return;
    }

    public boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        if(xCoordinate>=0 && yCoordinate>=0 &&  xCoordinate<=MAX_BOARD_WIDTH && yCoordinate<=MAX_BOARD_HEIGHT){
            return true;
        }
        return false;
    }

    public void resetBoard(){
        for(int i=0;i<=MAX_BOARD_WIDTH;i++){
            for(int j=0;j<=MAX_BOARD_HEIGHT;j++) {
                pieces[i][j] = null;
            }
        }
    }
}
