import java.util.*;

public class SearchKeyWordsIndex {
   public static void main(String[] args) {
      String oath = "Night gathers, and now my watch begins. It shall not end until my death. I shall take no wife, hold no lands, father no children. I shall wear no crowns and win no glory. I shall live and die at my post. I am the sword in the darkness. I am the watcher on the walls. I am the fire that burns against the cold, the light that brings the dawn, the horn that wakes the sleepers, the shield that guards the realms of men. I pledge my life and honor to the Night's Watch, for this night and all the nights to come.";
      Set<String> words = new HashSet<>();
      words.add(" and");
      words.add("stark");
      words.add(" no");
      System.out.println(search(words, oath));
   }
   
   public static Map<String, List<Integer>> search(Set<String> words, String s) {
      Map<String, List<Integer>> map = new HashMap<>();
      for (String word : words) {
         List<Integer> list = helper(word, s);
         if (!list.isEmpty()) {
            map.put(word, list);
         }
      }
      return map;
   }
   
   private static List<Integer> helper(String word, String s) {
      List<Integer> list = new ArrayList<>();
      int index = s.indexOf(word);
      int previous = 0;
      while (index != -1) {
         list.add(index + previous);
         s = s.substring(index + 1);
         previous += index + 1;
         index = s.indexOf(word);
      }
      return list;
   }
}