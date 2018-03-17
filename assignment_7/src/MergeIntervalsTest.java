import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {
    @Test
    void merge() {
        MergeIntervals obj = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(6,8));

        List<Interval> res = new ArrayList<>();

        res.add(new Interval(1, 4));
        res.add(new Interval(5, 8));

        List<Interval> test = obj.merge(intervals);
        for (int i = 0;i<res.size();i++) {
            assertEquals(test.get(i).start, res.get(i).start);
            assertEquals(test.get(i).end, res.get(i).end);
        }
    }

}