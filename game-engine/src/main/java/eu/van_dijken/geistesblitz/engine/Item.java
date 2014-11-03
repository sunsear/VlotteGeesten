package eu.van_dijken.geistesblitz.engine;


public enum Item {
    Ghost (Color.White),
    Chair (Color.Red),
    Bottle (Color.Green),
    Book (Color.Blue),
    Mouse (Color.Gray);
    
    private Color color;
    
	private Item(Color color) {
		this.color = color;
	}

	public Color color() {
		return color;
	}
	
    public Color getColor() {
        return color;
    }

}
