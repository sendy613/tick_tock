package tick_tock;

public class Coordinates {

	public final static int radius = 225;
	public final static int clockMargin = 25;

	public int getX(int numOutOf60) {
		int degrees = numOutOf60 * 6;
		degrees -= 90;
		double radians = degrees * Math.PI / 180;
		double x = (radius + clockMargin) + (radius - 20) * Math.cos(radians);
		return (int) x;
	}

	public int getY(int numOutOf60) {
		int degrees = numOutOf60 * 6;
		degrees -= 90;
		double radians = degrees * Math.PI / 180;
		double y = (radius + clockMargin) + (radius - 20) * Math.sin(radians);
		return (int) y;
	}

	public int getHoursY(int numOutOf60) {
		int degrees = numOutOf60 * 6;
		degrees -= 90;
		double radians = degrees * Math.PI / 180;
		double x = (radius + clockMargin) + (radius - 100) * Math.sin(radians);
		return (int) x;
	}

	public int getHoursX(int numOutOf60) {
		int degrees = numOutOf60 * 6;
		degrees -= 90;
		double radians = degrees * Math.PI / 180;
		double x = (radius + clockMargin) + (radius - 100) * Math.cos(radians);
		return (int) x;
	}

}