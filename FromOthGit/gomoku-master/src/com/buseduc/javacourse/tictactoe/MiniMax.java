package com.buseduc.javacourse.tictactoe;

import java.util.ArrayList;

public class MiniMax {

    private static final int winScore = 100000000;
    private static int evaluationCount = 0;
    private static int winLine;

    public static int[] calculateNextMove(int winLine, int depth, int[][] board) {
        MiniMax.winLine = winLine;
        int[] move = new int[2];
        Object[] bestMove = searchWinningMove(board);
        if (bestMove != null) {
            move[0] = (Integer) (bestMove[1]);
            move[1] = (Integer) (bestMove[2]);
        } else {
            bestMove = miniMax(depth, board, true, -1.0, winScore);
            if (bestMove[1] == null) {
                move = null;
            } else {
                move[0] = (Integer) (bestMove[1]);
                move[1] = (Integer) (bestMove[2]);
            }
        }
        evaluationCount = 0;
        return move;
    }

    private static double evaluateBoardForWhite(int[][] board, boolean blacksTurn) {
        evaluationCount++;
        double blackScore = getScore(board, true, blacksTurn);
        double whiteScore = getScore(board, false, blacksTurn);
        if (blackScore == 0) blackScore = 1.0;
        return whiteScore / blackScore;
    }

    private static int getScore(int[][] board, boolean forBlack, boolean blacksTurn) {
        return evaluateHorizontal(board, forBlack, blacksTurn) +
                evaluateVertical(board, forBlack, blacksTurn) +
                checkHorizontalLines(board, forBlack, blacksTurn);
    }

    private static Object[] miniMax(int depth, int[][] board, boolean max, double alpha, double beta) {
        if (depth == 0) {
            return new Object[]{evaluateBoardForWhite(board, !max), null, null};
        }
        ArrayList<int[]> allPossibleMoves = generateMoves(board);
        if (allPossibleMoves.size() == 0) {
            return new Object[]{evaluateBoardForWhite(board, !max), null, null};
        }
        Object[] bestMove = new Object[3];
        if (max) {
            bestMove[0] = -1.0;
            for (int[] move : allPossibleMoves) {
                int[][] dummyBoard = newBoard(board);
                makeAMove(dummyBoard, move[1], move[0], false);
                Object[] tempMove = miniMax(depth - 1, dummyBoard, false, alpha, beta);
                if ((double) (tempMove[0]) > alpha) {
                    alpha = (Double) (tempMove[0]);
                }
                if ((double) (tempMove[0]) >= beta) {
                    return tempMove;
                }
                if ((double) tempMove[0] > (double) bestMove[0]) {
                    bestMove = tempMove;
                    bestMove[1] = move[0];
                    bestMove[2] = move[1];
                }
            }
        } else {
            bestMove[0] = (double) winScore;
            bestMove[1] = allPossibleMoves.get(0)[0];
            bestMove[2] = allPossibleMoves.get(0)[1];
            for (int[] move : allPossibleMoves) {
                int[][] dummyBoard = newBoard(board);
                makeAMove(dummyBoard, move[1], move[0], true);
                Object[] tempMove = miniMax(depth - 1, dummyBoard, true, alpha, beta);
                if (((double) tempMove[0]) < beta) {
                    beta = (Double) (tempMove[0]);
                }
                if ((double) (tempMove[0]) <= alpha) {
                    return tempMove;
                }
                if ((double) tempMove[0] < (double) bestMove[0]) {
                    bestMove = tempMove;
                    bestMove[1] = move[0];
                    bestMove[2] = move[1];
                }
            }
        }
        return bestMove;
    }

    private static Object[] searchWinningMove(int[][] board) {
        ArrayList<int[]> allPossibleMoves = generateMoves(board);
        Object[] winningMove = new Object[3];
        for (int[] move : allPossibleMoves) {
            evaluationCount++;
            int[][] dummyBoard = newBoard(board);
            makeAMove(dummyBoard, move[1], move[0], false);
            if (getScore(dummyBoard, false, false) >= winScore) {
                winningMove[1] = move[0];
                winningMove[2] = move[1];
                return winningMove;
            }
        }
        return null;
    }

    private static ArrayList<int[]> generateMoves(int[][] board) {
        ArrayList<int[]> moveList = new ArrayList<>();
        int boardSize = board.length;
        for (int i = 0; i < boardSize; i++) {
            int j = 0;
            while (j < boardSize) {
                if (board[i][j] > 0) {
                    j++;
                    continue;
                }
                if (i > 0) {
                    if (j > 0) {
                        if (board[i - 1][j - 1] > 0 ||
                                board[i][j - 1] > 0) {
                            int[] move = {i, j};
                            moveList.add(move);
                            j++;
                            continue;
                        }
                    }
                    if (j < boardSize - 1) {
                        if (board[i - 1][j + 1] > 0 ||
                                board[i][j + 1] > 0) {
                            int[] move = {i, j};
                            moveList.add(move);
                            j++;
                            continue;
                        }
                    }
                    if (board[i - 1][j] > 0) {
                        int[] move = {i, j};
                        moveList.add(move);
                        j++;
                        continue;
                    }
                }
                if (i < boardSize - 1) {
                    if (j > 0) {
                        if (board[i + 1][j - 1] > 0 ||
                                board[i][j - 1] > 0) {
                            int[] move = {i, j};
                            moveList.add(move);
                            j++;
                            continue;
                        }
                    }
                    if (j < boardSize - 1) {
                        if (board[i + 1][j + 1] > 0 ||
                                board[i][j + 1] > 0) {
                            int[] move = {i, j};
                            moveList.add(move);
                            j++;
                            continue;
                        }
                    }
                    if (board[i + 1][j] > 0) {
                        int[] move = {i, j};
                        moveList.add(move);
                    }
                }
                j++;
            }
        }
        return moveList;
    }

    private static int[][] newBoard(int[][] board) {
        int[][] newBoard;
        newBoard = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    private static void makeAMove(int[][] board, int posX, int posY, boolean black) {
        board[posY][posX] = black ? 2 : 1;
    }

    private static int evaluateHorizontal(int[][] boardMatrix, boolean forBlack, boolean playersTurn) {
        int consecutive = 0;
        int blocks = 2;
        int score = 0;
        for (int[] matrix : boardMatrix) {
            for (int j = 0; j < boardMatrix[0].length; j++) {
                if (matrix[j] == (forBlack ? 2 : 1)) {
                    consecutive++;
                } else if (matrix[j] == 0) {
                    if (consecutive > 0) {
                        blocks--;
                        score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                        consecutive = 0;
                        blocks = 1;
                    } else {
                        blocks = 1;
                    }
                } else if (consecutive > 0) {
                    score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                    consecutive = 0;
                    blocks = 2;
                } else {
                    blocks = 2;
                }
            }
            if (consecutive > 0) {
                score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
            }
            consecutive = 0;
            blocks = 2;
        }
        return score;
    }

    private static int evaluateVertical(int[][] boardMatrix, boolean forBlack, boolean playersTurn) {
        int consecutive = 0;
        int blocks = 2;
        int score = 0;
        for (int j = 0; j < boardMatrix[0].length; j++) {
            for (int[] matrix : boardMatrix) {
                if (matrix[j] == (forBlack ? 2 : 1)) {
                    consecutive++;
                } else if (matrix[j] == 0) {
                    if (consecutive > 0) {
                        blocks--;
                        score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                        consecutive = 0;
                        blocks = 1;
                    } else {
                        blocks = 1;
                    }
                } else if (consecutive > 0) {
                    score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                    consecutive = 0;
                    blocks = 2;
                } else {
                    blocks = 2;
                }
            }
            if (consecutive > 0) {
                score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
            }
            consecutive = 0;
            blocks = 2;
        }
        return score;
    }

    private static int checkHorizontalLines(int[][] boardMatrix, boolean forBlack, boolean playersTurn) {
        int consecutive = 0;
        int blocks = 2;
        int score = 0;
        for (int k = 0; k <= 2 * (boardMatrix.length - 1); k++) {
            int iStart = Math.max(0, k - boardMatrix.length + 1);
            int iEnd = Math.min(boardMatrix.length - 1, k);
            for (int i = iStart; i <= iEnd; ++i) {
                int j = k - i;

                if (boardMatrix[i][j] == (forBlack ? 2 : 1)) {
                    consecutive++;
                } else if (boardMatrix[i][j] == 0) {
                    if (consecutive > 0) {
                        blocks--;
                        score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                        consecutive = 0;
                        blocks = 1;
                    } else {
                        blocks = 1;
                    }
                } else if (consecutive > 0) {
                    score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                    consecutive = 0;
                    blocks = 2;
                } else {
                    blocks = 2;
                }
            }
            if (consecutive > 0) {
                score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
            }
            consecutive = 0;
            blocks = 2;
        }
        for (int k = 1 - boardMatrix.length; k < boardMatrix.length; k++) {
            int iStart = Math.max(0, k);
            int iEnd = Math.min(boardMatrix.length + k - 1, boardMatrix.length - 1);
            for (int i = iStart; i <= iEnd; ++i) {
                int j = i - k;

                if (boardMatrix[i][j] == (forBlack ? 2 : 1)) {
                    consecutive++;
                } else if (boardMatrix[i][j] == 0) {
                    if (consecutive > 0) {
                        blocks--;
                        score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                        consecutive = 0;
                        blocks = 2;
                    } else {
                        blocks = 1;
                    }
                } else if (consecutive > 0) {
                    score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
                    consecutive = 0;
                    blocks = 2;
                } else {
                    blocks = 2;
                }
            }
            if (consecutive > 0) {
                score += getScoreForFive(consecutive, blocks, forBlack == playersTurn);
            }
            consecutive = 0;
            blocks = 2;
        }
        return score;
    }

    private static int getScoreForFive(int count, int blocks, boolean currentTurn) {
        final int winGuarantee = 1000000;
        if (blocks == 2 && count < 5) return 0;
        if (count == 5) {
            return winScore;
        } else if (count == 4) {
            if (currentTurn) return winGuarantee;
            else {
                if (blocks == 0) return winGuarantee / 4;
                else return 200;
            }
        } else if (count == 3) {
            if (blocks == 0) {
                if (currentTurn) return 50000;
                else return 200;
            } else {
                if (currentTurn) return 10;
                else return 5;
            }
        } else if (count == 2) {
            if (blocks == 0) {
                if (currentTurn) return 7;
                else return 5;
            } else {
                return 3;
            }
        } else if (count == 1) {
            return 1;
        }
        return winScore * 2;
    }

}
