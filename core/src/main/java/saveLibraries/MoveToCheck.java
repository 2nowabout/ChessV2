package saveLibraries;

public class MoveToCheck {
    private boolean attack;
    private Position position;

    public MoveToCheck(boolean attack, Position position)
    {
        this.attack = attack;
        this.position = position;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
