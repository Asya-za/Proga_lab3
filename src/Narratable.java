public interface Narratable {
    default void say(String text) {
        System.out.println(text);
    }
}
