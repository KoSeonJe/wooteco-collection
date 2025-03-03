import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import collection.SimpleLinkedList;
import collection.SimpleList;

public class LinkedListStudy {

    @Test
    public void list() {
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
    public void linkedList() {
        SimpleList values = new SimpleLinkedList();
        values.add("first");
        values.add("second");
        values.add(1, "newSecond");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.get(1)).isEqualTo("newSecond");
        assertThat(values.set(1, "newnewSecond")).isEqualTo("newnewSecond");
        assertThat(values.contains("newnewSecond")).isTrue();
        assertThat(values.contains("없는거")).isFalse();
        assertThat(values.indexOf("newnewSecond")).isEqualTo(1);
        assertThat(values.indexOf("없는거")).isEqualTo(-1);
        assertThat(values.remove(1)).isEqualTo("newnewSecond");
        assertThat(values.remove("first")).isTrue();
        assertThat(values.size()).isEqualTo(2);



        // TODO values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }
}
