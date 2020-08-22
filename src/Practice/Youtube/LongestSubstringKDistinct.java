package Practice.Youtube;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static int KDistinctLongSubstring(String str,int k){



        int maxLength=0;
        int windowStart=0;
        Map<Character,Integer> countFreqMap=new HashMap<Character,Integer>();

        for(int windowEnd=0;windowEnd<str.length();windowEnd++){

            char rightChar=str.charAt(windowEnd);

            countFreqMap.put(rightChar,countFreqMap.getOrDefault(rightChar,0)+1);
            while(countFreqMap.size()>k){
                char leftChar=str.charAt(windowStart);
                countFreqMap.put(leftChar,countFreqMap.get(leftChar)-1);
                if(countFreqMap.get(leftChar)==0){
                    countFreqMap.remove(leftChar);
                }

                windowStart++;
            }
            maxLength=Math.max(maxLength,windowEnd-windowStart+1);

        }
        return maxLength;

    }

    public static void main(String[] args){

        String str="AAAHHIBC";
        int distinct=2;

        System.out.println(KDistinctLongSubstring(str,distinct));


    }

}
