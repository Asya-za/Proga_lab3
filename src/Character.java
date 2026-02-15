import java.util.*;

public class Character implements Actor, Narratable {
    private final String name;
    private final Role role;
    private State state;
    private Location location;

    private final List<Item> inventory = new ArrayList<>();

    public Character(String name, Role role, State state, Location location) {
        this.name = Objects.requireNonNull(name);
        this.role = Objects.requireNonNull(role);
        this.state = Objects.requireNonNull(state);
        this.location = Objects.requireNonNull(location);
    }

    @Override
    public String getName() { return name; }

    @Override
    public Role getRole() { return role; }

    @Override
    public State getState() { return state; }

    @Override
    public void setState(State state) { this.state = Objects.requireNonNull(state); }

    @Override
    public Location getLocation() { return location; }

    @Override
    public void moveTo(Location to) { this.location = Objects.requireNonNull(to); }

    public void grab(Item item) {
        inventory.add(Objects.requireNonNull(item));
    }

    public <T> T findFirst(Class<T> cls) {
        for (Item it : inventory) {
            if (cls.isInstance(it)) return cls.cast(it);
        }
        return null;
    }

    // ====== СЮЖЕТНЫЕ МЕТОДЫ С ПЕЧАТЬЮ (как в Carlson) ======

    public void wakeUpFirstAndShout() {
        state = State.AWAKE;
        say("Клюква первый проснулся и, увидев себя в руках полицейских, закричал:");
    }

    public void loseConsciousness() {
        state = State.UNCONSCIOUS;
    }

    public void startResistingWithOthers() {
        say("Остальные коротышки стали вырываться из рук полицейских, но электрические разряды мигом успокоили их.");
        state = State.STUNNED;
    }

    public void keepCool() {
        say("Только один Пузырь не растерялся.");
        state = State.AWAKE;
    }

    public ElectricBaton snatchBatonFrom(Character policeman) {
        ElectricBaton baton = policeman.findFirst(ElectricBaton.class);
        if (baton == null) return null;

        say("Вырвав из рук схватившего его полицейского Пнигля электрическую дубинку, он сунул ее под нос противнику.");
        this.grab(baton);
        return baton;
    }

    public void fallLikeMowedDown() {
        state = State.UNCONSCIOUS;
        say("Пнигль упал словно подкошенный, а Пузырь швырнул электрическую дубинку в спешившего к нему полицейского Скригля,");
    }

    public void getStunnedByThrownBaton() {
        state = State.STUNNED;
    }

    public void swimAway() {
        state = State.SWIMMING;
        say("Растерявшиеся полицейские смотрели, как он плыл по воде, быстро удаляясь от берега.");
    }

    public void cantRecoverAfterSpark() {
        state = State.UNCONSCIOUS;
        say("который никак не мог прийти в себя, после того как ему в нос попала зеленая искра.");
    }
}
