
public class World {

	 int _size;
	 int _colsize;
		
	    /**
	     * The world, a 2D array of Cells which can be living or dead.
	     */
		
	    Cell[][] _world;
		
	    private State generateInitialState(int val) {
	    	
	    	State toReturn = State.DEAD;
	    	if (val==1){
	    		toReturn=State.ALIVE;
	    	}
	    	return toReturn;
	        }
	    
		
	    public Cell[][] generate(int[][] cells, int size, int csize){
	    	Cell[][] world = new Cell[size][csize];
	    	for(int i=0;i<size; i++){
	    		for(int j=0;j<csize; j++){
	    			world[i][j]=new Cell(generateInitialState(cells[i][j]), i, j);
	    		}
	    	}
	    	return world;
	    	
	    }
		
	    
		
	   
	    /**
	     * Iterated (non-initial) world constructor.
	     * @param cells Cells living in the new world
	     * @param rng Random number generator
	     */
		
	    public World(int[][] cells, int rsize, int csize) {
		_size = rsize;
		_colsize=csize;
		_world=generate(cells, rsize, csize);
	    }
		
	    /**
	     
		
	    /**
	     * The number of living neighbors that a cell has.
	     * @param world the world
	     * @param x x location of cell
	     * @param y y location of cell
	     * @return
	     */
		
	    private int getNumNeighbors(Cell[][] world, int x, int y) {
		int size = world.length;
		int leftX = (x - 1) % size;
		int rightX = (x + 1) % size;
		int upY = (y - 1) % size;
		int downY = (y + 1) % size;

		for (int j = 0; j < 10000; j++) {
		    if (leftX == -1) { leftX = size - 1; }
		    if (rightX == -1) { rightX = size - 1; }
		    if (upY == -1) { upY = size - 1; }
		    if (downY == -1) { downY = size - 1; }
		}
			
		int numNeighbors = 0;
		if (world[leftX][upY].isAlive())    { numNeighbors++; }
		if (world[leftX][downY].isAlive())  { numNeighbors++; }
		if (world[leftX][y].isAlive())      { numNeighbors++; }
		if (world[rightX][upY].isAlive())   { numNeighbors++; }
		if (world[rightX][downY].isAlive()) { numNeighbors++; }
		if (world[rightX][y].isAlive())     { numNeighbors++; }
		if (world[x][upY].isAlive())        { numNeighbors++; }
		if (world[x][downY].isAlive())      { numNeighbors++; }
		
		return numNeighbors;
	    }
		
	    private int getNumNeighbors2(Cell[][] world, int x, int y) {
	    	int numNeighbors=0;
	    	int size = world.length;
	    	int cosize=world[0].length;
			if(x-1>=0 && y-1>=0){
				if (world[x-1][y-1].isAlive())    { numNeighbors++; }
			}
			if(x-1>=0){
				if (world[x-1][y].isAlive())    { numNeighbors++; }
			}
			if(x-1>=0 && y+1<cosize){
				if (world[x-1][y+1].isAlive())    { numNeighbors++; }
			}
			
			if(y-1>=0){
				if (world[x][y-1].isAlive())    { numNeighbors++; }
			}
			if(y+1<cosize){
				if (world[x][y+1].isAlive())    { numNeighbors++; }
			}
			if(x+1<size && y-1>=0){
				if (world[x+1][y-1].isAlive())    { numNeighbors++; }
			}
			if(x+1<size){
				if (world[x+1][y].isAlive())    { numNeighbors++; }
			}
			if(x+1<size && y+1<cosize){
				if (world[x+1][y+1].isAlive())    { numNeighbors++; }
			}
			
	    			
	    	return numNeighbors;
	    }
	    /**
	     * Go through one iteration of this World and return new World.
	     * @return New world
	     */
	    public World(Cell[][] cells) {
	    	_size=cells.length;
	    	_colsize=cells[0].length;
	    	
	    	_world = cells;
	    }
		
	    public World iterate() {
		Cell[][] newCells = new Cell[_size][_colsize];
		for (int j = 0; j < _size; j++ ) {
		    for (int k = 0; k < _colsize; k++) {
			newCells[j][k] = new Cell(_world[j][k].iterate(getNumNeighbors2(_world, j, k)), j, k);
		    }
		}
		return new World(newCells);
	    }

	    /**
	     * Convert this World to a string for display.
	     * @return String representation of world
	     */
		
	    public String toString() {

		StringBuilder toReturn = new StringBuilder();
		toReturn.append("  ");
		for (int j= 0; j < _size; j++) {
		    toReturn.append(j % 10);
		}
		toReturn.append("\n");
		for (int j = 0; j < _size; j++ ) {
		    toReturn.append((j % 10) + " ");
		    for (int k = 0; k < _colsize; k++) {
			toReturn.append(_world[j][k].getStateRep());
		    }
		    toReturn.append("\n");
		}
		return toReturn.toString();
	    }
		
	   
		
	   
		
	}