package HW9_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawGraphic extends JFrame {
    private int mwWidth;
    private int mwHeight;
    private Graphic graphicPanel;
    private JPanel infoPanel;
    private JButton submit;

    public final static String[] function = {"y = sin(x)","y = cos(x)","y = x"};

    DrawGraphic(){
        super("Draw graphic");
        this.setBounds(100,100,600,400);
        mwWidth = getWidth();
        mwHeight = getHeight();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graphicPanel = new Graphic();
        graphicPanel.setBounds(mwWidth /2,0, mwWidth /2, mwHeight);
        graphicPanel.setBackground(Color.WHITE);

        infoPanel = new JPanel(new GridLayout(3,1));
        JLabel jLabel = new JLabel("Select function:");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font(null, Font.BOLD, 20));
        infoPanel.add(jLabel);

        JComboBox comboBox = new JComboBox(function);
        comboBox.setFont(new Font("Arial", Font. BOLD, 20));
        comboBox.setAlignmentX(SwingConstants.CENTER);
        infoPanel.add(comboBox);

        submit = new JButton("DRAW");
        submit.setFont(new Font(null, Font. BOLD, 20));
        submit.setHorizontalAlignment(SwingConstants.CENTER);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Graphic.indexFun = comboBox.getSelectedIndex();
                graphicPanel.repaint();
            }
        });
        infoPanel.add(submit);
        this.add(infoPanel);

        this.add(graphicPanel);

        this.setLayout(new GridLayout(1,2));
        this.setVisible(true);
    }
}
