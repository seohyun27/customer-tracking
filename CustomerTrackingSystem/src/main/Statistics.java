package main;

import org.jfree.chart.JFreeChart;
import java.awt.*;

public class Statistics {
    private Owner owner;
    private String criteria;

    private JFreeChart ageChart;
    private JFreeChart visitChart;
    private JFreeChart timeChart;
    private JFreeChart priceChart;

    Statistics(Owner owner, String criteria){
        this.owner = owner;
        this.criteria = criteria;
    }

    public JFreeChart creatAgeChart(){
        return null;
    }

    public JFreeChart creatVisitChart(){
        return null;
    }

    public JFreeChart creatTimeChart(){
        return null;
    }

    public JFreeChart creatPriceChart(){
        return null;
    }

    public Image getChartImage(JFreeChart chart){
        return null;
    }
}