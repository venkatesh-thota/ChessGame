package com.ncr.chess;

/* An abstract class to represent common functionality of all chess pieces */
public abstract class Piece {

    private boolean killed = false;
    private PieceColor color ;

    public Piece(PieceColor color)
    {
        this.setColor(color);
    }

    public void setColor(PieceColor color)
    {
        this.color = color;
    }

    public boolean isKilled()
    {
        return this.killed;
    }

    public void setKilled(boolean killed)
    {
        this.killed = killed;
    }

    public abstract boolean canMove(ChessBoard board,
                                    int startX, int endX, int startY, int endY);
}

