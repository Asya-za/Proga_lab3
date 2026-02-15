// PoliceSquad.java
import java.util.*;

public class PoliceSquad implements Narratable {
    private final List<Character> members = new ArrayList<>();
    private Character leader;

    public void setLeader(Character leader) {
        this.leader = Objects.requireNonNull(leader);
        if (!members.contains(leader)) members.add(leader);
    }

    public void addMember(Character c) {
        members.add(Objects.requireNonNull(c));
    }

    public void moveAllTo(Location to) {
        for (Character c : members) c.moveTo(to);
    }

    // ====== ТЕКСТ (как в оригинале) ======

    public void splitSilently() {
        say("Полицейские безмолвно разделились на два отряда.");
    }

    public void goDownFromLeftAndRight() {
        say("Первый отряд стал спускаться под мост с левой стороны дороги, а второй -- с правой.");
    }

    public void rushOnSleepingDwarfs() {
        say("Полицейские с обеих сторон бросились на спящих коротышек и принялись хватать их.");
    }

    public void dragEveryoneUpSlope() {
        say("Полицейские потащили вверх по откосу слабо сопротивлявшихся коротышек, а также полицейского Пнигля,");
    }
}
