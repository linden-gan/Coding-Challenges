package Integer;

import java.util.ArrayList;
import java.util.List;

public class PrimeAndGenerator {
    public static void main(String[] args) {
        System.out.println(findCycle(11, 2));
    }
    public static List<Long> findCycle(long prime, long gen) {
        List<Long> result = new ArrayList<>();
        long remainder = gen % prime;
        long pre = remainder;
        while (!result.contains(pre)) {
            result.add(pre);
            pre = (result.get(result.size() - 1) * remainder) % prime;
        }
        return result;
    }
}
