import java.util.Random;

public class CarProducer implements Runnable {

	private static int carId = 0;

	private String name;
	private Warehouse warehouse;

	public CarProducer(String name, Warehouse warehouse) {
		this.name = name;
		this.warehouse = warehouse;
	}

	public static int getCarId() {
		return carId;
	}

	public static void setCarId(int carId) {
		CarProducer.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {

		while (true) {

			Random random = new Random();

			try {

				Thread.sleep(random.nextInt(10) * 1000);

				Car car = new Car("Rg - OTH " + (++carId), this);

				warehouse.addCarToWarehouse(car);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
