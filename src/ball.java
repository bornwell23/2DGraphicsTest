import java.awt.*;
import java.util.ArrayList;

public class ball {
    public int x = 250;
    double yMult = 2.4;
    double xMult = 4.7;
    public int y = 1;
    public Color color;

    ball(int x, int y, double xMult, double yMult){
        color = new Color(game.random.nextInt()*200+25);
        this.x = x;
        this.y = y;
        this.xMult = xMult;
        this.yMult = yMult;
    }

    public void moveBall() {
        if(x>=game.dimX-30){
            xMult *= -1;
            x = game.dimX - 30;
        }
        else if(x<=0){
            xMult *= -1;
            x = 30;
        }
        if(y>=game.dimY-30){
            yMult *= -1;
            y = game.dimY - 30;
        }
        else if(y<=0){
            yMult *= -1;
            y = 30;
        }
        for(ball b : game.ballList){
            if(this!=b){
                if(Math.abs(b.x-x)<15 && Math.abs(b.y-y)<15){
                    xMult *= -1;
                    x += (xMult*5);
                    yMult *= -1;
                    y += (yMult*5);
                }
            }
        }
        if(Math.abs(game.playerBall.x+30-x+15)<45 && Math.abs(game.playerBall.y+30-y+15)<45){
            ++game.playerBall.score;
            game.score.setText("Score: " + game.playerBall.score + "/" + game.totalBalls);
            if(game.playerBall.score==game.totalBalls){
                game.done = true;
            }
            java.util.List<ball> tempList = new ArrayList<>(game.ballList);
            tempList.remove(this);
            game.ballList = tempList;
            return;
        }
        x += xMult;
        y += yMult;
    }
}
