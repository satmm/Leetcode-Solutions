class Solution {

public int search(int[][] events, int str, int end, int target) {
    int ans = -1;
    while (str <= end) {
         int mid = end + (str - end) / 2;

        if (events[mid][0] > target) {
            ans = mid;
            end = mid - 1;
        } else if (events[mid][0] <= target) {
            str = mid + 1;
        }
    }
    return ans;
}


    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));//sorts the array in the increasing order of the the starting value
        int[] nextMax = new int[events.length];//Stores the next Maximum for A perticular index

        int nm = events[events.length - 1][2];
        for (int i = events.length - 1; i >= 0; i--) {
            if (events[i][2] >= nm) {
                nm = events[i][2];
            }
            nextMax[i] = nm;
        }

        int max = -1;
        for (int i = 0; i < events.length-1; i++) {
            int index = search(events, i+1, events.length - 1, events[i][1]);//standard binary search on the events on starting range because we have sorted the so we can do BS. 
            max = Math.max(max,events[i][2]);//current index can also be the maxium
            if (index == i||index==-1)continue;//if all the intervals are overlapping
            max = Math.max(max, events[i][2] + nextMax[index]);//if we get some valid interval for our selected interval
        }
        max=Math.max(max,events[events.length-1][2]);//their are chances that our last event can be a maxium value

        return max;//return the max

    }
}