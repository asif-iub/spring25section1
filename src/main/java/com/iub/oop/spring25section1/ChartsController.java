package com.iub.oop.spring25section1;

import javafx.event.ActionEvent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.List;

public class ChartsController extends BaseController
{
    @javafx.fxml.FXML
    private BarChart barChart;
    @javafx.fxml.FXML
    private PieChart pieChart;

    @javafx.fxml.FXML
    public void initialize() {

    }

    void loadPieChartData() {
        List<PieChart.Data> data = new ArrayList<>();
        data.add(new PieChart.Data("A", 3));
        data.add(new PieChart.Data("B", 4));
        data.add(new PieChart.Data("C", 8));
        data.add(new PieChart.Data("D", 4));
        data.add(new PieChart.Data("F", 1));

        pieChart.getData().addAll(data);
    }

    void loadBarChartData() {
        List<XYChart.Data> data = new ArrayList<>();
        data.add(new XYChart.Data("A", 3));
        data.add(new XYChart.Data("B", 4));
        data.add(new XYChart.Data("C", 8));
        data.add(new XYChart.Data("D", 4));
        data.add(new XYChart.Data("F", 1));

        XYChart.Series series1 = new XYChart.Series();
        series1.getData().addAll(data);
        barChart.getData().add(series1);
    }

    @javafx.fxml.FXML
    public void refresh(ActionEvent actionEvent) {
        loadPieChartData();
        loadBarChartData();
    }
}