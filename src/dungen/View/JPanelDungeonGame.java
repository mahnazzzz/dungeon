package dungen.View;

import Dungeon.Controler.GameControler;
import dungenModel.Items;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Bruger
 */
public class JPanelDungeonGame extends javax.swing.JPanel {

    private GameControler gc;
    private String[] commandoList = {"help", "attack", "pickup", "load", "save", "newPlay", "quit", "use"};

    public JPanelDungeonGame(String name) {

        initComponents();
        gc = new GameControler(name);

        for (String string : commandoList) {
            jComboBoxACtionList.addItem(string);
        }
        for (Items items : gc.playerItemsCollection()) {

            jComboBoxPlayerItems.addItem(items.getNavn());
        }
        jTextDirectionRoom.setText("The door opens and a staircase appears in the dark and a faule rotten smell amorous from whit in.\n As you walk down then staircase you feel a unpleasant presence,\n like someone is looking at you,\n and yet you are alone.\n As your reaches the end of the staircase you find yourself in a little room,\n slightly lithe from a few torches.\nThe room reeks of rotten flesh, and the floor is covered in dry blood.\n the room contains 2 doors one I the eastern corner and one in the wastes corner.\n What will you do");
        jTextPlayer.setText(gc.playerToString());
        jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextDirectionRoom = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPlayer = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAMonsterAndtems = new javax.swing.JTextArea();
        jComboBoxACtionList = new javax.swing.JComboBox<>();
        jButtonEast = new javax.swing.JButton();
        jButtonNorth = new javax.swing.JButton();
        jButtonSouth = new javax.swing.JButton();
        jButtonWest = new javax.swing.JButton();
        jComboBoxPlayerItems = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaHelpCommando = new javax.swing.JTextArea();
        jButtonAddItemstoComboboks = new javax.swing.JButton();

        jTextDirectionRoom.setEditable(false);
        jTextDirectionRoom.setColumns(20);
        jTextDirectionRoom.setRows(5);
        jScrollPane1.setViewportView(jTextDirectionRoom);

        jTextPlayer.setEditable(false);
        jTextPlayer.setColumns(20);
        jTextPlayer.setRows(5);
        jScrollPane2.setViewportView(jTextPlayer);

        jTextAMonsterAndtems.setEditable(false);
        jTextAMonsterAndtems.setColumns(20);
        jTextAMonsterAndtems.setForeground(new java.awt.Color(255, 0, 0));
        jTextAMonsterAndtems.setRows(5);
        jScrollPane3.setViewportView(jTextAMonsterAndtems);

        jComboBoxACtionList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ActionList" }));
        jComboBoxACtionList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxACtionListActionPerformed(evt);
            }
        });

        jButtonEast.setText("East");
        jButtonEast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEastActionPerformed(evt);
            }
        });

        jButtonNorth.setText("North");
        jButtonNorth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNorthActionPerformed(evt);
            }
        });

        jButtonSouth.setText("South");
        jButtonSouth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSouthActionPerformed(evt);
            }
        });

        jButtonWest.setText("West");
        jButtonWest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWestActionPerformed(evt);
            }
        });

        jComboBoxPlayerItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Use Items Player" }));
        jComboBoxPlayerItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPlayerItemsActionPerformed(evt);
            }
        });

        jTextAreaHelpCommando.setColumns(20);
        jTextAreaHelpCommando.setRows(5);
        jScrollPane4.setViewportView(jTextAreaHelpCommando);

        jButtonAddItemstoComboboks.setText("Add Item toList");
        jButtonAddItemstoComboboks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemstoComboboksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBoxPlayerItems, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddItemstoComboboks))
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSouth)
                            .addComponent(jButtonNorth))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxACtionList, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonWest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonEast))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNorth)
                            .addComponent(jComboBoxPlayerItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEast)
                            .addComponent(jButtonWest))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSouth)
                            .addComponent(jButtonAddItemstoComboboks))
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jComboBoxACtionList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNorthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNorthActionPerformed
        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            jTextDirectionRoom.setText(gc.goNorth());
            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
        } else {
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }

    }//GEN-LAST:event_jButtonNorthActionPerformed

    private void jButtonSouthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSouthActionPerformed
        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            jTextDirectionRoom.setText(gc.goSouth());
            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
        } else {
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }
    }//GEN-LAST:event_jButtonSouthActionPerformed

    private void jButtonEastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEastActionPerformed
        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            jTextDirectionRoom.setText(gc.goEast());
            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
        } else {
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }
    }//GEN-LAST:event_jButtonEastActionPerformed

    private void jButtonWestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWestActionPerformed
        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            jTextDirectionRoom.setText(gc.goWest());
            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
        } else {
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }
    }//GEN-LAST:event_jButtonWestActionPerformed

    private void jComboBoxACtionListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxACtionListActionPerformed

        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            String choose = jComboBoxACtionList.getSelectedItem().toString();
            if (choose.equals("help")) {
                jTextAreaHelpCommando.setText(gc.command(choose));
            } else {
                jTextDirectionRoom.setText(gc.command(choose));
            }
            if (choose.equals("save")) {
                try {
                    FileOutputStream fileOut = new FileOutputStream("gc.ser");
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    gc.setInforplayer(jTextPlayer.getText());
                    gc.setInfoMonsterItems(jTextAMonsterAndtems.getText());
                    gc.setInforRoom(jTextDirectionRoom.getText());

                    out.writeObject(gc);
                    out.close();
                    fileOut.close();
                    System.out.printf("Serialized data is saved in /tmp/employee.ser");
                } catch (IOException i) {
                    System.out.println("there is some ting wrong");;
                }
            }

            if (choose.equals("load")) {

                try {
                    FileInputStream fileIn = new FileInputStream("gc.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    gc = (GameControler) in.readObject();
                    jTextDirectionRoom.setText(gc.getInforplayer());
                    jTextAMonsterAndtems.setText(gc.getInfoMonsterItems());
                    jTextDirectionRoom.setText(gc.getInforRoom());
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    System.out.println("Employee class not found");
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("Employee class not found");

                    return;
                }
            }
            if (choose.equals("newPlay")) {
                JFrame f = (JFrame) SwingUtilities.getWindowAncestor(this);
                f.remove(this);
                JPanelLogInDungeonGame jpl;
                jpl = new JPanelLogInDungeonGame();
                f.add(jpl);
                f.setTitle("Login");
                f.pack();
            }

            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());

        } else if (!gc.isPlayerAlive()) {
            jTextDirectionRoom.setText("You died!");
            jTextDirectionRoom.append(" \ngame over");
            JOptionPane.showMessageDialog(null, gc.gameOver());
        } else {
            jTextDirectionRoom.setText("you win");
            jTextDirectionRoom.append("\ngame over");
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }


    }//GEN-LAST:event_jComboBoxACtionListActionPerformed


    private void jComboBoxPlayerItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPlayerItemsActionPerformed

        
        if (gc.isPlayerAlive() && gc.haveNotEndTreasureChest()) {
            String selectet = jComboBoxPlayerItems.getSelectedItem().toString();
            jTextDirectionRoom.setText(gc.use(selectet));
            jTextPlayer.setText(gc.playerToString());
            jTextAMonsterAndtems.setText(gc.currentRoomMonsterToString());
            ArrayList<Items> pi = gc.playerItemsCollection();
            jComboBoxPlayerItems.removeAllItems();           
            for (Items items : pi) {
                jComboBoxPlayerItems.addItem(items.getNavn());
            }
        } else {
            JOptionPane.showMessageDialog(null, gc.gameOver());
        }

    }//GEN-LAST:event_jComboBoxPlayerItemsActionPerformed

    private void jButtonAddItemstoComboboksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemstoComboboksActionPerformed
        if (!gc.getMonsterItems().isEmpty()) {
            for (Items items : gc.getMonsterItems()) {

                jComboBoxPlayerItems.addItem(items.getNavn());
            }
            for (int i = 0; i < gc.getMonsterItems().size(); i++) {
                gc.getMonsterItems().remove(i);
            }
        } else {

        }
    }//GEN-LAST:event_jButtonAddItemstoComboboksActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItemstoComboboks;
    private javax.swing.JButton jButtonEast;
    private javax.swing.JButton jButtonNorth;
    private javax.swing.JButton jButtonSouth;
    private javax.swing.JButton jButtonWest;
    private javax.swing.JComboBox<String> jComboBoxACtionList;
    private javax.swing.JComboBox<String> jComboBoxPlayerItems;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAMonsterAndtems;
    private javax.swing.JTextArea jTextAreaHelpCommando;
    private javax.swing.JTextArea jTextDirectionRoom;
    private javax.swing.JTextArea jTextPlayer;
    // End of variables declaration//GEN-END:variables
}
