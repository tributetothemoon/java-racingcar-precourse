/**
 * Car.java
 * 자동차 클래스
 *
 * @author
 * 원작자: 우아한 테크코스(github.com/woowacourse)
 * 수정: Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        isValidLengthOrThrowException(name);
        return new Car(name);
    }

    public static boolean isValidLengthOrThrowException(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘어가서는 안 됩니다.");
        }
        return true;
    }

    void move() {
        if (DecisionMaker.makeDecision()) {
            this.position++;
        }
    }

    public CarDTO toDTO() {
        return new CarDTO(this.name, this.position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car paramObj = (Car) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
