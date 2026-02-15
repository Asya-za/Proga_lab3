import java.util.Objects;

public abstract class AbstractItem implements Item {
    private final String name;
    private int durability;

    protected AbstractItem(String name, int durability) {
        this.name = Objects.requireNonNull(name, "name");
        this.durability = Math.max(0, durability);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    protected void wear(int amount) {
        durability = Math.max(0, durability - Math.max(0, amount));
    }

    @Override
    public boolean isBroken() {
        return durability <= 0;
    }
}
