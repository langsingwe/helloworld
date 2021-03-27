package head_first设计模式.ch12;

/**
 * @Description
 * @ClassName DuckSimulator
 * @Author weilc
 * @Date 2021-01-29
 * @Version 1.0
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CoutingDuckFactory();

        duckSimulator.simulator(duckFactory);
    }

    void simulator(AbstractDuckFactory duckFactory) {
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("\nDuck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();

        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();
        flockOfMallards.add(mallardDuck1);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);

        flockOfDucks.add(flockOfMallards);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulator(flockOfDucks);

        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
        simulator(flockOfMallards);

        System.out.println("\nDuck Simulator: With Observer");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);
        simulator(flockOfDucks);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulator(Quackable duck) {
        duck.quack();
    }
}
