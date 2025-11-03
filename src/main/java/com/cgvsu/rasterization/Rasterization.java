package com.cgvsu.rasterization;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawEllipseByCorner(Canvas canvas, int x1, int y1, int width, int height) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int centerX = x1 + width / 2;
        int centerY = y1 + height / 2;
        int a = width / 2;
        int b = height / 2;
        drawEllipse(gc, centerX, centerY, a, b);
    }

    public static void drawEllipseByCenter(Canvas canvas, int centerX, int centerY, int a, int b) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawEllipse(gc, centerX, centerY, a, b);
    }

    private static void drawEllipse(GraphicsContext gc, int centerX, int centerY, int a, int b) {
        int x = 0;
        int y = b;

        int a2 = a * a;
        int b2 = b * b;

        int twoA2 = 2 * a2;
        int twoB2 = 2 * b2;

        int p;
        int px = 0;
        int py = twoA2 * y;

        plotPoints(gc, centerX, centerY, x, y);

        p = (int) (b2 - (a2 * b) + (0.25 * a2));
        while (px < py) {
            x++;
            px += twoB2;
            if (p < 0) {
                p += b2 + px;
            } else {
                y--;
                py -= twoA2;
                p += b2 + px - py;
            }
            plotPoints(gc, centerX, centerY, x, y);
        }

        p = (int) (b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
        while (y > 0) {
            y--;
            py -= twoA2;
            if (p > 0) {
                p += a2 - py;
            } else {
                x++;
                px += twoB2;
                p += a2 - py + px;
            }
            plotPoints(gc, centerX, centerY, x, y);
        }
    }

    private static void plotPoints(GraphicsContext gc, int centerX, int centerY, int x, int y) {
        gc.setFill(Color.BLACK);
        gc.fillRect(centerX + x, centerY + y, 1, 1);
        gc.fillRect(centerX - x, centerY + y, 1, 1);
        gc.fillRect(centerX + x, centerY - y, 1, 1);
        gc.fillRect(centerX - x, centerY - y, 1, 1);
    }
}