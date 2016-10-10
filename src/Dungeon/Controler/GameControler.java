package Dungeon.Controler;

import dungenModel.Items;
import dungenModel.ItemsPlayerCollection;
import dungenModel.Player;
import dungenModel.mapRooms;
import java.util.ArrayList;

/**
 *
 * @author mahnaz :phehe
 */
public class GameControler implements java.io.Serializable, ControllerInterface {

    private Player player;
    public mapRooms rMap;
    private String fileName;
    private ItemsPlayerCollection ipc;
    private ArrayList<Items> monsterItems;
    private String inforRoom = "", inforplayer = "", infoMonsterItems = "";

    public GameControler(String playerName) {
        player = new Player(playerName);
        monsterItems = new ArrayList();
        rMap = new mapRooms(this);
        rMap.create();
        ipc = new ItemsPlayerCollection();
        fileName = "GC.ser";
    }

    public String goNorth() {
        return rMap.goNorth();
    }

    public String goSouth() {
        return rMap.goSouth();
    }

    public String goWest() {
        return rMap.goWest();
    }

    public String goEast() {
        return rMap.goEast();
    }

    public String playerToString() {
        return player.toString();
    }

    public String currentRoomMonsterToString() {
        return rMap.getCurrentRoom().toString();
    }

    public ArrayList<Items> playerItemsCollection() {

        return ipc.getPlayerItems();
    }

    public String command(String com) {
        String result = "";
        switch (com) {

            case "attack":
                result = playerAttack(5);
                break;
            case "pickup":
                result = pickup();
                break;
            case "help":
                result = helpComando();
                break;
            case "quit":
                result = gameOver();
                break;
            default:
                result = "What are you looking for";
                break;
        }
        return result;
    }

    public boolean isPlayerAlive() {
        return (player.getHitPoints() > 0);
    }

    public boolean haveNotEndTreasureChest() {
        for (Items item : ipc.getPlayerItems()) {
            if (item.getNavn().equals("End Treasure Chest")) {
                return false;
            }
        }
        return true;

    }

    private String playerAttack(int hit) {
        String output = "";
        if (rMap.getCurrentRoom().getMonster() != null && rMap.getCurrentRoom().getMonster().getAlive()) {
            rMap.getCurrentRoom().getMonster().hitFromPlayer(hit);
            player.woundMonsterDecreaseDamagePlayer(hit);
            output += "you hit monster for " + hit + "\n";
            if (rMap.getCurrentRoom().getMonster().getHitPoints() > 0) {

                player.hitFromMonster(5);
                rMap.getCurrentRoom().getMonster().woundPlayerDecreaseDamageMonster(5);
                output += "\nThe monster hits you back for " + 5 + " \nYou have " + player.getHitPoints() + " left";
            } else {
                rMap.isMonsterBoolean();
                player.setLevel(player.getLevel() + 1);
                output += "\nand the monster died";
            }
        } else {
            return "You can´t attac now";
        }
        return output;

    }

    public String pickup() {

        String beskrivelse = "You can`t pickup now";

        if (rMap.getCurrentRoom().getMonster() != null && !rMap.getCurrentRoom().getMonster().getAlive() && rMap.getCurrentRoom().getMonster().hasItems()) {
            
            for (Items items : rMap.getCurrentRoom().getMonster().getAllItems()) {
                ipc.addItem(items);
                monsterItems.add(items);
            }
            beskrivelse = ipc.getPlayerItems().toString();

        } else if (rMap.getCurrentRoom().getMonster() != null && rMap.getCurrentRoom().getMonster().getAlive()) {
            beskrivelse = "You have to kill the monster first";
        } else if (rMap.getCurrentRoom().getMonster() != null && !rMap.getCurrentRoom().getMonster().getAlive() && !rMap.getCurrentRoom().getMonster().hasItems()) {
            beskrivelse = " you have picket up and there is no items more";
        }
        return beskrivelse;
    }

    public String helpComando() {
        String temp = "";
        String[] helpList = {"Here is this commando you can use", "help", "attack", "pickup", "load", "save", "newPlay", "quit", "use", "north", "south", "west", "east"};
        for (String string : helpList) {
            temp += string + "\n";
        }
        return temp;
    }

    public String use(String item) {
        int amount;
        if (rMap.getCurrentRoom().getMonster() != null && rMap.getCurrentRoom().getMonster().getAlive()) {
            if (item.equals("short Sword")) {
                amount = 6;
                rMap.getCurrentRoom().getMonster().hitFromPlayer(amount);
                for (int i = 0; i < ipc.getPlayerItems().size(); i++) {
                    if (ipc.getPlayerItems().get(i).getNavn().equals("short Sword")) {
                        ipc.getPlayerItems().remove(i);
                        i = ipc.getPlayerItems().size();
                    }
                }
                rMap.isMonsterBoolean();
                return "you hit monster for: " + amount;

            }
            if (item.equals("Bastard sword")) {
                amount = 14;
                rMap.getCurrentRoom().getMonster().hitFromPlayer(amount);
                 for (int i = 0; i < ipc.getPlayerItems().size(); i++) {
                    if (ipc.getPlayerItems().get(i).getNavn().equals("Bastard sword")) {
                        ipc.getPlayerItems().remove(i);
                        i = ipc.getPlayerItems().size();
                    }
                }
                rMap.isMonsterBoolean();
                return "you hit monster for: " + amount;

            }
            if (item.equals("Long sword")) {
                amount = 10;
                rMap.getCurrentRoom().getMonster().hitFromPlayer(amount);
                for (int i = 0; i < ipc.getPlayerItems().size(); i++) {
                    if (ipc.getPlayerItems().get(i).getNavn().equals("Long sword")) {
                        ipc.getPlayerItems().remove(i);
                        i = ipc.getPlayerItems().size();
                    }
                }
                rMap.isMonsterBoolean();
                return "you hit monster for: " + amount;

            }
            if (item.equals("Weapon poison Potion")) {
                amount = 5;
                player.increaseDamage(amount);
                for (int i = 0; i < ipc.getPlayerItems().size(); i++) {
                    if (ipc.getPlayerItems().get(i).getNavn().equals("Weapon poison Potion")) {
                        ipc.getPlayerItems().remove(i);
                        i = ipc.getPlayerItems().size();
                    }
                }
                return "your damage increase with :" + amount + "  and you have: " + (player.getDamage() + amount);

            }
            if (item.equals("healing potion")) {
                amount = 30;
                player.setHitPoints(30);
                for (int i = 0; i < ipc.getPlayerItems().size(); i++) {
                    if (ipc.getPlayerItems().get(i).getNavn().equals("healing potion")) {
                        ipc.getPlayerItems().remove(i);
                        i = ipc.getPlayerItems().size();
                    }
                }
                return "your hit points increased and you have:  " + amount;

            } else {
                return " you can`t use it for nothing ";
            }
        } else {
            return "you can use this i this time";
        }
    }

    public String gameOver() {
        return " game over "
                + "\n your hit point is: " + player.getHitPoints()
                + "\n your Damage is: " + player.getDamage()
                + "\n your hit point is: " + player.getLevel()
                + "\n Monster hit point is: " + rMap.getCurrentRoom().getMonster().getHitPoints()
                + "\n Monster damage is: " + rMap.getCurrentRoom().getMonster().getDamager()
                + "\nyour items is:" + ipc.toString();

    }

    public mapRooms getrMap() {
        return rMap;
    }

    public void setrMap(mapRooms rMap) {
        this.rMap = rMap;
    }

    public String getInforRoom() {
        return inforRoom;
    }

    public void setInforRoom(String inforRoom) {
        this.inforRoom = inforRoom;
    }

    public String getInforplayer() {
        return inforplayer;
    }

    public void setInforplayer(String inforplayer) {
        this.inforplayer = inforplayer;
    }

    public String getInfoMonsterItems() {
        return infoMonsterItems;
    }

    public void setInfoMonsterItems(String infoMonsterItems) {
        this.infoMonsterItems = infoMonsterItems;
    }

    @Override
    public void damagePlayer(int hitPoints) {
        player.hitFromMonster(hitPoints);
    }

    public ArrayList<Items> getMonsterItems() {
        return monsterItems;
    }


}
