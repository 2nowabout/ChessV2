package function;

public class TilePositionGenerator {
    private TilePositionGenerator() {
    }

    private static Character[] horizontal = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public static String getPositionString(int x, int y)
    {
        return horizontal[x].toString() + (y + 1);
    }
}
