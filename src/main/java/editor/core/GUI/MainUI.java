package editor.core.GUI;

import editor.core.EditorInterfaceImpl;
import editor.core.EditorInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import com.intellij.util.ui.UIUtil;

public class MainUI extends JPanel{
    private EditorInterface editor;

    private final JPanel imagePanel;
    private final JPanel contentPanel;
    private final JLabel imageLabel;
    private final JSlider slider;
    private final JLabel sliderLabel;
    private final JPanel scalePanel;
    private final JButton refreshDiagramButton;


    private final Color color;

    private double scale = 1.5;

    private BufferedImage diagram;

    public final int SCALE_MAX = 100;
    public int ACTUAL_SCALE = 50;
    private JPanel panel1;
    private JSlider slider1;

    public MainUI(EditorInterfaceImpl yumlmeEditor) {
        this.editor = yumlmeEditor;
        this.setLayout(new BorderLayout());
        if(UIUtil.isUnderDarcula())
            color=Color.DARK_GRAY;
        else color=Color.WHITE;

        this.setBackground(color);



        imagePanel = new JPanel(new BorderLayout());
        contentPanel = new JPanel(new BorderLayout());

        imagePanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
        imagePanel.setBackground(color);

        imageLabel = new JLabel("");
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);

        scalePanel = new JPanel(new BorderLayout());
        scalePanel.setBackground(color);

        slider = new JSlider(JSlider.HORIZONTAL, 1, SCALE_MAX, ACTUAL_SCALE);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });


        sliderLabel = new JLabel("Diagram scale", SwingConstants.CENTER);

        refreshDiagramButton = new JButton();
        refreshDiagramButton.setBackground(color);


        refreshDiagramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        scalePanel.add(refreshDiagramButton, BorderLayout.WEST);
        scalePanel.add(sliderLabel, BorderLayout.CENTER);
        scalePanel.add(slider, BorderLayout.AFTER_LAST_LINE);
        this.add(scalePanel, BorderLayout.BEFORE_FIRST_LINE);


    }


}
