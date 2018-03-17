public class RemoveVowelsFromString {
    public String removeVowelsFromString(String input){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != 'a' && input.charAt(i) != 'e' && input.charAt(i) != 'i' && input.charAt(i) != 'o' && input.charAt(i) != 'u' && input.charAt(i) != 'A' && input.charAt(i) != 'E' && input.charAt(i) != 'I' && input.charAt(i) != 'O' && input.charAt(i) != 'U')
                sb.append(input.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        RemoveVowelsFromString rv = new RemoveVowelsFromString();
        String res = rv.removeVowelsFromString("abcedfghigkAEIOUKJCV");
        System.out.println(res);
    }
}
