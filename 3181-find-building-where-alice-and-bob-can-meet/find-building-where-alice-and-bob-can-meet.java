class Solution {
    class Element {
        int index;
        int[] query;
        Element(int index, int[] query) {
            this.index = index;
            this.query = query;
        }
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        Element[] array = new Element[queries.length];
        for (int i = 0; i < queries.length; i++) {
            array[i] = new Element(i, queries[i]);
        }
        Arrays.sort(array, (e1, e2) -> {
            int max1 = Math.max(e1.query[0], e1.query[1]);
            int max2 = Math.max(e2.query[0], e2.query[1]);
            return Integer.compare(max2, max1);
        });
        int[] result = new int[queries.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Element element = array[i];
            int[] query = element.query;
            int a = query[0];
            int b = query[1];
            int max = Math.max(a, b);
            fillTheList(list, max, heights);
            if (a == b) {
                result[element.index] = a;
            } else if (a < b && heights[a] < heights[b]) {
                result[element.index] = b;
            } else if (b < a && heights[b] < heights[a]) {
                result[element.index] = a;
            } else {
                int target = Math.max(heights[a], heights[b]);
                result[element.index] = binarySearch(list, target, heights);
            }
            addIndexToList(list, max, heights);
        }
        return result;
    }

    private int binarySearch(List<Integer> list, int target, int[] heights) {
        if (list.size() == 0) {
            return -1;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (heights[list.get(mid)] > target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (heights[list.get(right)] > target) {
            return list.get(right);
        }
        if (heights[list.get(left)] > target) {
            return list.get(left);
        }
        return -1;
    }

    private void fillTheList(List<Integer> list, int max, int[] heights) {
        int start = list.size() == 0 ? heights.length - 1 : list.get(list.size() - 1) - 1;
        for (int i = start; i > max; i--) {
            addIndexToList(list, i, heights);
        }
    }

    private void addIndexToList(List<Integer> list, int max, int[] heights) {
        int index = list.size() - 1;
        while (index >= 0 && heights[list.get(index)] <= heights[max]) {
            index--;
        }
        if (index < 0) {
            list.clear();
        } else {
            int deleteIndex = list.size() - 1;
            while (deleteIndex > index) {
                list.remove(deleteIndex);
                deleteIndex--;
            }
        }
        list.add(max);
    }
}