package com.gvt.application.screen.plugins;

import javax.swing.JComponent;

public class ScreenPlugin
	{
		public static void add(JComponent parent,JComponent child, int x, int y, int width, int height)
			{
				child.setBounds(x, y, width, height);
				parent.add(child);
			}
	}
