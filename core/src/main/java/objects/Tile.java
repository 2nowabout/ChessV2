package objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import function.TilePositionGenerator;
import save_libraries.Position;

import java.awt.*;

public class Tile {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    private boolean canMoveHere = false;
    private boolean kingChecked = false;
    private boolean possibleAttack = false;
    private boolean white;
    private int renderX;
    private int renderY;
    private Position position;
    private Rectangle rectangle;

    public Tile(boolean white, int renderX, int renderY, int x, int y) {
        this.renderX = renderX;
        this.renderY = renderY;
        this.rectangle = new Rectangle(renderX, renderY, WIDTH, HEIGHT);
        this.position = new Position(x,y);
        this.white = white;
    }

    public void render(SpriteBatch batch, BitmapFont font) {
        if(white)
        {
            batch.draw(TextureHolder.WhiteTileTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        else
        {
            batch.draw(TextureHolder.BlackTileTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        font.draw(batch, TilePositionGenerator.getPositionString(position.getX(), position.getY()), (renderX + 75), (renderY + 95));
        if(kingChecked || possibleAttack)
        {
            batch.draw(TextureHolder.KingCheckTexture, renderX, renderY, WIDTH, HEIGHT);
        }
        if (canMoveHere) {
            batch.draw(TextureHolder.PossibleMoveTexture, renderX, renderY, WIDTH, HEIGHT);
        }


    }

    public boolean isThisCorrectTile(int x, int y)
    {
        return this.position.getX() == x && this.position.getY() == y;
    }

    public void update(float dt) {
        throw new UnsupportedOperationException();
    }

    public void resetTileEffects()
    {
        this.kingChecked = false;
        this.canMoveHere = false;
        this.possibleAttack = false;
    }

    public void setKingChecked() {
        this.kingChecked = true;
    }

    public void setCanMoveHere(boolean attack) {
        if(attack)
        {
            possibleAttack = true;
        }
        else {
            this.canMoveHere = true;
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public Position getRenderPosition() {
        return new Position(renderX, renderY);
    }

    public boolean isClicked(Rectangle mouse) {
        return rectangle.intersects(mouse);
    }

    public boolean isPossibleAttack() {
        return possibleAttack;
    }


}
