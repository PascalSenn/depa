import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class BarChartExample extends Application
{
    final static String year2016 = "2016";
    final static String year2017 = "2017";
 
 
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Bar Chart Sample");
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number, String> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("User Error Report");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Year & User");
 
        XYChart.Series series1 = new XYChart.Series();
 
        // series1.setName("2003");
        series1.getData().add(new XYChart.Data(100, year2017 + "\nSonya"));
        series1.getData().add(new XYChart.Data(400, year2016+ "\nFred"));
        series1.getData().add(new XYChart.Data(350, year2016+ "\nFlinstone"));
        series1.getData().add(new XYChart.Data(222, year2016+ "\nLisa"));
        series1.getData().add(new XYChart.Data(421, year2016+ "\nGeorge"));
        series1.getData().add(new XYChart.Data(393, year2016+ "\nPaul"));
        series1.getData().add(new XYChart.Data(256, year2016+ "\nJohn"));
        series1.getData().add(new XYChart.Data(249, year2016+ "\nRingo"));
        series1.getData().add(new XYChart.Data(230, year2016+ "\nLisa"));
        series1.getData().add(new XYChart.Data(201, year2016+ "\nFibanocci"));
 
 
        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1) ;
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args)
    {
        launch(args);
    }
}