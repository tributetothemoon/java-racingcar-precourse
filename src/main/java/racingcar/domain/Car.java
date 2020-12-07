/**
 * Car.java
 * 자동차 객체를 생성하는 클래스
 *
 * @author 원작자: 우아한 테크코스(github.com/woowacourse)
 * 수정: Kimun Kim, github.com/tributetothemoon
 */

package racingcar.domain;

import utils.RandomUtils;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_SEED = 0;
    private static final int MAX_SEED = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
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
        int randomNumber = RandomUtils.nextInt(MIN_SEED, MAX_SEED);
        if (MOVE_THRESHOLD <= randomNumber) {
            this.position++;
        }
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
    public String toString() {
        return String.format("%s@name: %s, position: %d", this.getClass().toString(), this.name, this.position);
    }
}
