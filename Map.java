package Game;

public class Map {
    private final int NO_SHIP=0;
    private final int SHIP=1;
    private int [][] map;

    public map(){
        ;
    }

    public void init(int mapsize){
        map = new int[mapSize][mapSize];
        for(int i=0; i<mapSize; i++){
            for(int j=0; j<mapSize; j++){
                map[i][j] = NO_SHIP;
            }
        } 
    }

    public boolean depolyship(ship ship){
        int x = ship.getposx;
        int y = ship.getposy;

        if(x>=map.length || y>=map.length){
            return false;
        } 

        if(map[x][y]!=NO_SHIP){
            return false;
        }

        map[x][y] = SHIP;

        return true;
        }

        public void clear(int x,int y){
            if(x>=map.length || y>=map.length){
                return
            }
            map[x][y] = NO_SHIP;
        }
}
