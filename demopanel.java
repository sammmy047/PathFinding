import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
public class demopanel extends JPanel {
	// to set the screen dimensions i.e tiles or nodes
	final int maxcol = 15;
	final int maxrow = 10;
	final int tilesize = 80;
	final int screenWidth = tilesize*maxcol;
	final int screenHeight = tilesize*maxrow;
	tiles[][] tile = new tiles [maxcol][maxrow];
	tiles startile,currentile,goaltile;
	ArrayList<tiles>openList = new ArrayList<>();
	ArrayList<tiles>checkedList = new ArrayList<>();
	// other part
	boolean goalreached = false;
	
	
	public demopanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(maxrow,maxcol));
		this.addKeyListener(new KeyHandler(this));
		this.setFocusable(true);
		int col = 0;
		int row =0;
		while(col<maxcol && row<maxrow)
		{
			tile[col][row] = new tiles(col,row);
			this.add(tile[col][row]);
			col++;
			if(col==maxcol)
			{
				col=0;
				row++;
			}
		}
		// setting the start tile and goal tile#
		setstartile(4,5);
		setgoaltile(11,8);//
		
		//setting the solid tiles
		setsolidtile(10,2);
		setsolidtile(10,3);
		setsolidtile(10,4);
		setsolidtile(10,5);
		setsolidtile(10,6);
		setsolidtile(10,7);
		setsolidtile(10,8);
		setsolidtile(11,5);
		setsolidtile(6,2);
		setsolidtile(7,2);
		setsolidtile(9,2);
		setsolidtile(11,7);
		setsolidtile(12,2);
		setsolidtile(6,1);
		setsolidtile(8,2);
		//setting costs on each tile
		setcostontile();
		
		
	}
	private void setstartile(int col, int row)
	{
		tile[col][row].setstart();
		startile = tile[col][row];
		currentile = startile;
		
	}
	private void setgoaltile(int col, int row)
	{
		tile[col][row].setgoal();
		goaltile = tile[col][row];
		
	}
	
    private void setsolidtile(int col, int row)  
    {
    	tile[col][row].setsolid();
    	}
    private void setcostontile()
    {
    	int col=0;
    	int row=0;
    	while(col<maxcol && row<maxrow)
    	{
    		getcost(tile[col][row]);
    		col++;
    		if(col==maxcol)
    		{
    			col=0;
    			row++;
    		}
    	}
    }
    private void getcost(tiles tile)
    {   //Math.abs function is used to get the absolute value between tiles. It takes the modulus of the result to give a positive value 
    	int xDistance= Math.abs(tile.col - startile.col);// distance between the tiles in x-coordinate
    	int yDistance = Math.abs(tile.row - startile.row);// distance between the tiles in y-coordinate
    	tile.gcost=xDistance+yDistance;
    	// H cost between nodes
    	 xDistance= Math.abs(tile.col - goaltile.col);
    	 yDistance = Math.abs(tile.row - goaltile.row);
    	tile.hcost=xDistance+yDistance;
    	//F cost between nodes
    	tile.fcost= tile.gcost+tile.hcost;
    	//displaying the cost on tiles
    	if(tile!=startile && tile!=goaltile)
    	{
    		tile.setText("<html>F:"+ tile.fcost+"<br>G:"+ tile.gcost+"</html>");// we use html tags for introducing white spaces
    	}
    }
    public void search() {
    	if(goalreached==false)
    	{
    		int col = currentile.col;
    		int row = currentile.row;
    		currentile.setchecked();
    		checkedList.add(currentile);
    		openList.remove(currentile);
    		//search the tiles above,below,left and right of the start(current) tile
    		if(row-1>=0)//we use if statement if the tile is at the top row where it can't go up anymore
    		{
    	     	opentile(tile[col][row-1]);//searches or opens the tile above the current tile
    		}
    		if(col-1>=0) {  // if tile is at leftmost position it can't go any more to left 
    		   opentile(tile[col-1][row]); //opens the tile to the left of the current tile
    		}
    		if(row+1<maxrow) {
    		opentile(tile[col][row+1]);//opens the tile to the bottom of the current tile
    		}
    		if(col+1<maxcol) {
    		opentile(tile[col+1][row]);
    	}
    		// Finding the best tiles
    		int bestileindex = 0;
    		int bestilefcost=999;
    		for(int i=0;i< openList.size();i++)
    		{
    			//checking if this node's F cost is best or better
    			if(openList.get(i).fcost< bestilefcost) {
    				bestileindex=i;
    			    bestilefcost= openList.get(i).fcost;
    		}
    		//if the f cost is same then we compare the g cost
    		else if(openList.get(i).fcost== bestilefcost) {
    			if(openList.get(i).gcost< openList.get(bestileindex).gcost) {
    				bestileindex= i;
    			}
    			
    		}
    			
    	}
    		//after the loop we get the best tile which is our next optimal step
    		currentile = openList.get(bestileindex);
    		if(currentile == goaltile)
    		{
    			goalreached = true;
    			trackpath();// this the last method which is used to backtrack and find the shortest path
    		}
    }
  }
    private void opentile(tiles tile)
    {
    	if(tile.open==false && tile.checked==false && tile.solid==false)
    	{
    		//if the tile has not been checked yet then we add it to the open list 
    		tile.setopen();
    		tile.parent = currentile;
    		openList.add(tile);
    	}
    }
    private void trackpath()
    {
    	tiles current =goaltile;
    	while(current!= startile)
    	{
    		current = current.parent;
    		if(current!=startile)
    		{
    			current.setpath();
    		}
    	}
    }
}
