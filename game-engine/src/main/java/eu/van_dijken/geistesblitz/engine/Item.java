package eu.van_dijken.geistesblitz.engine;


public enum Item {
    Ghost (Colour.White),
    Chair (Colour.Red),
    Bottle (Colour.Green),
    Book (Colour.Blue),
    Mouse (Colour.Grey);
    
    private Colour color;
    
	private Item(Colour color) {
		this.color = color;
	}

	public Colour color() {
		return color;
	}
	
    public Colour getColor() {
        return color;
    }

    public Shape getType() {
        return Shape.valueOf(this.name());
    }

    public boolean matches(Item that) {
        return (this == that);    }
	
}
