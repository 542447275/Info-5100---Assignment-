import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0;end = 0; }
    Interval(int s, int e) { start = s;end = e; }
}

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()==0)
            return new ArrayList<Interval>();

        int[] start = new int[intervals.size()], end = new int[intervals.size()];
        for(int i = 0;i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int s = start[0], e = end[0];
        List<Interval> res = new ArrayList<>();
        for(int i = 1;i < end.length; i++){
            if(e >= start[i])
                e = end[i];
            else {
                res.add(new Interval(s, e));
                s = start[i];
                e = end[i];
            }
        }
        res.add(new Interval(s,e));
        return res;
    }
}
