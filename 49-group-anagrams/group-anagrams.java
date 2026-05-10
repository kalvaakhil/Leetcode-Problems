class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> ans=new HashMap<>();

        for(String i:strs)
        {
            char ch[]=i.toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);
            if(ans.containsKey(s))
            {
                List<String> li=ans.get(s);
                li.add(i);
                ans.put(s,li);
            }
            else{
                List<String> li=new ArrayList<>();
                li.add(i);
                ans.put(s,li);
            }
        }
        return new ArrayList(ans.values());
    }
}