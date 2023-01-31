package managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.AssignStartLocation;

import java.awt.*;

public class GameManager {

    private ChessPieceManager chessPieceManager;
    private MainBordManager mainBordManager;
    public GameManager(boolean white)
    {
        this.chessPieceManager = new ChessPieceManager();
        this.mainBordManager = new MainBordManager(white);
        AssignStartLocation assignStartLocation = new AssignStartLocation();
        assignStartLocation.assignStartRenderLocation(chessPieceManager.getAllPieces(), mainBordManager.getBord());
    }

    public void draw(SpriteBatch batch)
    {
        mainBordManager.draw(batch);
        chessPieceManager.draw(batch);
    }

    public void clicked(Rectangle mouseRectangle)
    {

    }
}
