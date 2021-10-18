import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {

	private final AtomicInteger MAX_PLACES;
	private final Deque<Car> PLACES;

	public Warehouse(int maxPlaces) {

		MAX_PLACES = new AtomicInteger(maxPlaces);
		PLACES = new LinkedList<Car>();

	}

	public void addCarToWarehouse(Car car) {

		synchronized (PLACES) {

			if (PLACES.size() + 1 < MAX_PLACES.get()) {

				PLACES.addLast(car);

				System.out.println("Car : " + car.getCAR_ID() + " added " + " free places left : "
						+ (MAX_PLACES.get() - PLACES.size()));

			} else {
				System.out.println("No room left for the car !");

			}

		}

	}

	public void removeLatestCarFromWarehouse(CarBuyer carbuyer) {

		synchronized (PLACES) {

		
			
			if(PLACES.size()>0)
			{
				String carId = PLACES.getFirst().getCAR_ID();
				PLACES.removeFirst();
				System.out.println("Removed car : " + carId + " by " + carbuyer.getBuyerName() + " From Warehouse.");
			}else {
				System.out.println("Nothing to buy !");
			}


		}

	}

}
