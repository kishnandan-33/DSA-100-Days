class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(j>i){
            if(isv(arr[i])&&isv(arr[j])){
                char t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                i++;
                j--;
            }
            else if(isv(arr[i]))j--;
            else i++;
        }
        return  new String(arr);
        
    }
    boolean isv(char c){
        return c=='a'||c=='i'||c=='o'||c=='u'||c=='e'||c=='A'||c=='I'||c=='O'||c=='U'||c=='E';
    }
}