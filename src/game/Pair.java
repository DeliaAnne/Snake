package game;

import java.util.Objects;

public class Pair {
	int x;
	int y;
	
	Pair(int first, int second){
		this.y = second;
		this.x = first;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pair other = (Pair) obj;
		return this.x == other.x && this.y == other.y;
	}
	
}
