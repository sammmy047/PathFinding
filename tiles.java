import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class tiles extends JButton implements ActionListener{

	
	 tiles parent;
	 int col;
	 int row;
	 int gcost;// gcost is the cost between the start tile and current tile
	 int hcost; // hcost is the cost between the current tile and goal tile
	 int fcost; // fcost is the sum of hcost and gcost
	 boolean start ;
	 boolean goal;
	 boolean open;
	 boolean checked;
	 boolean solid;
	 
	 public tiles(int col,int row)
	 {
		 this.col=col;
		 this.row=row;
		 setBackground(Color.white);
		 setForeground(Color.black);
		 addActionListener(this);
		 
	 }
	 public void setstart(){
		 setBackground(Color.blue);
		 setForeground(Color.white);
		 setText("Start");
		 start= true;
		 }
	 public void setgoal(){
		 setBackground(Color.yellow);
		 setForeground(Color.black);
		 setText("Goal");
		 goal= true;
	 }
	 public void setsolid()
	 {
		 setBackground(Color.black);
		 setForeground(Color.black);
		 solid=true;
	 }
	 public void setopen()
	 {
		 open = true;
		 
	 }
	 public void setchecked()
	 { 
		 if(start==false && goal==false)
		 {
			 setBackground(Color.red);
			 setForeground(Color.black);
		 }
		 checked=true;
	 }
	 public void setpath()
	 {
		 setBackground(Color.green);
		 setForeground(Color.black);
	 }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 setBackground(Color.red);
	}

	


}
