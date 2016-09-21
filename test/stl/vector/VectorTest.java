package stl.vector;

import static std.Algorithms.*;
import std.Vector;

import org.junit.Test;

/**
 *
 * @author sergey
 */
public class VectorTest {
    
    @Test
    public void test1() {
        Vector<Integer> vi = new Vector<>();
        vi.resize(10);
        for (int i = 0; i < 10; ++i) {
            vi.at(i, i);
        }
        Vector<String> vs = new Vector<>();
        vs.resize(10);
        transform(
                vi.begin(),
                vi.end(),
                vs.begin(),
                i -> Integer.toString(i)
        );

        for_each(
                vs.begin(),
                vs.end(),
                s -> System.out.println(s)
        );
    }
}
