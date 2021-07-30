package Game;

public class Ship {
    private int x;
    private int y;
    private int vaitality;
    private final int MAX_VITALITY=3;
    private static int NO_HIT=0;
    private static int NEAR=1;
    private static int HIT=2;
    private static int SINK=3;

    public int getPosx(){return x;}
    public int getPosy(){return y;}

    public ship(){
        x=0;
        y=0;

    }

    public void init(int mapSize){
        x=(int)(Math.random()*mapsize);
        y=(int)(Math.random()*mapsize);
    }

    public int check(int x; int y;){
        int result = NO_HIT;

        if(x==this.x && y==this.y){
            vitality--;
            if(vitality==0){
                result = SINK;
            }else{
                result = HIT;
            }
        }
        else if(
            (this.x-1 <= x && x <= this.x+1)&&
            (this.y-1 <= y && y <= this.y+1)
        ){
            result = NEAR;
        }
        return result;
    }
    public booleanisAlive(){
        return(vitality = 0);
    }
}
