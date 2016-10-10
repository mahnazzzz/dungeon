/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungenModel;

import Dungeon.Controler.ControllerInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class mapRooms implements java.io.Serializable {

    private Random rnd;

    private Room currentRoom;
    private Room previous;
    ControllerInterface ctrl;
    private Room r4;
    
    public mapRooms(ControllerInterface c) {                          
        this.ctrl = c;
        rnd = new Random();
    }
    public void create() {
        List itemList = setDefaultRoomItems();
        List monsterList = setDefaultMonster(itemList);  
        
        Room r1 = new Room("Start Room", "it is starting. historie is ", null);
        Room r2 = new Room("Room 2", "it is warm", null);
        Room r3 = new Room("Room 3", "it is cold", pickMonster(monsterList));
         r4 = new Room("Room 4", "it is dark ", null);
        Room r5 = new Room("Room 5 ", "it is dark and smelly", null);
        Room r6 = new Room("Room 6 ", "it is warm and nasty", null);
        Room r7 = new Room("Room 7 ", "ist smell like rot", null);
        Room r8 = new Room("Room 8", "the floor i coverd in blood", pickMonster(monsterList));
        Room r9 = new Room("Room 9 ", "the walls is coverd in sod", null);
        Room r10 = new Room("Room 10 ", "its cold and smelly", pickMonster(monsterList));
        Room r11 = new Room("Room 11 ", "this room feels weird ", null);
        Room r12 = new Room("Room 12", "this is a evil room", pickMonster(monsterList));
        Room r13 = new Room("Room 13", "I think somone died in here", null);
        Room r14 = new Room("Room 14 ", "this room feels unplesant", null);
        Room r15 = new Room("Room 15", "it smells like dead animals ", null);
        Room r16 = new Room("Room 16 ", "there is stanges writing on the wall", null);
        Room r17 = new Room("Room 17", "the floor is all sticky", null);
        Room r18 = new Room("Room 18", "strangs sounds in this room", null);
        Room r19 = new Room("Room 19 ", "this room feels evil", pickMonster(monsterList));
        Room r20 = new Room("Room 20 ", "Like heel on earth", pickMonster(monsterList));

        r1.north = r4;

        r2.west = r3;

        r3.west = r4;
        r3.east = r2;
        r3.north = r9;

        r4.west = r5;
        r4.east = r3;
        r4.south = r1;

        r5.east = r4;
        r5.west = r6;
        r5.north = r11;

        r6.east = r5;
        r6.north = r12;
        r6.south = r7;

        r7.north = r6;

        r8.west = r9;

        r9.east = r8;
        r9.south = r3;
        r9.west = r10;

        r10.east = r9;
        r10.west = r11;

        r11.east = r10;
        r11.west = r12;
        r11.south = r5;

        r12.east = r11;
        r12.south = r6;
        r12.north = r17;

        r13.west = r14;

        r14.east = r13;
        r14.west = r15;

        r15.east = r14;
        r15.west = r16;
        r15.north = r19;

        r16.east = r15;
        r16.west = r17;
        r16.north = r20;

        r17.east = r16;
        r17.south = r12;
        r17.west = r18;

        r18.east = r17;

        r19.south = r15;

        r20.south = r16;

        currentRoom = r1;

    }

    public String goNorth() {
        String output = "";
        if (currentRoom.north == null) {
            return "There is no door that leads north";
        }
        if (isMonsterBlocking() && currentRoom.north != previous) {
            return "There is monster blocking the door";
        }
        previous = currentRoom;
        currentRoom = currentRoom.north;
        if (currentRoom.getMonster() != null) {
            output += attacPlayer() + "\n";
        }

        return output + "Room name: " + currentRoom.getName() + "\nDiscribtion: " + currentRoom.getDiscription();
    }

    public String goSouth() {
        String output = "";
        if (currentRoom.south == null) {
            return "There is no door that leads south";
        }
        if (isMonsterBlocking() && currentRoom.south != previous) {
            return "There is monster blocking the door";
        }
        previous = currentRoom;
        currentRoom = currentRoom.south;
        if (currentRoom.getMonster() != null) {
            output += attacPlayer() + "\n";
        }

        return output + "Room name: " + currentRoom.getName() + "\nDiscribtion: " + currentRoom.getDiscription();

    }

    public String goWest() {
        String output = "";
        if (currentRoom.west == null) {
            return "There is no door that leads west";
        }
        if (isMonsterBlocking() && currentRoom.west != previous) {
            return "There is monster blocking the door";
        }
        previous = currentRoom;
        currentRoom = currentRoom.west;
        if (currentRoom.getMonster() != null) {
            output += attacPlayer() + "\n";
        }

        return output + "Room name: " + currentRoom.getName() + "\nDiscribtion: " + currentRoom.getDiscription();
    }

    public String goEast() {
        String output = "";
        if (currentRoom.east == null) {
            return "There is no door that leads esat";
        }
        if (isMonsterBlocking() && currentRoom.east != previous) {
            return "There is monster blocking the door";
        }
        previous = currentRoom;
        currentRoom = currentRoom.east;
        if (currentRoom.getMonster() != null) {
            output += attacPlayer() + "\n";
        }

        return output + "Room name: " + currentRoom.getName() + "\nDiscribtion: " + currentRoom.getDiscription();
    }

    public void isMonsterBoolean() {                                
        if (currentRoom.getMonster().getHitPoints() < 1) {
            currentRoom.getMonster().setAlive(false);
        }
    }

    public String attacPlayer() {                        
        if (currentRoom.getMonster().getHitPoints() > 0) {
            int hit = 3;
            ctrl.damagePlayer(hit);
            return "a monster attacks you and you lost " + hit + " hitpoints";
        }
       return "Dont be afraid. Monster cannot inflict you any damage "; 
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public List<Monster> setDefaultMonster(List<Items> itemList) {
        List moList = new ArrayList();
        moList.add(new Monster("monster1", "big", 10, 10, choosItems(itemList), choosItems(itemList)));
        moList.add(new Monster("monster2", "smal", 10, 10, choosItems(itemList), choosItems(itemList)));
        moList.add(new Monster("monster3", "fat", 10, 10, choosItems(itemList), choosItems(itemList)));
        moList.add(new Monster("monster4", "tinny", 10, 10, choosItems(itemList), choosItems(itemList)));
        moList.add(new Monster("monster5", "black", 10, 10, choosItems(itemList), choosItems(itemList)));
        moList.add(new Monster("monster6", "white", 10, 10, choosItems(itemList), choosItems(itemList), choosItems(itemList)));
        return moList;

    }

    public List<Items> setDefaultRoomItems() {
        List itemsList = new ArrayList();
        itemsList.add(new Items("End Treasure Chest", "you will win"));
        itemsList.add(new Items("Bastard sword", "14 damages"));
        itemsList.add(new Items("Long sword", "10 damages"));
        itemsList.add(new Items("Healing Potion", "player´s hitpoints to maximum"));
        itemsList.add(new Items("Healing Potion", "player´s hitpoints to maximum"));
        itemsList.add(new Items("Healing Potion", "player´s hitpoints to maximum"));
        itemsList.add(new Items("Healing Potion", "player´s hitpoints to maximum"));
        itemsList.add(new Items("Weapon poison Potion", "increase weapon damage by 5"));
        itemsList.add(new Items("Rubies", "200 gold coins each"));
        itemsList.add(new Items("Rubies", "200 gold coins each"));
        itemsList.add(new Items("Rubies", "200 gold coins each"));
        itemsList.add(new Items("peals", "50 gold coins each"));
        itemsList.add(new Items("1silver necklace", "800 old coins"));
        return itemsList;
    }

    public Monster pickMonster(List<Monster> monsterList) {
        return monsterList.remove(rnd.nextInt(monsterList.size()));
    }

    public Items choosItems(List<Items> items) {
        
        return items.remove(rnd.nextInt(items.size()));
    }

    public boolean isMonsterBlocking() {
        return (currentRoom.getMonster() != null && currentRoom.getMonster().getAlive());
    }

    public Room getR4() {
        return r4;
    }

}
