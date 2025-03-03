import static org.assertj.core.api.Assertions.assertThat;

import generic.SimpleArrayList;
import generic.SimpleList;
import org.junit.jupiter.api.Test;

public class GenericArrayListTest {


    @Test
    public void simpleList() {
        SimpleList<String> arrayList = new SimpleArrayList<>();
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
    public void simpleList2() {
//        SimpleList<String> arrayList = new SimpleArrayList<>();
//        arrayList.add("first");
//        arrayList.add("second");

        final String[] arrays = {"first", "second"};
        final SimpleList<String> arrayList = SimpleList.<String>fromArrayToArrayList(arrays);
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
}
