
public class Simulation {

	public static void main(String[] args) throws InterruptedException {

//		Parkhaus parkhaus = new Parkhaus(10);
//
//		for (int i = 1; i <= 10; i++) {
//			Thread t = new Thread(new Car("R-FH " + i, parkhaus));
//			t.setDaemon(true);
//			t.start();
//
//		}

		Warehouse warehouse = new Warehouse(10);

		Thread carProducer = new Thread(new CarProducer("BMW", warehouse));
		carProducer.setDaemon(true);
		carProducer.start();

		for (int i = 0; i < 5; i++) {
			Thread carbuyer = new Thread(new CarBuyer(warehouse, "Buyer " + (i + 1)));
			carbuyer.setDaemon(true);
			carbuyer.start();

		}

		Thread.sleep(60000);
		System.out.println("End of the simulation!");
	}

}
