package org.yl;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class AppletTest extends Applet{
	private static final long serialVersionUID = 1L;

	
	public void paint(Graphics g){
		g.drawString(getParameter("hello"), 20,30);
		g.setColor(new Color(255,200,200));
		g.fillRect(50,60,200,150);
	}
}
  