package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MIN_SIZE = 2;

    private ArrayList<Car> cars;

    private Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(ArrayList<String> carNames){
        if (carNames.size() < MIN_SIZE){
            throw new IllegalArgumentException("최소 " + MIN_SIZE + "대 이상의 이름을 입력하세요.");
        }

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

    public void moveCars() {
        cars.forEach(car -> car.move());
    }

    public ArrayList<CarDTO> exportAsDTO() {
        return this.cars.stream()
                .map( car -> new CarDTO(car.getName(), car.getPosition()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<Car> toList() {
        return (List<Car>) cars;
    }

    @Override
    public String toString(){
        return this.cars.toString();
    }

}
