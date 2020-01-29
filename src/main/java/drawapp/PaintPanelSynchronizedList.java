package drawapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaintPanelSynchronizedList extends PaintPanel {
    private final List<Triangle> triangles;

    public PaintPanelSynchronizedList(int width, int height) {
        super(width, height);
        triangles = Collections.synchronizedList(new ArrayList<>());

    }

    @Override
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaintPanelSynchronizedList.this.repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
          /* synchronized list doesn't provide synchronized iterator,
          so we need synchronized block:
        synchronized (triangles) {
            for (Triangle triangle : triangles) {
                triangle.draw(g);
            }
        } or use this simple sort*/
        for (int i = 0; i < triangles.size(); i++) {
            triangles.get(i).draw(g);

        }
    }
}
