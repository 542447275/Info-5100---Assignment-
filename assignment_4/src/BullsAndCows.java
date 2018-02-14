import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess){
        int bulls = 0;
        int cows = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g)
                bulls++;
            else
                if(hashMap.containsKey(s)) {
                    int count = hashMap.get(s);
                    hashMap.put(s, ++count);
                }
                else
                    hashMap.put(s, 1);
        }

        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s != g) {
                if (hashMap.containsKey(g)) {
                    cows++;
                    if(hashMap.get(g) == 1)
                        hashMap.remove(g);
                    else {
                        int count = hashMap.get(g);
                        hashMap.put(g, --count);
                    }
                }
            }
        }
        return bulls + "Bulls " + cows + " Cows";
    }

    public String getHint2(String secret, String guess){
        int[] arr = new int[10];
        int bulls = 0, cows = 0;

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i))
                bulls++;
            else {
                if(arr[secret.charAt(i)-'0']++ < 0)
                    cows++;
                if(arr[guess.charAt(i)-'0']-- > 0)
                    cows++;
            }
        }
        return bulls + "Bulls " + cows + " Cows";
    }

    public static void main(String[] args){
        BullsAndCows bc = new BullsAndCows();
        String str = bc.getHint2("1807", "7810");
        System.out.println(str);
    }
}
