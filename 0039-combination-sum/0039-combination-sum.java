class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates,0,target,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(
        int[] candidates,
        int index,
        int remaining,
        List<Integer> current,
        List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(remaining < 0){
            return;
        }
        for(int i = index ; i < candidates.length; i++){

        current.add(candidates[i]);
        backtrack(candidates, i, remaining - candidates[i],current,result);
        current.remove(current.size()-1);
      }
    }
}