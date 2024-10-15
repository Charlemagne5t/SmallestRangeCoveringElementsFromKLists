import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolutionTest {
    @Test
    public void test1(){
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(new ArrayList<>(List.of(4,10,15,24,26)));
        nums.add(new ArrayList<>(List.of(0,9,12,20)));
        nums.add(new ArrayList<>(List.of(5,18,22,30)));
        int[] expected = new int[]{20, 24};
        int[] actual = new Solution().smallestRange(nums);

        Assert.assertArrayEquals(expected, actual);
    }
}
