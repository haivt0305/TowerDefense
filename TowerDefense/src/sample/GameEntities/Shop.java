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

public class Shop extends ImmovableObject {
    public static Image normalTower;
    public static ImageView normalTowerImgView;
    public boolean clickNormalTower;

    public static Image machineGunTower;
    public static ImageView machineGunImgView;
    public boolean clickMachineGunTower;

    public static Image sniperTower;
    public static ImageView sniperTowerImgView;
    public boolean clickSniperTower;

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;

    public Shop() {
        normalTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile203.png");
        normalTowerImgView = new ImageView(normalTower);
        normalTowerImgView.setX(3 * Config.tileScale);
        normalTowerImgView.setY(10 * Config.tileScale);

        machineGunTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile250.png");
        machineGunImgView = new ImageView(machineGunTower);
        machineGunImgView.setX(5 * Config.tileScale);
        machineGunImgView.setY(10 * Config.tileScale);

        sniperTower = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile249.png");
        sniperTowerImgView = new ImageView(sniperTower);
        sniperTowerImgView.setX(7 * Config.tileScale);
        sniperTowerImgView.setY(10 * Config.tileScale);

        clickNormalTower = false;
        clickMachineGunTower = false;
        clickSniperTower = false;

        normalTowerImgView.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent m) {
                if(!clickNormalTower) {
                    clickNormalTower = true;
                    clickMachineGunTower = false;
                    clickSniperTower = false;
                }
                else clickNormalTower = false;
                orgSceneX = m.getSceneX();
                orgSceneY = m.getSceneY();
                orgTranslateX = ((ImageView)(m.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(m.getSource())).getTranslateY();
            }
        }));

        normalTowerImgView.setOnMouseDragged((new EventHandler<MouseEvent>() {
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

        normalTowerImgView.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int X= (int) ((((ImageView)(mouseEvent.getSource())).getX() + ((ImageView)(mouseEvent.getSource())).getTranslateX() + 32) / Config.tileScale);
                int Y= (int) ((((ImageView)(mouseEvent.getSource())).getY() + ((ImageView)(mouseEvent.getSource())).getTranslateY() + 32) / Config.tileScale);
                System.out.println(X + " " + Y);
                if(Config.NORMAL_TOWER_PRICE <= Main.coin.getCoin()) {
                    Main.coin.setCoin(Main.coin.getCoin() - Config.NORMAL_TOWER_PRICE);
                    Main.movableObjects.add(new NormalTower(X, Y));
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));

        machineGunImgView.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                if(!clickMachineGunTower) {
                    clickMachineGunTower = true;
                    clickSniperTower = false;
                    clickNormalTower = false;
                }
                else clickMachineGunTower = false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
            }
        }));

        machineGunImgView.setOnMouseDragged((new EventHandler<MouseEvent>() {
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

        machineGunImgView.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int X= (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.tileScale);
                int Y= (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.tileScale);
                System.out.println(X + " " + Y);
                if(Config.MACHINE_GUN_TOWER_PRICE <= Main.coin.getCoin()) {
                    Main.coin.setCoin(Main.coin.getCoin() - Config.MACHINE_GUN_TOWER_PRICE);
                    Main.movableObjects.add(new MachineGunTower(X, Y));
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));

        sniperTowerImgView.setOnMousePressed((new EventHandler<MouseEvent>() {
            public void handle(MouseEvent t) {
                if(!clickSniperTower) {
                    clickSniperTower = true;
                    clickMachineGunTower = false;
                    clickNormalTower = false;
                }
                else clickSniperTower = false;
                orgSceneX = t.getSceneX();
                orgSceneY = t.getSceneY();
                orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
                orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
            }
        }));

        sniperTowerImgView.setOnMouseDragged((new EventHandler<MouseEvent>() {
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

        sniperTowerImgView.setOnMouseReleased((new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int X = (int) ((((ImageView)(mouseEvent.getSource())).getX()+((ImageView)(mouseEvent.getSource())).getTranslateX()+32)/Config.tileScale);
                int Y = (int) ((((ImageView)(mouseEvent.getSource())).getY()+((ImageView)(mouseEvent.getSource())).getTranslateY()+32)/Config.tileScale);
                System.out.println(X + " " + Y);
                if(Config.SNIPER_TOWER_PRICE <= Main.coin.getCoin()) {
                    Main.coin.setCoin(Main.coin.getCoin() - Config.SNIPER_TOWER_PRICE);
                    Main.movableObjects.add(new SniperTower(X, Y));
                }
                ((ImageView)(mouseEvent.getSource())).setTranslateX(0);
                ((ImageView)(mouseEvent.getSource())).setTranslateY(0);
            }
        }));
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(normalTower, 3 * Config.tileScale, 10 * Config.tileScale);
        gc.drawImage(machineGunTower, 5 * Config.tileScale, 10 * Config.tileScale);
        gc.drawImage(sniperTower, 7 * Config.tileScale, 10 * Config.tileScale);

        gc.setFill(Color.YELLOW);
        gc.fillText("20$", 3* Config.tileScale + 5, 11* Config.tileScale + 35);
        gc.setFill(Color.YELLOW);
        gc.fillText("50$", 5* Config.tileScale + 5, 11* Config.tileScale + 35);
        gc.setFill(Color.YELLOW);
        gc.fillText("60$", 7* Config.tileScale + 5, 11* Config.tileScale + 35);

        if(clickNormalTower) gc.strokeRect(3 * Config.tileScale, 10 * Config.tileScale, Config.tileScale, Config.tileScale * 2 + 10);
        else if(clickMachineGunTower) gc.strokeRect(5 * Config.tileScale, 10 * Config.tileScale, Config.tileScale, Config.tileScale * 2);
        else if(clickSniperTower) gc.strokeRect(7 * Config.tileScale, 10*Config.tileScale, Config.tileScale, Config.tileScale * 2);
    }

    @Override
    public void update() {
    }
}
