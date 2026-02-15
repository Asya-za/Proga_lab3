public interface Item {
    String getName();
    int getDurability();
    boolean isBroken();

    void use(Character user, Character target);
}
