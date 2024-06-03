package grupo.proyecto.galeria.interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

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
import grupo.proyecto.galeria.Compra;
import grupo.proyecto.galeria.interfaz.MainVentana;

public class Grafico extends JDialog
{
	public DefaultCategoryDataset datosVentas;
	public MainVentana principal;
	
	public Grafico(MainVentana pPrincipal, List<Integer> ventas)
	{
		principal = pPrincipal;
		setTitle( "Ventas" );
        setSize( 650, 400 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
        
        datosVentas = new DefaultCategoryDataset();
		JFreeChart graf = crearGrafico("Ventas por mes", "Ventas", datosVentas);
		datosVentas.setValue(ventas.get(0), "Enero", "");
		datosVentas.setValue(ventas.get(1), "Febrero", "");
		datosVentas.setValue(ventas.get(2), "Marzo", "");
		datosVentas.setValue(ventas.get(3), "Abril", "");
		datosVentas.setValue(ventas.get(4), "Mayo", "");
		datosVentas.setValue(ventas.get(5), "Junio", "");
		datosVentas.setValue(ventas.get(6), "Julio", "");
		datosVentas.setValue(ventas.get(7), "Agosto", "");
		datosVentas.setValue(ventas.get(8), "Septiembre", "");
		datosVentas.setValue(ventas.get(9), "Octubre", "");
		datosVentas.setValue(ventas.get(10), "Noviembre", "");
		datosVentas.setValue(ventas.get(11), "Diciembre", "");
		
		setModal( true );
        setLocationRelativeTo( principal );
        setResizable( false );
	}
	

	
	
	
	
	private static JFreeChart crearGrafico( String pTitulo, String pEje, DefaultCategoryDataset pDatos )
    {

        JFreeChart chart = ChartFactory.createBarChart( pTitulo, pEje, "Votos", pDatos, PlotOrientation.VERTICAL, true, true, false );

        chart.setBackgroundPaint( Color.white );

        CategoryPlot plot = chart.getCategoryPlot( );
        plot.setBackgroundPaint( Color.lightGray );
        plot.setDomainGridlinePaint( Color.white );
        plot.setRangeGridlinePaint( Color.white );

        NumberAxis rangeAxis = ( NumberAxis )plot.getRangeAxis( );
        rangeAxis.setStandardTickUnits( NumberAxis.createIntegerTickUnits( ) );

        BarRenderer renderer = ( BarRenderer )plot.getRenderer( );
        renderer.setDrawBarOutline( false );

        CategoryAxis domainAxis = plot.getDomainAxis( );
        domainAxis.setCategoryLabelPositions( CategoryLabelPositions.createUpRotationLabelPositions( Math.PI / 6.0 ) );
        return chart;
    }
}
