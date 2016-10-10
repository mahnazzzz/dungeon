
package dungenModel;


import java.util.ArrayList;
import java.util.List;


public class Monster implements java.io.Serializable{
    private String name;
    private String Discribtion;
    private int damager;
    private int hitPoints ;
    private Items item1 ;
    private Items item2 ;
    private Items item3;
    private boolean alive;
    private List<Items> monsterItems = new ArrayList();

    public Monster(String name, String Discribtion, int damager, int hitPoints, Items item1, Items item2) {
        this.name = name;
        this.Discribtion = Discribtion;
        this.damager = damager;
        this.hitPoints = hitPoints;
        monsterItems.add(item1);
        monsterItems.add(item2);
        
        alive = true;
    }

    public Monster(String name, String Discribtion, int damager, int hitPoints, Items item1, Items item2, Items item3) { 
        this.name = name;
        this.Discribtion = Discribtion;
        this.damager = damager;
        this.hitPoints = hitPoints;
        monsterItems.add(item1);
        monsterItems.add(item2);
        monsterItems.add(item3);
        
        alive = true;
    }
    
    @Override                                             
    public String toString() {
        return "Monster{name=" + name + "\nDiscribtion=" + Discribtion + "\ndamager=" + damager + "\n hitPoints=" + hitPoints + 
                "\n item1="+ monsterItems.toString();         
    }
    
    public void woundPlayerDecreaseDamageMonster(int damage) {        
        int amountDamage = getDamager();
        amountDamage -= damage;
        setDamager(amountDamage);

    }

    public void hitFromPlayer(int damage) {               
        int amountHitPoints = getHitPoints();
        amountHitPoints -= damage;
        setHitPoints(amountHitPoints);
    }
    public boolean hasItems(){
        return (!monsterItems.isEmpty());
    }
    public List<Items> getAllItems(){
        List<Items> temp = new ArrayList();
       
        for (Items item : monsterItems) {
            temp.add(item);
        }
        monsterItems.clear();    
        return temp;
    }
    
    public Items getItem(){
        if (monsterItems.size()>0){
            return monsterItems.remove(0);
        }
        else {
            return null;
        }
    }
    public void setAlive(boolean b){
        alive = b;
    }
    
    public boolean getAlive(){
        return alive;
    }

    public String getName() {
        return name;
    }
    public String getDiscribtion() {
        return Discribtion;
    }
    public int getDamager() {
        return damager;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setDamager(int damager) {
        this.damager = damager;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public Items getItem1() {
        return item1;
    }
    public Items getItem2() {
        return item2;
    }
    public Items getItem3() {
        return item3;
    }
 
}
