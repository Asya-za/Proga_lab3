public interface Actor {
    String getName();
    Role getRole();
    State getState();
    void setState(State state);

    Location getLocation();
    void moveTo(Location to);
}
