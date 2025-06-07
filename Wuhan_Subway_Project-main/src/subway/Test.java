package subway;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        SubwaySystem subway = new SubwaySystem("C:\\Users\\29255\\Desktop\\Wuhan_Subway_Project-main\\out\\production\\Wuhan_Subway_Project-main\\subway.txt");
        PathFinder pathFinder = new PathFinder(subway);

        //3.1查询地铁中转站
        System.out.println(subway.getTransferStations());
        //3.2查询某站点距离小于 n 的所有站点
        System.out.println(pathFinder.getNearbyStations("珞雄路",4));
        //3.3查询所有的路径
        List<List<Station>> paths = pathFinder.findAllPaths("华中科技大学", "楚河汉街");
        for(int i=0; i<4; i++){
            System.out.println(paths.get(i));
        }
        //3.4查询最短路径
        try{
            List<Station> shortestPath = pathFinder.findShortestPath("径河","天河机场");
            System.out.println(shortestPath);
            //3.5构造简洁路径
            System.out.println(PathFinder.getSimplePath(shortestPath));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        //3.6选择路径的费用
        System.out.println(FareCalculator.calculateFare(paths.get(7),0));

        //3.7其他模式的费用
        System.out.println(FareCalculator.calculateFare(paths.get(7),1));
        System.out.println(FareCalculator.calculateFare(paths.get(7),2));
    }
}
