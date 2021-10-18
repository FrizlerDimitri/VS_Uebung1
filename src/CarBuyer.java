import java.util.Random;

public class CarBuyer implements Runnable {

	private Warehouse warehouse;
	private String buyerName;

	public CarBuyer(Warehouse warehouse, String buyerName) {

		this.warehouse = warehouse;
		this.buyerName = buyerName;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	@Override
	public void run() {

		Random random = new Random();
		while (true) {

			try {

				Thread.sleep(random.nextInt(30) * 1000);

				warehouse.removeLatestCarFromWarehouse(this);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
