package dungenModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pelo
 */
public class Room implements java.io.Serializable{

    private String name;
    private String discription;
    private Monster monster;
    
    
    private Random r = new Random();
    
    public Room north;
    public Room south;
    public Room east;
    public Room west;
  

    public Room(String name, String discription, Monster monster) {
        this.name = name;
        this.discription = discription;
        this.monster = monster;

        north = null;
        south = null;
        east = null;
        west = null;
    }
            
            
    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public Monster getMonster() {
        return monster;
    }

    @Override
    public String toString() {              
        if(monster!= null ){
        return  "monsterName:" + monster.getName() +
                "\nMonster discription:" +monster.getDiscribtion() +
                "\nMonster Damager :" +monster.getDamager()+
                "\nMonster HitPoints :" +monster.getHitPoints();}
                
                
            return "there is not any monster";
    }

}
