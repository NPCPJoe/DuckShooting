/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duck.shooter;
import java.util.Random;


import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author joeco_000
 */
public class ShootGamePanel extends JPanel implements MouseListener{
    private final Image backgroundImg;
    JLabel targetImage = new JLabel();
    String birdImage = "bird.png";
    String bloodImage = "blood.png";
    int hitNums = 0;
    JLabel hitNumsLabel = new JLabel();
    static Random rand = new Random();
    ShootingStaticVars shootingStaticVars = new ShootingStaticVars();


public ShootGamePanel(){
backgroundImg = new javax.swing.ImageIcon(getClass().getResource("city.png")).getImage();
hitNumsLabel.setText("Good Shot:" + Integer.toString(hitNums));
targetImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(birdImage)));
setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));




addMouseListener(this);
add(hitNumsLabel);
add(targetImage);
movingImage.start();
}

int targetImageX;
                int targetImageY;

        boolean addingX = true;
        boolean addingY = true;

            int randomVertical = 0;
            int randomHorizontal = 0;


Thread movingImage = new Thread(new Runnable(){
    public void run(){
        for(int i=1; i>0; i++){
           
            
            
            if(targetImage.getX() > 600){
               randomHorizontal = rand.nextInt((300 - 1) + 1) + 1;
                    targetImage.setLocation(1, randomHorizontal);
                    targetImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(birdImage))); 
            }
            targetImageX = targetImage.getX() + 1;
            targetImage.setLocation(targetImageX, randomHorizontal);
            
             try{
                movingImage.sleep(1);
            }
            catch(InterruptedException p){}
            
             paintImmediately(targetImageX-4, targetImageY-4, targetImageX+50, targetImageY+50);
    }
    }
},

        "Thread A");

public void paintComponent(Graphics g){
super.paintComponent(g);
g.drawImage(backgroundImg,0,0, null);
}

    
    public void mouseClicked(MouseEvent e) {
       boolean result = false;
        int crossX = e.getX();
        int crossY = e.getY();
        int targetImageX = targetImage.getX();
        int targetImageY = targetImage.getY();
//       

            //the next will check out for an horizontal match
            if(targetImageX < crossX && (targetImageX+52) > crossX){
                result = true;
            }

            //the next will check out for an vertical match only if the previous was true
        if(result){
            if(targetImageY < crossY && (targetImageY+34) > crossY){
                result = true;
            } else {
                result = false;
            }
        }

            //if so far it still true it means a hit has happened
        if(result){
//            System.out.println("a hit");
            targetImage.setIcon(new javax.swing.ImageIcon(getClass().getResource(bloodImage)));


                hitNums = hitNums + 1;
        hitNumsLabel.setText("Good Shoots: " + Integer.toString(hitNums));
        System.out.println(hitNumsLabel.getText());
        hitNumsLabel.repaint();
            if(shootingStaticVars.auchStaticVar.getText().equals("val")){
                shootingStaticVars.auchStaticVar.setText("xem");
            } else {
                shootingStaticVars.auchStaticVar.setText("val");
            }

            if(shootingStaticVars.bangStaticVar.getText().equals("val")){
               shootingStaticVars.bangStaticVar.setText("xem");
            } else {
               shootingStaticVars.bangStaticVar.setText("val");
            }
        } else {
//            System.out.println("no hit");
            if(shootingStaticVars.bangStaticVar.getText().equals("val")){
               shootingStaticVars.bangStaticVar.setText("xem");
            } else {
               shootingStaticVars.bangStaticVar.setText("val");
            }
        }

        

    }
    
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

   

    

    