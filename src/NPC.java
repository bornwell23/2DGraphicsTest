import java.awt.*;

public class NPC {
    public int score = 0;
    public int x = (game.dimX/4)*3;
    public int y = game.dimY/2;
    public int speed = 5;
    public Color color = Color.GRAY;

    NPC(){
        System.out.println("NPC created");
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

    public void findGreatestConcentration(){

    }

    public void follow(){

    }
}
