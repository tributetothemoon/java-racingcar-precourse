/**
 * RaicingCarGame.java
 * 경주가 진행되는 도중의 로직을 관장하는 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */

package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Turn;

public class RaicingCarGame {
    private final Cars cars;
    private final Turn turn;

    private RaicingCarGame(Cars cars, Turn turn) {
        this.cars = cars;
        this.turn = turn;
    }

    public static RaicingCarGame createNewGame(Cars cars, Turn turn) {
        return new RaicingCarGame(cars, turn);
    }

    public void play() {
        // 게임 실행 로직
        while (!turn.isEnd()) {
            cars.moveCars();
            turn.turnOver();
        }
    }
}
