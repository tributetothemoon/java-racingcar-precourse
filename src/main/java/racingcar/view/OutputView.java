package racingcar.view;

public class OutputView {
    private static final String ErrorPrefix = "[ERROR] ";

    public static void showErrorMessage(String message){
        System.out.println(ErrorPrefix + message);
    }

}
