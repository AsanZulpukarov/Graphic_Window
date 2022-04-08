package HW9_2;
import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {
    public static int indexFun = -1;
    private int gWidth;
    private int gHeight;

    @Override
    public void paint(Graphics g) {
        Graphics2D gr = (Graphics2D)g;
        super.paint(gr);

        gWidth = getWidth();
        gHeight = getHeight();
        drawGrid(gr);
        gr.setColor(Color.BLACK);
        gr.drawLine(0,gHeight/2,gWidth,gHeight/2);
        gr.drawLine(gWidth/2,0,gWidth/2,gHeight);
        choiceFunc(gr);
    }

    @Override
    public void repaint() {
        super.repaint();
    }

    public void choiceFunc(Graphics2D g){
        BasicStroke pen1 = new BasicStroke(6);
        g.setStroke(pen1);
        g.setColor(Color.RED);
        switch (indexFun) {
            case 0 -> drawSin(g);
            case 1 -> drawCos(g);
            case 2 -> drawXEqualsY(g);
        }
    }

    private void drawGrid(Graphics2D g) {
        g.setColor(Color.LIGHT_GRAY);

        for(int x=gWidth/2; x<gWidth; x+=30){
            g.drawLine(x, 0, x, gHeight);
        }

        for(int x=gWidth/2; x>0; x-=30){
            g.drawLine(x, 0, x, gHeight);
        }

        for(int y=gHeight/2; y<gHeight; y+=30){
            g.drawLine(0, y, gWidth, y);
        }

        for(int y=gHeight/2; y>0; y-=30){
            g.drawLine(0, y, gWidth, y);
        }
    }
    private void drawSin(Graphics2D g) {
        g.drawString(DrawGraphic.function[indexFun],40,40);

        for(int x=0; x<gWidth; x++){
            int realX = x - gWidth/2;
            double rad = realX/30.0;
            double sin = Math.sin(rad);
            int y = gHeight/2 + (int) (sin * 90);

            g.drawOval(x, y, 3, 3);
        }
    }
    private void drawCos(Graphics2D g) {
        g.drawString(DrawGraphic.function[indexFun],40,40);

        for(int x=0; x<gWidth; x++){
            int realX = x - gWidth/2;
            double rad = realX/30.0;
            double cos = Math.cos(rad);
            int y = gHeight/2 - (int) (cos * 90);

            g.drawOval(x, y, 3, 3);
        }
    }
    private void drawXEqualsY(Graphics2D g){
        g.drawString(DrawGraphic.function[indexFun],40,40);
        g.drawLine(0,gHeight,gWidth,0);
    }

}
