import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final List<Photo> photos = new ArrayList<>();

    private static class Photo implements Comparable<Photo> {
        public int studentNo;
        public int index;
        public int count;

        public Photo(int studentNo, int index, int count) {
            this.studentNo = studentNo;
            this.index = index;
            this.count = count;
        }

        public void upCount() {
            count += 1;
        }

        @Override
        public int compareTo(Photo o) {
            if (count == o.count) {
                return index - o.index;
            }
            return count - o.count;
        }
    }

    private static int findIndexIfExist(int studentNo) {
        for (int i = 0; i < photos.size(); i++) {
            if (photos.get(i).studentNo == studentNo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < m; i++) {
            int studentNo = arr[i];

            //이미 photos에 있는지 확인
            int index = findIndexIfExist(studentNo);
            if (index >= 0) {
                //있으면 횟수 증가 -> continue
                Photo photo = photos.get(index);
                photo.upCount();
                continue;
            }

            if (photos.size() < n) {
                photos.add(new Photo(studentNo, i, 1));
                continue;
            }

            //없으면 최소 추천 사진 찾기
            Collections.sort(photos);
            //갱신
            photos.set(0, new Photo(studentNo, i, 1));

        }

        //결과 출력
        photos.stream()
            .mapToInt(photo -> photo.studentNo)
            .sorted()
            .forEach(num -> System.out.print(num + " "));
    }

}