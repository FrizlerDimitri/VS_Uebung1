import java.util.concurrent.atomic.AtomicInteger;

public class Parkhaus {

	private AtomicInteger currentFreePlaces;
	private AtomicInteger maxPlaces;

	public Parkhaus(int maxPlaces) {

		this.currentFreePlaces = new AtomicInteger(maxPlaces);
		this.maxPlaces = new AtomicInteger(maxPlaces);
	}

	public AtomicInteger getCurrentFreePlaces() {
		return currentFreePlaces;
	}

	public void setCurrentFreePlaces(AtomicInteger currentFreePlaces) {
		this.currentFreePlaces = currentFreePlaces;
	}

	public AtomicInteger getMaxPlaces() {
		return maxPlaces;
	}

	public void setMaxPlaces(AtomicInteger maxPlaces) {
		this.maxPlaces = maxPlaces;
	}

	public void tryToDriveIn(Car car) {

		synchronized (currentFreePlaces) {

			if (currentFreePlaces.get() - 1 >= 0) {

				currentFreePlaces.addAndGet(-1);
				car.setInParkhaus(true);
				driveIn(car);

			} else {
				waitBeforeParkhaus(car);
			}

		}

	}

	public void driveIn(Car car) {
		synchronized (currentFreePlaces) {
			System.out
					.println("Drive in : " + car.getCAR_ID() + "   currently free places : " + currentFreePlaces.get());
		}
	}

	public void driveOut(Car car) {

		synchronized (currentFreePlaces) {

			if (currentFreePlaces.get() + 1 < maxPlaces.get() && (maxPlaces.get() - currentFreePlaces.get()) - 1 >= 2) {
				currentFreePlaces.addAndGet(1);

				car.setInParkhaus(false);
				System.out.println(
						"Drive out : " + car.getCAR_ID() + "   currently free places : " + currentFreePlaces.get());
			} else {
				System.out.println("Atleast 2 cars must remain ! : " + car.getCAR_ID() + "   currently free places : "
						+ currentFreePlaces.get());
			}

		}

	}

	public void waitBeforeParkhaus(Car car) {
		synchronized (currentFreePlaces) {
			System.out.println(
					"Wait in front : " + car.getCAR_ID() + "   currently free places : " + currentFreePlaces.get());
		}
	}

}
