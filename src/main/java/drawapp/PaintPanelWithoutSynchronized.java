package drawapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaintPanelWithoutSynchronized extends PaintPanel {
    private final List<Triangle> triangles;

    public PaintPanelWithoutSynchronized(int width, int height) {
        super(width, height);
        triangles = new ArrayList<>();
    }

    @Override
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
        SwingUtilities.invokeLater(this::repaint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Triangle triangle : triangles) {
            triangle.draw(g);
        }
    }
}
