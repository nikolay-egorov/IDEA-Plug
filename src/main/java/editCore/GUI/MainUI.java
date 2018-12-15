package editCore.GUI;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import editCore.EditorInterfaceImpl;
import editCore.EditorInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import com.intellij.util.ui.UIUtil;

import static utils.YumlMeConvertor.generateDiagram;

public class MainUI extends JPanel{
    private EditorInterface editor;

    private  JPanel imagePanel;
    private  JPanel contentPanel;
    private  JLabel imageLabel;
    private  JSlider slider;
    private  JLabel sliderLabel;
    private  JPanel scalePanel;
    private  JButton refreshDiagramButton;


    private final Color color;

    private double scale = 1.5;

    private BufferedImage diagram;

    public final int SCALE_MAX = 100;
    public int ACTUAL_SCALE = 50;

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


        imagePanel.add(imageLabel );
        imagePanel.add(imageLabel );

        scalePanel = new JPanel(new BorderLayout());
        scalePanel.setBackground(color);

        slider = new JSlider(JSlider.HORIZONTAL, 1, SCALE_MAX, ACTUAL_SCALE);
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updScale();
            }
        });


  //      sliderLabel = new JLabel("Diagram scale", SwingConstants.CENTER);

    //    refreshDiagramButton = new JButton();
        refreshDiagramButton.setBackground(color);


        refreshDiagramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        this.add(scalePanel, BorderLayout.BEFORE_FIRST_LINE);



        diagram = loadDiagram();
        updScale();



/*        scalePanel.add(refreshDiagramButton, BorderLayout.WEST);
        scalePanel.add(sliderLabel, BorderLayout.CENTER);
        scalePanel.add(slider, BorderLayout.AFTER_LAST_LINE);
        this.add(scalePanel, BorderLayout.BEFORE_FIRST_LINE);*/







    }

    private void updateView(){
        if (diagram != null) {
            int imageWidth = diagram.getWidth();
            int imageHeight = diagram.getHeight();
            BufferedImage bi = UIUtil.createImage(
                    (int) (imageWidth * scale),
                    (int) (imageHeight * scale),
                    diagram.getType());
            Graphics2D g2 = bi.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
            at.scale(scale, scale);
            g2.drawRenderedImage(diagram, at);
            imageLabel.setIcon(new ImageIcon(bi));
        }

    }

    private void updScale() {
        int value = this.slider.getValue();
        scale = value / 100.0;
        updateView();

    }

    private BufferedImage loadDiagram() {
        Document document = FileDocumentManager.getInstance().getDocument(editor.getFile());

        return generateDiagram(document.getText());
    }
    public JComponent getDiagramComponent() {
        return contentPanel;
    }




}
