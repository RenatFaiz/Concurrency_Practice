package drawapp;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PaintPanelCopyOnWriteArrayList extends PaintPanel {

    private final List<Triangle> triangles;

    public PaintPanelCopyOnWriteArrayList(int width, int height) {
        super(width, height);
        triangles = new CopyOnWriteArrayList<>();

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
