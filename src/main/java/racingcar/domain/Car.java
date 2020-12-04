package racingcar.domain;

import utils.RandomUtils;

public class Car implements Comparable<Car>{
    private static final int MAX = 5;
    private static final int MIN_SEED = 0;
    private static final int MAX_SEED = 9;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public static Car from(String name) {
        isValidLengthOrThrowException(name);
        return new Car(name);
    }

    public static boolean isValidLengthOrThrowException(String string) {
        if (string.length() > MAX) {
            throw new IllegalArgumentException("이름의 길이는 " + MAX + "자를 넘어가서는 안 됩니다.");
        }
        return true;
    }

    void move() {
        int randomNumber = RandomUtils.nextInt(MIN_SEED, MAX_SEED);
        if (4 < randomNumber) {
            this.position++;
        }
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
