package DailyChallengeLeetCode;

public class Nov14 {
    public static void main(String[] args) {

    }
    public int minimizedMaximum(int h, int[] nums) {
        int n = nums.length;
        int s = 1;
        int e = 1_000_000_000;
        int ans = e;
        while(s <= e){
            int mid = s+(e-s)/2;

            if(checkPossibleSol(nums , mid , h)){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return ans;
    }

    public boolean checkPossibleSol(int[] nums , int m , int h){
        for(int v : nums){
            h -= (int) Math.ceil((double) v / m);
        }
        if(h < 0) return false;
        return true;
    }
}
