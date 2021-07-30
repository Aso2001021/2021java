package Game;

import javax.lang.model.util.ElementScanner14;

public class Game {
    private final int SHIP_NUM = 3;
    private final int MAP_SIZE = 5;
    private ship[] ships = new Ship[SHIP_NUM];
    private Map map = new map();

    public Game(){
        for(int i = 0; i < SHIP_NUM; i++){
            ships[i] = new ship();
        }
    }
    public void init(){
        map.init(MAO_SIZE);
        for(int i = 0; i < MAP_SIZE; i++){
            do{
                ships[i].init(MAP_SIZE);
             }while(!map.deployship(ship[i]));
        }
    }
    public void execute(){
        int attackx;
        int attacky;
        Scanner scanner = new scanner(System.in);
        int turn = 1;

        title();
        while(!isAllsink()){
            System.out.println("----------[ターン"+turn+"]----------");
            displaysituation();
            System.out.println("爆弾のX座標を入力してください(1-"+MAP_SIZE+")");
            attackx = scanner.nextInt();
            System.out.println("爆弾のY座標を入力してください(1-"+MAP_SIZE+")");
            attacky = scanner.nextInt();

            for(int i=0; i<SHIP_NUM; i++ ){
                int result =ships[i].check(attackx-1,attacky-1);
                doByResult(ships[i],i+1,result);
            }
            turn++;
        }
        System.out.println("全て撃沈！おめでとう");

        scanner.close();
    }
    private void title(){
        System.out.println("***************************");
        System.out.println("           戦艦ゲーム        ");
        System.out.println("***************************");
    }
    private boolaen isAllSink(){
        boolean allSink = true;
        for(int i=0; i<SHIP_NUM; i++){
            if(ship[i].isAlive()){
                allsink = false;
                break;
            }
        }
        return allSink;
    }
    private void displaySituation{
        for(int i=0; i<SHIP_NUM; i++){
            if(ships[i].isAlive()){
                System.out.println("船"+(i+1)+":生きてる");
            }else{
                System.out.println("船"+(i+1)+"撃沈済み");
            }
        }
    }
    private void doByResult(Ship ship, int no, int result ){
        if(result == Ship.NO_HIT){
            System.out.println("船"+no+"ハズレ！");
        }else if(result==Ship.NEAR){
            System.out.println("船"+no+"波高し！");
        }else if(result==Ship.HIT){
            System.out.println("船"+no+"爆弾が当たった！しかし船はまだ沈まない！船は移動します");
            moveShip(ship);
        }else{
            System.out.println("船"+no+"爆弾が当たった！船は撃沈しました");
            map.clear(ship.getPosx(), ship.getPosy());
        }
    } 
    private void moveShip(ship ship){
        map.clear(ship.getPosx(),ship.getPosy());
        do{
            ship.move(MAP_SIZE);
        }while(!map.deployship(ship));
    }
}
