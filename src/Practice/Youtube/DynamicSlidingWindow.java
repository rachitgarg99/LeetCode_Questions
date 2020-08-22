package Practice.Youtube;

public class DynamicSlidingWindow {

    public static int SmallestSubarray(int k,int[] arr){


        int size=arr.length;
        int smallestSize =size;
        int currentSum=0;
        int currSize=0;
        for(int i=0;i<size;i++){
            currentSum+= arr[i];
            currSize++;
            while(currentSum>=k){
                smallestSize=Integer.min(currSize,smallestSize);
                //System.out.println(i+"  "+currSize+" "+currentSum+" "+smallestSize);
                currentSum-=arr[i-currSize+1];
                currSize--;

            }
        }
        return smallestSize;
    }

    public static int SmallestSubarray2(int targetSum,int[] input){

        int minWindowSize=Integer.MAX_VALUE;
        int currentWindowSum=0;
        int windowStart=0;
        for(int windowEnd=0;windowEnd< input.length;windowEnd++){

            currentWindowSum+=input[windowEnd];
            while(currentWindowSum>=targetSum){
                minWindowSize=Math.min(minWindowSize,windowEnd-windowStart+1);
                currentWindowSum-= input[windowStart];
                windowStart++;
            }

        }
        return minWindowSize;

    }

    public static void main(String [] args){

        int[] input={4,2,2,7,4,1,2,10};
        int targetSum=8;
        System.out.println(SmallestSubarray(targetSum,input));
        System.out.println(SmallestSubarray2(targetSum,input));

    }


}
