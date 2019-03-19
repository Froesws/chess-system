package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException ("Error creating board: There must be  at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece [rows][columns];
	}

	public int getRows() {
		return rows;
	}

	

	public int getColumns() {
		return columns;
	}

	
	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException ("Position not on the Board");
			
		}
		return this.pieces[row][column];
	}
	
	public Piece piece(Position pos) {
		if (!positionExists(pos)) {
			throw new BoardException ("Position not on the Board");
		}
		return this.pieces[pos.getRow()][pos.getColumn()];
		
	}
	
	public void placePiece (Piece piece, Position pos) {
		if (thereIsAPiece(pos) ) {
			throw new BoardException ("There Is Already a Piece on position:" + pos);
			
		}
		pieces[pos.getRow()][pos.getColumn()] = piece;
		piece.position = pos;
		
	}
	private boolean positionExists (int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	public boolean positionExists (Position position) {
		return positionExists (position.getRow(), position.getColumn());
		
	}
	
	public boolean thereIsAPiece (Position position) {
		if (!positionExists(position)) {
			throw new BoardException ("Position not on the Board");
			
		}
		return piece(position) != null; 		
	}

}