package com.gvt.application.screen;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Dashboard extends JPanel
	{
		private static final long	serialVersionUID	= -7880560011124037228L;
		
		private JFXPanel			jfxPanel			= new JFXPanel();
		
		public Dashboard()
			{
				setVisible(true);
				setBackground(Color.WHITE);
				addChart();
			}
			
		private void addChart()
			{
				
				add(jfxPanel);
				Platform.runLater(new Runnable()
					{
						@Override
						public void run()
							{
								addPieChart();
							}
					});
			}
			
		private void addPieChart()
			{
				Group root = new Group();
				java.util.List<PieChart.Data> dataset = new ArrayList<>();
				final Label caption = new Label("");
				caption.setTextFill(javafx.scene.paint.Color.DARKORANGE);
				caption.setStyle("-fx-font: 24 arial;");
				for (int i = 0; i < 10; i++)
					{
						PieChart.Data data = new PieChart.Data("i"+i, i * 10);
						Tooltip tooltip = new Tooltip(""+i * 10);
						Tooltip.install(data.getNode(), tooltip);
						dataset.add(data);
					}
				ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(dataset.toArray(new PieChart.Data[dataset.size()]));
				final PieChart chart = new PieChart(pieChartData);
				
				for (final PieChart.Data data : chart.getData())
					{
						data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
							{
								@Override
								public void handle(MouseEvent e)
									{
										caption.setTranslateX(e.getSceneX());
										caption.setTranslateY(e.getSceneY());
										caption.setText(String.valueOf(data.getPieValue()) + "%");
									}
							});
					}
				chart.setTitle("Imported Fruits");
				chart.setLabelLineLength(10);
				chart.setLegendSide(Side.LEFT);
				root.getChildren().add(chart);
				root.getChildren().add(caption);
				Scene scene = new Scene(root, javafx.scene.paint.Color.ALICEBLUE);
				jfxPanel.setScene(scene);
			}
			
	}
