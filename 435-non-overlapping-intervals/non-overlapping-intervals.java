class Solution {
    public class Data{
        int start;
        int end;
        public Data(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;
        Data[] arr=new Data[n];
        for(int i=0;i<n;i++){
            arr[i]=new Data(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a.end,b.end));
        int endtime=arr[0].end;
        int count=1;
        for(int i=0;i<n;i++){
            if(endtime<=arr[i].start){
                count++;
                endtime=arr[i].end;
            }
        }
        return n-count;
    }
}