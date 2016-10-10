package dungenModel;

public class Player implements java.io.Serializable {

    private String name;
    private int hitPoints = 30;
    private int Damage = 100;
    private int level = 1;

    public Player(String name) {
        this.name = name;
    }

    public void increaseHitPointsPlayer() {
        setHitPoints(30);
    }

    public void woundMonsterDecreaseDamagePlayer(int damage) {
        int amountDamage = getDamage();
        amountDamage -= damage;
        setDamage(amountDamage);

    }

    public void hitFromMonster(int damage) {
        int amountHitpoints = getHitPoints();
        amountHitpoints -= damage;
        setHitPoints(amountHitpoints);

    }

    public void increaseDamage(int weapon) {
        int amountDamage = getDamage();
        amountDamage += weapon;
        setDamage(amountDamage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int Damage) {
        this.Damage = Damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Player name:" + name + "\n hitPoints: " + hitPoints + "\n Damage:" + Damage + "\n level:" + level;
    }

}
