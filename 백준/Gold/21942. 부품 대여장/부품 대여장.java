import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, LocalDateTime> REPORT = new HashMap<>();
    private static final Map<String, Long> RESULT = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int minutes = calculateMinutes(input[1]);
        int price = Integer.parseInt(input[2]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            LocalDateTime dateTime = createDateTimeBy(line);
            String product = line[2];
            String nickname = line[3];
            String key = nickname + "-" + product;
            if (!REPORT.containsKey(key)) {
                REPORT.put(key, dateTime.plusMinutes(minutes));
                continue;
            }

            LocalDateTime returnDateTime = REPORT.get(key);
            //반납 일자 지남
            if (returnDateTime.isBefore(dateTime)) {
                long diff = calculateMinutes(dateTime, returnDateTime) * price;
                RESULT.put(nickname, RESULT.getOrDefault(nickname, 0L) + diff);
            }
            REPORT.remove(key);
        }

        if (RESULT.isEmpty()) {
            System.out.println(-1);
            return;
        }

        RESULT.keySet().stream()
            .sorted()
            .forEach(key -> System.out.println(key + " " + RESULT.get(key)));
    }

    private static int calculateMinutes(String str) {
        String[] split = str.split("/");
        int days = Integer.parseInt(split[0]);
        int hours = Integer.parseInt(split[1].split(":")[0]);
        int minutes = Integer.parseInt(split[1].split(":")[1]);
        return days * 24 * 60 + hours * 60 + minutes;
    }

    private static LocalDateTime createDateTimeBy(String[] line) {
        LocalDate date = LocalDate.parse(line[0]);
        LocalTime time = LocalTime.parse(line[1]);
        return LocalDateTime.of(date, time);
    }

    private static long calculateMinutes(LocalDateTime dateTime, LocalDateTime returnDateTime) {
        return Duration.between(returnDateTime, dateTime).toMinutes();
    }
}



