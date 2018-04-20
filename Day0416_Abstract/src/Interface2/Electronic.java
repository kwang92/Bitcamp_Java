package Interface2;

public abstract class Electronic implements RemoteController{
	public int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public abstract void work();
	
}
