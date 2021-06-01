package Views;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img){
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);

        //adds a transparent screen over images helping white text to been seen better
        //adjust the alpha int value to gradually change shading
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setPaint(Color.black);
        float alpha = 2 * 0.1f;
        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, alpha);

        g2d.setComposite(alcom);
        g2d.fillRect(0, 0, 650, 450);

    }

}
