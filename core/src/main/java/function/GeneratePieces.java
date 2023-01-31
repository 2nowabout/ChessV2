package function;

import objects.chesspieces.*;

import java.util.ArrayList;

public class GeneratePieces {

    public ArrayList<ChessPieces> generateBlackPieces() {
        ArrayList<ChessPieces> chessPieces = new ArrayList<>();
        for (int y = 7; y <= 8; y++) {
            for (int x = 1; x <= 8; x++) {
                if (y == 7) {
                    chessPieces.add(new Pawn(false, x, y));
                } else {
                    switch (x) {
                        case 1:
                        case 8:
                            chessPieces.add(new Rook(false, x, y));
                            break;
                        case 2:
                        case 7:
                            chessPieces.add(new Knight(false, x, y));
                            break;
                        case 3:
                        case 6:
                            chessPieces.add(new Bishop(false, x, y));
                            break;
                        case 4:
                            chessPieces.add(new Queen(false, x, y));
                            break;
                        case 5:
                            chessPieces.add(new King(false, x, y));
                            break;
                        default:
                            throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
        }
        return chessPieces;
    }

    public ArrayList<ChessPieces> generateWhitePieces() {
        ArrayList<ChessPieces> chessPieces = new ArrayList<>();
        for (int y = 1; y <= 2; y++) {
            for (int x = 1; x <= 8; x++) {
                if (y == 2) {
                    chessPieces.add(new Pawn(true, x, y));
                } else {
                    switch (x) {
                        case 1:
                        case 8:
                            chessPieces.add(new Rook(true, x, y));
                            break;
                        case 2:
                        case 7:
                            chessPieces.add(new Knight(true, x, y));
                            break;
                        case 3:
                        case 6:
                            chessPieces.add(new Bishop(true, x, y));
                            break;
                        case 4:
                            chessPieces.add(new Queen(true, x, y));
                            break;
                        case 5:
                            chessPieces.add(new King(true, x, y));
                            break;
                        default:
                            throw new ArrayIndexOutOfBoundsException();
                    }
                }
            }
        }
        return chessPieces;
    }
}
