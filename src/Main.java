// Main.java
public class Main {
    public static void main(String[] args) {

        // ЛОКАЦИИ (record)
        Location underBridge = new Location("Под мостом", LocationType.UNDER_BRIDGE);
        Location leftRoad = new Location("Слева от дороги", LocationType.ROAD_LEFT);
        Location rightRoad = new Location("Справа от дороги", LocationType.ROAD_RIGHT);

        // ПЕРСОНАЖИ
        Character ruvigl = new Character("Рвигль", Role.POLICEMAN, State.AWAKE, leftRoad);
        Character pnigl  = new Character("Пнигль",  Role.POLICEMAN, State.AWAKE, leftRoad);
        Character skrigl = new Character("Скригль", Role.POLICEMAN, State.AWAKE, rightRoad);

        Character klyukva = new Character("Клюква", Role.DWARF, State.SLEEPING, underBridge);
        Character puzyr   = new Character("Пузырь", Role.DWARF, State.SLEEPING, underBridge);

        // ПРЕДМЕТЫ (Item — интерфейс)
        Flashlight secretFlashlight = new Flashlight("потайной электрический фонарь", 50);
        Flashlight flashlight1 = new Flashlight("фонарь", 50);
        Flashlight flashlight2 = new Flashlight("фонарь", 50);

        ElectricBaton batonR = new ElectricBaton("электрическая дубинка", 50, 10);
        ElectricBaton batonP = new ElectricBaton("электрическая дубинка", 50, 10);

        InflatablePillow pillow = new InflatablePillow("надувная подушка", 40);

        // ИНВЕНТАРЬ
        ruvigl.grab(secretFlashlight);
        ruvigl.grab(batonR);

        pnigl.grab(flashlight1);
        pnigl.grab(batonP);

        skrigl.grab(flashlight2);

        puzyr.grab(pillow);

        // ОТРЯД
        PoliceSquad police = new PoliceSquad();
        police.setLeader(ruvigl);
        police.addMember(pnigl);
        police.addMember(skrigl);

        // ====== СЦЕНА (вывод внутри методов) ======
        police.splitSilently();
        police.goDownFromLeftAndRight();

        police.moveAllTo(underBridge);
        underBridge.describeArrivalDown();

        secretFlashlight.turnOn(ruvigl);

        flashlight1.turnOn(pnigl);
        flashlight2.turnOn(skrigl);
        secretFlashlight.illuminatePath();

        police.rushOnSleepingDwarfs();

        klyukva.wakeUpFirstAndShout();
        batonR.hitForeheadAndKnockOut(klyukva);

        puzyr.startResistingWithOthers();

        puzyr.keepCool();
        ElectricBaton stolen = puzyr.snatchBatonFrom(pnigl);
        if (stolen != null) {
            stolen.greenSparkUnderNose(pnigl);
            pnigl.fallLikeMowedDown();

            skrigl.getStunnedByThrownBaton();

            pillow.grabAndJump(puzyr);
            puzyr.swimAway();
        }

        police.dragEveryoneUpSlope();
        pnigl.cantRecoverAfterSpark();
    }
}
