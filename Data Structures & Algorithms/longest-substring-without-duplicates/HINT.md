# [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

Given a string <code>s</code>, find the length of the **longest**  <button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1j_" data-state="closed" class="">**substring** </button> without duplicate characters.

**Example 1:** 

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that <code>"bca"</code> and <code>"cab"</code> are also correct answers.
```

**Example 2:** 

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

**Example 3:** 

```
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
```

**Constraints:** 

- <code>0 <= s.length <= 5 * 10^4</code>
- <code>s</code> consists of English letters, digits, symbols and spaces.

---

Инициализируем левую и правую границы скользящего окна нулём. Заводим хеш-тпблицу, в которой храним последнюю позицию на которой встречался каждый символ. Двигаем правую границу в сторону увеличения, на каждом шаге смотрим, встречался ли уже символ на правой границе внутри окна (между левой и правой границей). Если встречался, то символы внутри окна повторяются, двигаем левую гранмцу на позицию, следующую за той, где встречался символ - после этой операции все символы внутри окна опять будут уникальны. Повторяем. Максимальная ширина окна будет ответом. 
