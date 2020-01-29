package drawapp;

import javax.swing.*;
import java.awt.*;

public abstract class PaintPanel extends JPanel {

    public PaintPanel(int width, int height) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
    }

    public abstract void addTriangle(Triangle triangle);
}
