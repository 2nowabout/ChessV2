package function;

import objects.chessPieces.*;

import java.util.ArrayList;

public class GeneratePieces {

    public ArrayList<ChessPieces> generateBlackPieces() {
        ArrayList<ChessPieces> chessPieces = new ArrayList<>();
        for (int y = 6; y <= 7; y++) {
            for (int x = 0; x <= 7; x++) {
                if (y == 6) {
                    chessPieces.add(new Pawn(false, x, y));
                } else {
                    switch (x) {
                        case 0:
                        case 7:
                            chessPieces.add(new Rook(false, x, y));
                            break;
                        case 1:
                        case 6:
                            chessPieces.add(new Knight(false, x, y));
                            break;
                        case 2:
                        case 5:
                            chessPieces.add(new Bishop(false, x, y));
                            break;
                        case 3:
                            chessPieces.add(new Queen(false, x, y));
                            break;
                        case 4:
                            chessPieces.add(new King(false, x, y));
                            break;
                    }
                }
            }
        }
        return chessPieces;
    }

    public ArrayList<ChessPieces> generateWhitePieces() {
        ArrayList<ChessPieces> chessPieces = new ArrayList<>();
        for (int y = 0; y <= 1; y++) {
            for (int x = 0; x <= 7; x++) {
                if (y == 1) {
                    chessPieces.add(new Pawn(true, x, y));
                } else {
                    switch (x) {
                        case 0:
                        case 7:
                            chessPieces.add(new Rook(true, x, y));
                            break;
                        case 1:
                        case 6:
                            chessPieces.add(new Knight(true, x, y));
                            break;
                        case 2:
                        case 5:
                            chessPieces.add(new Bishop(true, x, y));
                            break;
                        case 3:
                            chessPieces.add(new Queen(true, x, y));
                            break;
                        case 4:
                            chessPieces.add(new King(true, x, y));
                            break;
                    }
                }
            }
        }
        return chessPieces;
    }
}
