package exam1;

public class ColorTV extends TV {
	
	private int color;
	
	public ColorTV(int size, int color) {
		super(size);
		this.color = color;
	}

	void printProperty() {
		System.out.println(getSize()+"인치 "+getColor()+"컬러");
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	

}
