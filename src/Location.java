public record Location(String name, LocationType type) implements Narratable {

    public Location {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name");
        if (type == null) throw new IllegalArgumentException("type");
    }

    public void describeArrivalDown() {
        // дословно как в тексте
        say("Очутившись внизу, Рвигль включил потайной электрический фонарь и прошипел:");
    }

    @Override
    public String toString() {
        return name;
    }
}
