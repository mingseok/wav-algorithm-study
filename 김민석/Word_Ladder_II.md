## Word_Ladder_II

- https://leetcode.com/problems/word-ladder-ii/description/?envType=problem-list-v2&envId=string

```java
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return Collections.emptyList();
        }

        Map<String, Integer> distance = new HashMap<>();
        Map<String, Set<String>> parents = new HashMap<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentDistance = distance.get(currentWord);

            if (currentWord.equals(endWord)) break;

            char[] chars = currentWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == original) continue;
                    chars[i] = ch;
                    String newWord = new String(chars);

                    if (!wordSet.contains(newWord)) continue;

                    if (!distance.containsKey(newWord)) {
                        distance.put(newWord, currentDistance + 1);
                        queue.add(newWord);
                        parents.put(newWord, new HashSet<>(Collections.singleton(currentWord)));
                    } else if (distance.get(newWord) == currentDistance + 1) {
                        parents.get(newWord).add(currentWord);
                    }
                }
                chars[i] = original;
            }
        }

        if (!distance.containsKey(endWord)) {
            return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        ArrayList<String> path = new ArrayList<>();
        path.add(endWord);
        buildPaths(beginWord, endWord, parents, path, result);
        return result;
    }

    private void buildPaths(String beginWord,
                            String word,
                            Map<String, Set<String>> parents,
                            List<String> path,
                            List<List<String>> result) {
        if (word.equals(beginWord)) {
            ArrayList<String> one = new ArrayList<>(path);
            Collections.reverse(one);
            result.add(one);
            return;
        }

        Set<String> parentWords = parents.get(word);
        if (parentWords == null) return;

        for (String parent : parentWords) {
            path.add(parent);
            buildPaths(beginWord, parent, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```
