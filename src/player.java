import java.awt.*;

public class player {
    public int score = 0;
    public int x = game.dimX/2;
    public int y = (game.dimY/4);
    public int speed = 5;
    public Color color = Color.WHITE;

    player(){
        System.out.println("Player created");
    }

    public void move(int direction){
        if(direction==1 && y>5){ //up
            y-=speed;
        }
        else if(direction==2 && game.dimX-x>35){ //right
            x+=speed;
        }
        else if(direction==3 && game.dimY-y>35){ //down
            y+=speed;
        }
        else if(direction==4 && x>5){ //left
            x-=speed;
        }
    }
}
