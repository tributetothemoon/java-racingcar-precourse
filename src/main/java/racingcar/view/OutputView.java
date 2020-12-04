package racingcar.view;

import racingcar.domain.CarDTO;

import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final String WINNERS_LIST = "최종 우승자 : ";

    public static void showErrorMessage(String message){
        System.out.println(ERROR_PREFIX + message);
    }

    public static void showCarsPosition(List<CarDTO> carsDTO) {
        carsDTO.forEach(OutputView::showCarPosition);
        System.out.println();
    }

    private static void showCarPosition(CarDTO carDTO) {
        System.out.print(carDTO.getName() + " : ");
        IntStream.range(0, carDTO.getPosition())
                .forEach(i -> System.out.print('-'));
        System.out.println();
    }

    public static void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void showWinners(List<String> winners) {
        System.out.print(WINNERS_LIST);
        Iterator<String> iterator = winners.iterator();
        System.out.print(iterator.next());
        while(iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
    }
}
