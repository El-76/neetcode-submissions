# [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/description/)

You are given a string <code>s</code> and an integer <code>k</code>. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most <code>k</code> times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

**Example 1:** 

```
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
```

**Example 2:** 

```
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.
```

**Constraints:** 

- <code>1 <= s.length <= 10^5</code>
- <code>s</code> consists of only uppercase English letters.
- <code>0 <= k <= s.length</code>

---

Инициализируем левую и правую границы скользящего окна нулём. Заводим хеш-таблицу с частотами символов. Двигаем правую границу в сторону увеличения, обновляем таблицу. На каждом шаге также обновляем максимум частот - количество экземпляров самого частого символа в окне. Если этот максимум меньше, чем ширина окна, на k или меньше, то произведя k или менее замен мы получим строку из одинаковых символов - запоминаем ширину окна. Если максимум меньше, чем ширина окна, более чем на k - значит k замен не хватит - сужаем окно, двигая левую границу. Повторяем. Последняя запомненная ширина окна будет ответом. 
