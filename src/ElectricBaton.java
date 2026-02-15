import java.util.Objects;

public class ElectricBaton extends AbstractItem implements Narratable {
    private int charge;

    public ElectricBaton(String name, int durability, int charge) {
        super(name, durability);
        this.charge = Math.max(0, charge);
    }

    private boolean canShock() {
        return !isBroken() && charge > 0;
    }

    public void hitForeheadAndKnockOut(Character target) {
        Objects.requireNonNull(target);
        if (!canShock()) return;

        charge--;
        wear(1);

        say("Тут он получил такой удар электрической дубинкой по лбу, что потерял сознание.");
        target.loseConsciousness();
    }

    public void calmByDischarge(Character target) {
        Objects.requireNonNull(target);
        if (!canShock()) return;

        charge--;
        wear(1);
        target.setState(State.STUNNED);
    }

    public void greenSparkUnderNose(Character target) {
        Objects.requireNonNull(target);
        if (!canShock()) return;

        charge--;
        wear(1);

        say("Раздался треск. Между носом полицейского и дубинкой проскочила зеленая искра.");
        target.loseConsciousness();
    }

    @Override
    public void use(Character user, Character target) {
        // В этой сцене используем точные методы выше, чтобы текст совпадал с оригиналом.
    }
}
