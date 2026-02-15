import java.util.Objects;

public class InflatablePillow extends AbstractItem implements Narratable {

    public InflatablePillow(String name, int durability) {
        super(name, durability);
    }

    public void grabAndJump(Character puzyr) {
        Objects.requireNonNull(puzyr);
        if (isBroken()) return;

        say("сам же схватил свою надувную подушку, одним прыжком подскочил к берегу и прыгнул в воду.");
        wear(1);
    }

    @Override
    public void use(Character user, Character target) {
        // не требуется
    }
}
