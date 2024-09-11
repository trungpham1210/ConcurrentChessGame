package edu.utdallas.cs4348;

import java.util.List;

public class ChessMatch {

    // Do not modify these, and do not add any other member variables to this class
    private ChessMove playerOneMove;
    private ChessMove playerTwoMove;

    // Your private Runnable implementations here
    private class Dinh implements Runnable {
        private final List<ChessMove> playerOneMoves;
        private final MoveRecord moveRecord;

        public Dinh(List<ChessMove> playerOneMoves, MoveRecord moveRecord) {
            this.playerOneMoves = playerOneMoves;
            this.moveRecord = moveRecord;
        }

        @Override
        public void run() {
            for (ChessMove chessMove : playerOneMoves){
                synchronized (ChessMatch.this){
                    playerOneMove = chessMove;
                    ChessMatch.this.notify();

                    while (playerTwoMove == null) {
                        try {
                            ChessMatch.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    moveRecord.addMove(playerTwoMove);
                    playerTwoMove = null;
                }
            }
        }
    }

    private class Pham implements Runnable {
        private final List<ChessMove> playerTwoMoves;
        private final MoveRecord moveRecord;

        public Pham(List<ChessMove> playerTwoMoves, MoveRecord moveRecord) {
            this.playerTwoMoves = playerTwoMoves;
            this.moveRecord = moveRecord;
        }

        @Override
        public void run() {
            for (ChessMove chessMove : playerTwoMoves){
                synchronized (ChessMatch.this){
                    while (playerOneMove == null) {
                        try {
                            ChessMatch.this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    moveRecord.addMove(playerOneMove);
                    playerOneMove = null;

                    playerTwoMove = chessMove;
                    ChessMatch.this.notify();
                }
            }
        }
    }

    public MoveRecord playMoves(List<ChessMove> playerOneMoves, List<ChessMove> playerTwoMoves) {
        MoveRecord moveRecord = new MoveRecord();

        // Your code here. :)
        Thread playerOneThread = new Thread(new Dinh(playerOneMoves, moveRecord));
        Thread playerTwoThread = new Thread(new Pham(playerTwoMoves, moveRecord));

        playerOneThread.start();
        playerTwoThread.start();

        try {
            playerOneThread.join(2000);
            playerTwoThread.join(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (playerOneThread.isAlive() || playerTwoThread.isAlive()) {
            throw new RuntimeException("Threads did not complete in time");
        }

        return moveRecord;
    }
}
