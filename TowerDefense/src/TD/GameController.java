package TD;
import java.util.*;
/**
 * Created by VTH on 10/22/2019.
 */
public class GameController {

    private static int[][] loadMapFromFile() {
        int a[][] = new int[12][20];
        File file = new File("src/Map.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
            return null;
        }
        for (int i = 0; i < 12; i++)
            for (int j = 0; j < 20; j++)
                a[i][j] = sc.nextInt();
        //sc.close();
        return a;
    }
}
