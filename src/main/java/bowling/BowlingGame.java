package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {

    private ArrayList<Integer> rolls = new ArrayList<>();

    public void roll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int calculateScore() {
        return sumUpScore(rolls, 1);
    }

    private int sumUpScore(List<Integer> rolls, int frame) {
        if (rolls.isEmpty()) {
            return 0;
        }
        if (isSpare(rolls)) {
            return sumNext(3, rolls) + sumUpScore(removeFirst(2, rolls), frame + 1);
        }
        if (isStrike(rolls)) {
            if (frame == 10) {
                return sumNext(3, rolls);
            } else {
                return sumNext(3, rolls) + sumUpScore(removeFirst(1, rolls), frame + 1);
            }
        }
        return sumNext(2, rolls) + sumUpScore(removeFirst(2, rolls), frame + 1);
    }

    private boolean isSpare(List<Integer> rolls) {
        return (rolls.size() >= 2) && (rolls.get(0) < 10) && (rolls.get(0) + rolls.get(1) == 10);
    }

    private boolean isStrike(List<Integer> rolls) {
        return rolls.get(0) == 10;
    }

    private int sumNext(int count, List<Integer> rolls) {
        return rolls.stream().limit(count).mapToInt(Integer::intValue).sum();
    }

    private List<Integer> removeFirst(int toRemove, List<Integer> rolls) {
        return rolls.stream().skip(toRemove).collect(Collectors.toList());
    }
}
