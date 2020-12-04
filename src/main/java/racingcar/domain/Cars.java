package racingcar.domain;

import javax.management.ListenerNotFoundException;
import java.util.ArrayList;

public class Cars {
    private ArrayList<Car> cars;

    private Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(ArrayList<String> carNames){
        ArrayList<Car> cars = new ArrayList<>();
        carNames.stream()
                .map(Car::from)
                .filter( i -> isNotContainsOrThrowException(cars, i))
                .forEach(cars::add);
        return new Cars(cars);
    }

    private static boolean isNotContainsOrThrowException(ArrayList<Car> destination, Car car) {
        if (destination.contains(car)){
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
        return true;
    }

    @Override
    public String toString(){
        return this.cars.toString();
    }

}
