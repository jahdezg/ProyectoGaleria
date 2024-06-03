package grupo.proyecto.galeria.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import grupo.proyecto.galeria.interfaz.MainVentana;

public class Grafico2 extends JDialog {
    public DefaultCategoryDataset datosVentas;
    public MainVentana principal;

    public Grafico2(MainVentana pPrincipal, List<Integer> ventas) {
        principal = pPrincipal;
        setTitle("Ventas");
        setSize(650, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        datosVentas = new DefaultCategoryDataset();
        datosVentas.setValue(ventas.get(0), "Ventas", "Enero");
        datosVentas.setValue(ventas.get(1), "Ventas", "Febrero");
        datosVentas.setValue(ventas.get(2), "Ventas", "Marzo");
        datosVentas.setValue(ventas.get(3), "Ventas", "Abril");
        datosVentas.setValue(ventas.get(4), "Ventas", "Mayo");
        datosVentas.setValue(ventas.get(5), "Ventas", "Junio");
        datosVentas.setValue(ventas.get(6), "Ventas", "Julio");
        datosVentas.setValue(ventas.get(7), "Ventas", "Agosto");
        datosVentas.setValue(ventas.get(8), "Ventas", "Septiembre");
        datosVentas.setValue(ventas.get(9), "Ventas", "Octubre");
        datosVentas.setValue(ventas.get(10), "Ventas", "Noviembre");
        datosVentas.setValue(ventas.get(11), "Ventas", "Diciembre");

        JFreeChart graf = crearGrafico("Ventas por mes", "Meses", datosVentas);
        ChartPanel chartPanel = new ChartPanel(graf);
        chartPanel.setPreferredSize(new Dimension(650, 400));
        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);

        setModal(true);
        setLocationRelativeTo(principal);
        setResizable(false);
    }

    private static JFreeChart crearGrafico(String pTitulo, String pEje, DefaultCategoryDataset pDatos) {
        JFreeChart chart = ChartFactory.createBarChart(pTitulo, pEje, "Ventas", pDatos, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);

        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
        return chart;
    }
}

