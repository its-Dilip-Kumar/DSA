class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans=new ArrayList<>();
        solve(0,digits,ans,new StringBuilder(),map);
        return ans;
    }
    public static void solve(int idx,String digits,List<String> ans,StringBuilder temp,HashMap<Character,String> map){
        if(idx>=digits.length()){
            ans.add(temp.toString());
            return;
        }
        char ch=digits.charAt(idx);
        String str=map.get(ch);
        for(int i=0;i<str.length();i++){
            char strch=str.charAt(i);
            temp.append(strch);
            solve(idx+1,digits,ans,temp,map);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}