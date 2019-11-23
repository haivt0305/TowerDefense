package sample.GameEntities;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sample.Config;
import sample.GameEntities.Tower.MachineGunTower;
import sample.GameEntities.Tower.NormalTower;
import sample.GameEntities.Tower.SniperTower;
import sample.Main;

import java.awt.*;

public class Shop extends ImmovableObject {
    public static Image normalTower;
    public static Image machineGunTower;
    public static Image sniperTower;
    public static ImageView normal;
    public static ImageView machineGun;
    public static ImageView sniper;
    public boolean clickedNormal;
    public boolean clickedMachineGun;
    public boolean clickedSniper;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public Shop() {
        normalTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile203.png");
        machineGunTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        sniperTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");

        normal=new ImageView(normalTower);
        normal.setX(3 * Config.tileScale);
        normal.setY(10 * Config.tileScale);

        machineGun=new ImageView(machineGunTower);
        machineGun.setX(4 * Config.tileScale);
        machineGun.setY(10*Config.tileScale);

        sniper=new ImageView(sniperTower);
        sniper.setX(5 * Config.tileScale);
        sniper.setY(10 * Config.tileScale);

        clickedNormal=false;
        clickedMachineGun=false;
        clickedSniper=false;
        normal.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedNormal) {
                    clickedNormal=true;
                    clickedMachineGun=false;
                    clickedSniper=false;
                }
                else clickedNormal=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();

            }
        }));
        normal.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        normal.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.tileScale);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.tileScale);
                System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && 50 <= Main.coin.getCoin()) {
                    Map.map_block[newX][newY]=1;
                    Main.coin.setCoin(Main.coin.getCoin()-50);
                    Main.movableObjects.add(new NormalTower(newX, newY));
                    //   Map.draw();
                    System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);

            }
        }));

        machineGun.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedMachineGun) {
                    clickedMachineGun=true;
                    clickedSniper=false;
                    clickedNormal=false;
                }
                else clickedMachineGun=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
                //   System.out.println(t.getX()+" "+t.getY());

            }
        }));

        machineGun.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        machineGun.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.tileScale);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.tileScale);
                System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && 50 <= Main.coin.getCoin()) {
                    Map.map_block[newX][newY]=1;
                    Main.coin.setCoin(Main.coin.getCoin()-50);
                    Main.movableObjects.add(new MachineGunTower(newX, newY));
                    //   Map.draw();
                    System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
        sniper.setOnMousePressed((new EventHandler<MouseEvent>() {

            public void handle(MouseEvent t) {
                if(!clickedSniper) {
                    clickedSniper=true;
                    clickedMachineGun=false;
                    clickedNormal=false;

                }
                else clickedSniper=false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();

                //    System.out.println(event.getX()+" "+event.getY());

            }
        }));
        sniper.setOnMouseDragged((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((ImageView)(t.getSource())).setTranslateX(newTranslateX);
                ((ImageView)(t.getSource())).setTranslateY(newTranslateY);
            }
        }));
        sniper.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int newX= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.tileScale);
                int newY= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.tileScale);
                System.out.println(newX+" "+newY);
                if(Map.map_block[newX][newY]==0 && 50 <= Main.coin.getCoin()) {
                    Map.map_block[newX][newY]=1;
                    Main.coin.setCoin(Main.coin.getCoin()-50);
                    Main.movableObjects.add(new SniperTower(newX, newY));
                    //   Map.draw();
                    System.out.println("placed");
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(normalTower,3* Config.tileScale,10* Config.tileScale);
        gc.drawImage(machineGunTower,4*Config.tileScale,10*Config.tileScale);
        gc.drawImage(sniperTower,5* Config.tileScale,10* Config.tileScale);

        gc.fillText("300$",3* Config.tileScale,11* Config.tileScale +32);
        gc.fillText("500$",4* Config.tileScale,11* Config.tileScale +32);
        gc.fillText("700$",5* Config.tileScale,11* Config.tileScale +32);

        gc.setStroke(Color.BLACK);
        if(clickedNormal) gc.strokeRect(3*Config.tileScale,10*Config.tileScale,2*Config.tileScale,Config.tileScale);
        else if(clickedMachineGun) gc.strokeRect(4*Config.tileScale,10*Config.tileScale,2*Config.tileScale,Config.tileScale);
        else if(clickedSniper) gc.strokeRect(5*Config.tileScale,10*Config.tileScale,2*Config.tileScale,Config.tileScale);
    }

    @Override
    public void update() {

    }
}
