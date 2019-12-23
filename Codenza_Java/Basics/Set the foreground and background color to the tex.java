Set the foreground and background color to the text area

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

class colopat extends Frame
{
	Checkbox r,g,b;
	Checkbox m,y,gr,p,w,bl,c;
	TextArea ta;
	Checkbox r1,g1,b1;
	Checkbox m1,y1,gr1,p1,w1,bl1,c1;
	Label ba,fo;
	Panel pa1,p2,p3;

	colopat()
	{
		setSize(800,600);

		setLayout(new BorderLayout());
		pa1=new Panel(new GridLayout(5,2,10,10));
		p2=new Panel(new GridLayout(5,2,10,10));

		CheckboxGroup cbg=new CheckboxGroup();

		r=new Checkbox("red",cbg,false);
		g=new Checkbox("green",cbg,false);
		b=new Checkbox("blue",cbg,false);
		m=new Checkbox("megenta",cbg,false);
		y=new Checkbox("yellow",cbg,false);
		gr=new Checkbox("grey",cbg,false);
		p=new Checkbox("pink",cbg,false);
		w=new Checkbox("white",cbg,false);
		bl=new Checkbox("black",cbg,true);
		c=new Checkbox("cyan",cbg,false);
		ba=new Label("BACKGROUND COLORS",Label.CENTER);
		ba.setBackground(Color.pink);

		pa1.add(ba);
		pa1.add(r);
		pa1.add(b);
		pa1.add(m);
		pa1.add(y);
		pa1.add(gr);
		pa1.add(p);
		pa1.add(w);
		pa1.add(bl);
		pa1.add(c);
		add("West",pa1);

		ta=new TextArea(5,25);
		p3=new Panel(new GridLayout(3,1));
		p3.add(new Label("Text Area",1));
		p3.add(ta);
		add("Center",p3);

		r.addItemListener(new CheckBoxHandler(this));
		g.addItemListener(new CheckBoxHandler(this));
		b.addItemListener(new CheckBoxHandler(this));
		m.addItemListener(new CheckBoxHandler(this));
		y.addItemListener(new CheckBoxHandler(this));
		gr.addItemListener(new CheckBoxHandler(this));
		p.addItemListener(new CheckBoxHandler(this));
		w.addItemListener(new CheckBoxHandler(this));
		c.addItemListener(new CheckBoxHandler(this));
		bl.addItemListener(new CheckBoxHandler(this));

		CheckboxGroup cbg1=new CheckboxGroup();
		r1=new Checkbox("red",cbg1,false);
		g1=new Checkbox("green",cbg1,false);
		b1=new Checkbox("blue",cbg1,false);
		m1=new Checkbox("megenta",cbg1,false);
		y1=new Checkbox("yellow",cbg1,false);
		gr1=new Checkbox("grey",cbg1,false);
		p1=new Checkbox("pink",cbg1,false);
		w1=new Checkbox("white",cbg1,false);
		bl1=new Checkbox("black",cbg1,true);
		c1=new Checkbox("cyan",cbg1,false);
		fo=new Label("FOREGROUND COLORS");
		fo.setBackground(Color.pink);

		p2.add(fo);
		p2.add(c1);
		p2.add(g1);
		p2.add(b1);
		p2.add(m1);
		p2.add(y1);
		p2.add(gr1);
		p2.add(p1);
		p2.add(w1);
		p2.add(bl1);
		p2.add(c1);
		add("East",p2);

		r1.addItemListener(new CheckBoxHandler(this));
		g1.addItemListener(new CheckBoxHandler(this));
		b1.addItemListener(new CheckBoxHandler(this));
		m1.addItemListener(new CheckBoxHandler(this));
		y1.addItemListener(new CheckBoxHandler(this));
		gr1.addItemListener(new CheckBoxHandler(this));
		p1.addItemListener(new CheckBoxHandler(this));
		w1.addItemListener(new CheckBoxHandler(this));
		c1.addItemListener(new CheckBoxHandler(this));
		bl1.addItemListener(new CheckBoxHandler(this));
		c1.addItemListener(new CheckBoxHandler(this));

		addWindowListener(new mywindowAdapter(this));

		setVisible(true);
	}

	public static void main(String args[])
	{
		new colopat();
	}
}

class CheckBoxHandler implements ItemListener
{
 colopat cp;

CheckBoxHandler(colopat cp)
{
 this.cp=cp;
}
public void itemStateChanged(ItemEvent ie)
{
if(cp.r.getState())
cp.ta.setBackground(Color.red);
else if(cp.g.getState())
cp.ta.setBackground(Color.green);
else if(cp.b.getState())
cp.ta.setBackground(Color.blue);
else if(cp.m.getState())
cp.ta.setBackground(Color.magenta);
else if(cp.y.getState())
cp.ta.setBackground(Color.yellow);
else if(cp.gr.getState())
cp.ta.setBackground(Color.lightGray);
else if(cp.bl.getState())
cp.ta.setBackground(Color.black);
else if(cp.w.getState())
cp.ta.setBackground(Color.white);
else if(cp.p.getState())
cp.ta.setBackground(Color.pink);
else
cp.ta.setBackground(Color.cyan);


if(cp.r1.getState())
cp.ta.setForeground(Color.red);
else if(cp.g1.getState())
cp.ta.setForeground(Color.green);
else if(cp.b1.getState())
cp.ta.setForeground(Color.blue);
else if(cp.m1.getState())
cp.ta.setForeground(Color.magenta);
else if(cp.y1.getState())
cp.ta.setForeground(Color.yellow);
else if(cp.gr1.getState())
cp.ta.setForeground(Color.lightGray);
else if(cp.bl1.getState())
cp.ta.setForeground(Color.black);
else if(cp.w1.getState())
cp.ta.setForeground(Color.white);
else if(cp.p1.getState())
cp.ta.setForeground(Color.pink);
else
cp.ta.setForeground(Color.cyan);
}
}

class mywindowAdapter extends WindowAdapter
{
 colopat cp;

mywindowAdapter(colopat cp)
{
 this.cp=cp;
}
public void windowClosing(WindowEvent e)
{
  System.exit(0);
}
}
