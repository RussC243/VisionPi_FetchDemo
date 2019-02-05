/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visionpi;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author RussS9
 */
public class Pi_GUI {
    
    private static final boolean USE_GUI = true;
    private static final int SLIDE1_MIN = 0;
    private static final int SLIDE2_MIN = 0;
    private static final int SLIDE3_MIN = 0;
    private static final int SLIDE4_MIN = 0;
    private static final int SLIDE5_MIN = 0;
    private static final int SLIDE6_MIN = 0;
    private static final int SLIDE1_MAX = 360;
    private static final int SLIDE2_MAX = 360; //HSV full is 0 -360
    private static final int SLIDE3_MAX = 255;
    private static final int SLIDE4_MAX = 255;
    private static final int SLIDE5_MAX = 255;
    private static final int SLIDE6_MAX = 255;

    //mud room
    private static final int SLIDE1_DEFAULT = 216;
    private static final int SLIDE2_DEFAULT = 288;
    private static final int SLIDE3_DEFAULT = 40;
    private static final int SLIDE4_DEFAULT = 255;
    private static final int SLIDE5_DEFAULT = 225;
    private static final int SLIDE6_DEFAULT = 150;

    //big den full sun 9am
//    private static final int SLIDE1_DEFAULT = 228;
//    private static final int SLIDE2_DEFAULT = 252;
//    private static final int SLIDE3_DEFAULT = 49;
//    private static final int SLIDE4_DEFAULT = 166;
//    private static final int SLIDE5_DEFAULT = 173;
//    private static final int SLIDE6_DEFAULT = 188;

    //big den limited sun 2pm
//    private static final int SLIDE1_DEFAULT = 225;
//    private static final int SLIDE2_DEFAULT = 288;
//    private static final int SLIDE3_DEFAULT = 125;
//    private static final int SLIDE4_DEFAULT = 240;
//    private static final int SLIDE5_DEFAULT = 153;
//    private static final int SLIDE6_DEFAULT = 153;

    //big den getting dark 3pm
//    private static final int SLIDE1_DEFAULT = 235;
//    private static final int SLIDE2_DEFAULT = 254;
//    private static final int SLIDE3_DEFAULT = 0;
//    private static final int SLIDE4_DEFAULT = 255;
//    private static final int SLIDE5_DEFAULT = 226;
//    private static final int SLIDE6_DEFAULT = 184;


    public int slide1Val = SLIDE1_DEFAULT;
    public int slide2Val = SLIDE2_DEFAULT;
    public int slide3Val = SLIDE3_DEFAULT;
    public int slide4Val = SLIDE4_DEFAULT;
    public int slide5Val = SLIDE5_DEFAULT;
    public int slide6Val = SLIDE6_DEFAULT;
    
   // private static Mat matImgSrc1;
   // private static Mat matImgBase1;
    private static Mat matImgDst;
    private static JFrame jayFrameBlend;
    private JLabel imgLabelBlend;
    private void addComponentsToPaneBlend(Container pane) {
        if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Ugh! Container doesn't use BorderLayout!"));
            return;
        }
        //------------- setup panel ------------------------------------------
        JPanel jPan = new JPanel();
        jPan.setLayout(new BoxLayout(jPan, BoxLayout.PAGE_AXIS));
        jPan.add(new JLabel(String.format("panel string")));
        //------------ setup slider 1 -----------------------------------------
        JSlider slider1 = new JSlider(SLIDE1_MIN, SLIDE1_MAX, SLIDE1_DEFAULT);
        slider1.setMajorTickSpacing((SLIDE1_MAX-SLIDE1_MIN)/5);
        slider1.setMinorTickSpacing((SLIDE1_MAX-SLIDE1_MIN)/10);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide1Val = source.getValue();
            }
        });
        jPan.add(slider1);
        //------------ setup slider 2 -----------------------------------------
        JSlider slider2 = new JSlider(SLIDE2_MIN, SLIDE2_MAX, SLIDE2_DEFAULT);
        slider2.setMajorTickSpacing((SLIDE2_MAX-SLIDE2_MIN)/5);
        slider2.setMinorTickSpacing((SLIDE2_MAX-SLIDE2_MIN)/10);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide2Val = source.getValue();
            }
        });
        jPan.add(slider2);
       //------------ setup slider 3 -----------------------------------------
        JSlider slider3 = new JSlider(SLIDE3_MIN, SLIDE3_MAX, SLIDE3_DEFAULT);
        slider3.setMajorTickSpacing((SLIDE3_MAX-SLIDE3_MIN)/5);
        slider3.setMinorTickSpacing((SLIDE3_MAX-SLIDE3_MIN)/10);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide3Val = source.getValue();
            }
        });
        jPan.add(slider3);
        //------------ setup slider 4 -----------------------------------------
        JSlider slider4 = new JSlider(SLIDE4_MIN, SLIDE4_MAX, SLIDE4_DEFAULT);
        slider4.setMajorTickSpacing((SLIDE4_MAX-SLIDE4_MIN)/5);
        slider4.setMinorTickSpacing((SLIDE4_MAX-SLIDE4_MIN)/10);
        slider4.setPaintTicks(true);
        slider4.setPaintLabels(true);
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide4Val = source.getValue();
            }
        });
        jPan.add(slider4);
        //------------ setup slider 5 -----------------------------------------
        JSlider slider5 = new JSlider(SLIDE5_MIN, SLIDE5_MAX, SLIDE5_DEFAULT);
        slider5.setMajorTickSpacing((SLIDE5_MAX-SLIDE5_MIN)/5);
        slider5.setMinorTickSpacing((SLIDE5_MAX-SLIDE5_MIN)/10);
        slider5.setPaintTicks(true);
        slider5.setPaintLabels(true);
        slider5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide5Val = source.getValue();
            }
        });
        jPan.add(slider5);
        //------------ setup slider 6 -----------------------------------------
        JSlider slider6 = new JSlider(SLIDE6_MIN, SLIDE6_MAX, SLIDE6_DEFAULT);
        slider6.setMajorTickSpacing((SLIDE6_MAX-SLIDE6_MIN)/5);
        slider6.setMinorTickSpacing((SLIDE6_MAX-SLIDE6_MIN)/10);
        slider6.setPaintTicks(true);
        slider6.setPaintLabels(true);
        slider6.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                slide6Val = source.getValue();
            }
        });
        jPan.add(slider6);
      //------------ setup button 1 -----------------------------------------
        JButton button1 = new JButton();
        button1.setText("click me");
        button1.setBackground(Color.blue);
        java.awt.Point pt = new java.awt.Point(5,0);
        button1.setLocation(pt);//why not setting location?
        button1.setForeground(Color.green);  
        button1.addChangeListener(new ChangeListener() 
        {
                        @Override
                        public void stateChanged(ChangeEvent e) 
                        {
                                System.out.println("button 1 state change");				
                        }
                });
        jPan.add(button1);
        //------------ setup button 2 -----------------------------------------
        JButton button2 = new JButton();
        button2.setText("click me too");
        button2.setBackground(Color.red);
        java.awt.Point pt2 = new java.awt.Point(55,20);
        button2.setLocation(pt2);//why not setting location?
        button2.setForeground(Color.CYAN);  
        button2.addChangeListener(new ChangeListener() 
        {
                        @Override
                        public void stateChanged(ChangeEvent e) 
                        {
                                System.out.println("button 2 state change");				
                        }
                });
        jPan.add(button2);
        //---------------- add panel to pane ---------------------------------------
        pane.add(jPan, BorderLayout.PAGE_START);
    }
    public boolean getUseGUI(){
        return USE_GUI;
    }
    
    public double getSlide1(){
        return slide1Val;
    }
    public double getSlide2(){
        return slide2Val;
    }
    public double getSlide3(){
        return slide3Val;
    }
    public double getSlide4() {
        return slide4Val;
    }
    public double getSlide5() {
        return slide5Val;
    }
    public double getSlide6() {
        return slide6Val;
    }   
    public Pi_GUI(boolean enable) { //constructor
       if(enable)
       {
          //  matImgBase1 = new Mat();
          //  matImgDst = new Mat();
            jayFrameBlend = new JFrame();
            JLabel imgLabelBlend;
        jayFrameBlend = new JFrame("Controls");
        jayFrameBlend.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set up the content pane.
        addComponentsToPaneBlend(jayFrameBlend.getContentPane());
        // Display the window.
        jayFrameBlend.pack();
        jayFrameBlend.setVisible(true);
       }
    }
}
