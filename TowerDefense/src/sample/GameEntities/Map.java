package sample.GameEntities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import sample.Config;

public class Map {

    public static int[][] map_block=new int[20][12];

    public static final String[][] MAP_SPRITES = new String[][] {
            { "129", "129", "129", "129", "079", "080", "080", "080", "080", "080", "080", "080", "081", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "129", "129", "102", "034", "034", "034", "034", "034", "034", "034", "104", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "129", "129", "102", "034", "082", "126", "126", "126", "083", "034", "104", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "129", "129", "102", "034", "104", "129", "129", "129", "102", "034", "104", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "079", "080", "106", "034", "104", "129", "129", "129", "102", "034", "104", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "102", "034", "034", "034", "104", "129", "129", "129", "102", "034", "104", "129", "129", "129", "129", "129", "129", "129" },
            { "129", "129", "102", "034", "082", "126", "127", "129", "129", "129", "102", "034", "105", "080", "080", "080", "080", "080", "080", "080" },
            { "080", "080", "106", "034", "104", "129", "129", "129", "129", "129", "102", "034", "034", "034", "034", "034", "034", "034", "034", "034" },
            { "034", "034", "034", "034", "104", "129", "129", "129", "129", "129", "125", "126", "126", "126", "126", "126", "126", "126", "126", "126" },
            { "126", "126", "126", "126", "127", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129", "129" },
            { "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262" },
            { "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262", "262" },

    };

    public static void drawMap(GraphicsContext gc) {
        for (int i = 0; i < MAP_SPRITES.length; i++) {
            for (int j = 0; j < MAP_SPRITES[i].length; j++) {
                Image image = new Image("file:src/AssetsKit_2/PNG/Default size/towerDefense_tile" + MAP_SPRITES[i][j] + ".png");

                gc.drawImage(image, j * Config.tileScale, i * Config.tileScale);
            }
        }
    }

    public static void autoDrawMap(){
        //    System.out.println(map_block.length);//16
        //    System.out.println(map_block[1].length);//12
        //   System.out.println(MAP_SPRITES.length);//12
        //    System.out.println(MAP_SPRITES[0].length);//16

        for (int j = 0; j < map_block[1].length; j++) {//12
            for (int i = 0; i < map_block.length; i++) {//16
                if(MAP_SPRITES[j][i]=="129") map_block[i][j]=1;
                else map_block[i][j]=1;
                //  System.out.print(map_block[i][j]);
            }
            //   System.out.println();
        }
    }
    public static void draw(){
        for (int j = 0; j < map_block[1].length; j++) {
            for (int i = 0; i < map_block.length; i++) {

                System.out.print(map_block[i][j]);
            }
            System.out.println();
        }
    }
}
