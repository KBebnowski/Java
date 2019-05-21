package Zaj9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ReflexTester extends JPanel {

    List<JButton> buttons = new ArrayList<>();
    int rows, cols;
    long StartTime;
    long StopTime;

    public ReflexTester(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Refleks tester");//Panel
        ReflexTester rf = ReflexTester.createPanel(3,3);//rows, cols, tworzy panel z przyciskow
        frame.setContentPane(rf);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       rf.switchOn(2,1);//zapalamy losowo wybrane 2 liczby
       // rf.switchOff;
            }

    private static void time(){
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate = dateFormat.format(date);
        System.out.println(formattedDate);
    }

    private void switchOn(int row, int column) {

        int index =  (row-1)*cols+column-1;
        JButton b = buttons.get(index);
        b.setText("ON");
        StartTime=System.currentTimeMillis();
    }

    private void switchOff(int row, int column) {

        int index =  (row-1)*cols+column-1;
        JButton b = buttons.get(index);
        b.setText(""+row+column);//pusty lancuch aby nie konwertowac, gdyby nie to to 13 22 i 31 mialyby ten sam tekst
    }

    private static ReflexTester createPanel(int rows, int cols) {//metoda statyczna, fabryczna poniewaz wywolywana z klasy

        ReflexTester rf = new ReflexTester(rows, cols);
        //domyslnie borderlayout a my chcemy gridlayout, umieszcza on wierszami
        rf.setLayout(new GridLayout(rows, cols));
        for(int r = 1; r<=rows; r++){
            for(int c = 1; c<=cols; c++){
                JButton b = new JButton("" + r + c);
                rf.add(b);
                rf.buttons.add(b);
                b.addActionListener(rf.new ReflexActionListener());//jesli jest klasa wewnetrzna (ReflexActionListener) to potrzeba rf (klasy zawnetrznej)


            }
        }
        return rf; //jest to metoda fabryczna wiec musi zwrocic obiekt
    }

    private class ReflexActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if(b.getText().equals("ON")){
                int index;
                for(index=0; index<buttons.size(); index++){//klasa wewnwetrzna po to zeby miec buttons i buttons.size()
                    if(buttons.get(index)==b) break;
                }
                int row = index/cols+1;
                int col = index%cols+1;
                switchOff(row, col);

            }
            else {
                b.setText("ON");
            }
            StopTime=System.currentTimeMillis();
            System.out.println(StopTime-StartTime + "ms");
            StartTime=StopTime;
        }
    }
}
