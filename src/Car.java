import java.util.Random;

public class Car implements Runnable {

	private final String CAR_ID;
	private int maxDriveTimeInSec = 10;
	Parkhaus parkhaus;
	private boolean isInParkhaus = false;
	private CarProducer carProducer;

	public Car(String carID, Parkhaus parkhaus) {
		this.CAR_ID = new String(carID);
		this.parkhaus = parkhaus;
	}

	public Car(String carID, CarProducer carProducer) {
		this.CAR_ID = new String(carID);
		this.carProducer = carProducer;
	}

	public int getMaxDriveTimeInSec() {
		return maxDriveTimeInSec;
	}

	public void setMaxDriveTimeInSec(int maxDriveTimeInSec) {
		this.maxDriveTimeInSec = maxDriveTimeInSec;
	}

	public Parkhaus getParkhaus() {
		return parkhaus;
	}

	public void setParkhaus(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}

	public boolean isInParkhaus() {
		return isInParkhaus;
	}

	public void setInParkhaus(boolean isInParkhaus) {
		this.isInParkhaus = isInParkhaus;
	}

	public String getCAR_ID() {
		return CAR_ID;
	}

	public CarProducer getCarProducer() {
		return carProducer;
	}

	public void setCarProducer(CarProducer carProducer) {
		this.carProducer = carProducer;
	}

	@Override
	public void run() {

		while (true) {

			Random random = new Random();

			try {

				Thread.sleep(random.nextInt(10) * 1000);

				if (!isInParkhaus) {

					parkhaus.tryToDriveIn(this);

				} else {

					parkhaus.driveOut(this);
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
