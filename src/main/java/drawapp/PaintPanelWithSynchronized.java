package drawapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintPanelWithSynchronized extends PaintPanel {

    private final List<Triangle> triangles;

    public PaintPanelWithSynchronized(int width, int height) {
        super(width, height);
        triangles = new ArrayList<>();
    }

    @Override
    public void addTriangle(Triangle triangle) {
        synchronized (triangles) {
           triangles.add(triangle);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaintPanelWithSynchronized.this.repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        synchronized (triangles) {
            for (Triangle triangle : triangles) {
                triangle.draw(g);
            }
        }
    }
}
