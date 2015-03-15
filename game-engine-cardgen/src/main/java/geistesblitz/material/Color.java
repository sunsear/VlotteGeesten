package geistesblitz.material;

import java.util.ArrayList;
import java.util.Arrays;

public enum Color {
    White,
    Red,
    Blue,
    Gray,
    Green;

	public static Color aRandomOneThatIsnt(Color... skipColors) {
		ArrayList<Color> colors = colorsMinus(skipColors);
		return colors.get((int) Math.round(-0.5 + Math.random() * colors.size()));
	}

	private static ArrayList<Color> colorsMinus(Color... skipColors) {
		ArrayList<Color> colors = new ArrayList<Color>(Arrays.asList(Color.values()));
		for (int i = 0; i < skipColors.length; i++) {
			colors.remove(skipColors[i]);
		}
		return colors;
	}
}
