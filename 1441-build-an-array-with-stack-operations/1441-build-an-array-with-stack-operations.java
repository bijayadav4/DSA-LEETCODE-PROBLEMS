class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i =0;
        for(int num = 1; num <=n && i < target.length; num++){
            result.add("Push");
            if(num == target[i]){
                i++;
            } else {
                result.add("Pop");
            }
        }
        return result;
    }
}