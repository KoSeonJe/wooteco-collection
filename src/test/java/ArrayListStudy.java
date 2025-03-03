import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import collection.SimpleArrayList;
import collection.SimpleList;

public class ArrayListStudy {

    @Test
    public void arrayList() {
        ArrayList<String> values = new ArrayList<>();
        values.add("first");
        values.add("second");


        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    @Test
    public void simpleList() {
        SimpleList arrayList = new SimpleArrayList();
        arrayList.add("first");
        arrayList.add("second");
        arrayList.add(2, "second2");

        assertThat(arrayList.add("third")).isTrue(); // 세 번째 값을 추가한다..
        assertThat(arrayList.size()).isEqualTo(4); // list의 크기를 구한다.
        assertThat(arrayList.get(0)).isEqualTo("first");
        assertThat(arrayList.set(0, "newFirst")).isEqualTo("newFirst");
        assertThat(arrayList.contains("newFirst")).isTrue();
        assertThat(arrayList.indexOf("newFirst")).isEqualTo(0);
        assertThat(arrayList.indexOf("없음")).isEqualTo(-1);
        assertThat(arrayList.remove("newFirst")).isTrue();
        assertThat(arrayList.size()).isEqualTo(3);
        assertThat(arrayList.remove(0)).isEqualTo("second");

        arrayList.clear();
        assertThat(arrayList.size()).isEqualTo(0);


        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    @Test
    public void growTest() {
        SimpleList arrayList = new SimpleArrayList();

        assertThatCode(() -> {
            for (int i = 0; i < 100; i++) {
                arrayList.add("temp");
            }
        }).doesNotThrowAnyException();
        assertThat(arrayList.size()).isEqualTo(100);

        arrayList.add(0, "new");
        assertThat(arrayList.size()).isEqualTo(101);

        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
