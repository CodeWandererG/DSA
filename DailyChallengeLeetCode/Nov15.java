package DailyChallengeLeetCode;

public class Nov15 {
    public static void main(String[] args) {
        System.out.println(minimizedMaximum( 312884469 , new int[]{312884470} ));
    }

    public static int minimizedMaximum(int h, int[] nums) {
        int n = nums.length;
        int s = 1;
        int e = nums[n-1];
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

    public static boolean checkPossibleSol(int[] nums , int m , int h){
        for(int v : nums){
            h -= (int) Math.ceil((double) v / m);
        }
        if(h < 0) return false;
        return true;
    }

}
