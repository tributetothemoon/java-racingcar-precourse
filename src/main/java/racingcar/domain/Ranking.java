package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Ranking {
    private final PriorityQueue<Car> ranking;

    private Ranking(PriorityQueue<Car> ranking) {
        this.ranking = ranking;
    }

    public static Ranking from(Cars cars) {
        PriorityQueue<Car> ranking = new PriorityQueue<>(Collections.reverseOrder());
        cars.toList().forEach(ranking::offer);
        return new Ranking(ranking);
    }

    public List<String> getWinner() {
        ArrayList<String> winners = new ArrayList<>();
        Car temporalWinner = ranking.poll();
        winners.add(temporalWinner.getName());
        while(ranking.peek().getPosition() == temporalWinner.getPosition()) {
            winners.add(ranking.poll().getName());
        }
        return winners;
    }

    @Override
    public String toString() {
        return ranking.toString();
    }

}
