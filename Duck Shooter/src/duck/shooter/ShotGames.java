/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duck.shooter;

import java.applet.AudioClip;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JApplet;

/**
 *
 * @author joeco_000
 */
public class ShotGames extends JApplet implements PropertyChangeListener {
AudioClip bangSound, auchSound;
    ShootingStaticVars shootingStaticVars;
   
    public void init() {
        bangSound = getAudioClip(getCodeBase(), "shooter/bangSound.au");
        auchSound = getAudioClip(getCodeBase(), "shooter/auchSound.au");

        shootingStaticVars = new ShootingStaticVars();
        ShootingStaticVars.bangStaticVar.addPropertyChangeListener((PropertyChangeListener) this);
        ShootingStaticVars.auchStaticVar.addPropertyChangeListener((PropertyChangeListener) this);
        ShootGamePanel shootGamePanel = new ShootGamePanel();
        add(shootGamePanel);
    }
public void propertyChange(PropertyChangeEvent e) {
            String textJLabel = e.getSource().toString();
            String[] textJLabelsplited = textJLabel.split(",");
            // System.out.println(textJLabelsplited[0]);

            if(textJLabelsplited[0].equals("javax.swing.JLabel[bangStaticVar")){
                System.out.println("bangStaticVar");
                bangSound.play();
            }else if(textJLabelsplited[0].equals("javax.swing.JLabel[auchStaticVar")){
                System.out.println("auchStaticVar");
                auchSound.play();
            }
        }
    // TODO overwrite start(), stop() and destroy() methods
}
