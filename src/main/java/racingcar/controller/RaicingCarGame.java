package racingcar.controller;

import racingcar.domain.Cars;

public class RaicingCarGame {
    private final Cars cars;
    private final int endTurn;
    private int currentTurn = 0;

    public RaicingCarGame(Cars cars, int endTurn) {
        this.cars = cars;
        this.endTurn = endTurn;
    }

    public void play() {
        while (!isEnd()) {
            // Play Logic
            cars.moveCars();

            nextTurn();
        }
    }

    public boolean isEnd() {
        return !(currentTurn < endTurn);
    }

    public void nextTurn() {
        this.currentTurn++;
    }

}
