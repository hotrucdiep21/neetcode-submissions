class Solution {
    public int[] replaceElements(int[] arr) {
        int max_right = -1;
        for(int i = arr.length -1; i >=0; i--) {
            int current = arr[i];
            arr[i] = max_right;
            max_right = Math.max(max_right, current);
        }
        return arr;
    }
}