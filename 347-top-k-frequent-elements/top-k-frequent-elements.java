class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int ans[] = new int[k];

        // Count frequency
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        System.out.println(map);

        List<Integer> val = new ArrayList<>(map.values());
        Collections.sort(val);

        int temp[] = new int[k];

        int co = 0;

        // Store top k frequencies
        temp[co++] = val.get(val.size() - 1);

        for (int i = val.size() - 2; i >= 0; i--) {

            if (co >= k) {
                break;
            }

            if (temp[co - 1] != val.get(i)) {
                temp[co++] = val.get(i);
            }
        }

        // Find numbers having those frequencies
        int index = 0;

        for (int freq : temp) {

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() == freq) {

                    ans[index++] = entry.getKey();

                    if (index >= k) {
                        return ans;
                    }
                }
            }
        }

        return ans;
    }
}