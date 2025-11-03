package com.cgvsu.rasterizationfxapp;

import com.cgvsu.rasterization.Rasterization;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Rasterization.drawEllipseByCenter(canvas, 200, 200, 200, 100);


    }
}