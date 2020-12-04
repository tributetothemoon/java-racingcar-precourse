package racingcar;

import racingcar.controller.RaicingCarGame;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행
        InputView.setScanner(scanner);

        Cars cars = getCarNamesFromUser();
        int tryNumber = getTryNumberFromUser();
        RaicingCarGame raicingCarGame = new RaicingCarGame(cars, tryNumber);
        raicingCarGame.play();

    }

    private static Cars getCarNamesFromUser(){
        try {
            return Cars.of(InputView.getCarNames());
        } catch (IllegalArgumentException e) {
            OutputView.showErrorMessage(e.getMessage());
            return getCarNamesFromUser();
        }
    }

    private static int getTryNumberFromUser() {
        return InputView.getTryNumber();
    }
}

