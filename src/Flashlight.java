import java.util.Objects;

public class Flashlight extends AbstractItem implements Narratable {
    private boolean on = false;

    public Flashlight(String name, int durability) {
        super(name, durability);
    }

    public void turnOn(Character user) {
        Objects.requireNonNull(user);
        if (isBroken()) return;

        on = true;
        say(user.getName() + " включил " + getName() + ".");
        wear(1);
    }

    public void illuminatePath() {
        if (!on || isBroken()) return;

        say("Полицейские тоже зажгли фонари и, освещая перед собой путь, двинулись с обеих сторон под мост.");
        wear(1);
    }

    @Override
    public void use(Character user, Character target) {
        turnOn(user);
    }
}
