//1, how to use the array as some kind of hashmap
//2, more than one diverse travesal

private final char[][] lettersMap = new char[][]{{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g','h','i'}, {'j','k','l'}, {'m', 'n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        char[] val = digits.toCharArray();
        dfs(val, 0, new StringBuilder(), results);
        return results;
    }

    private void dfs(char[] val, int crt, StringBuilder sb, List<String> results) {
        if (crt >= val.length) {
            results.add(sb.toString());
            return;
        }
        char[] letters = lettersMap[val[crt] - '0'];
        int len = sb.length();
        for (char l : letters) {
            sb.append(l);
            dfs(val, crt + 1, sb, results);
            sb.setLength(len);
        }
    }