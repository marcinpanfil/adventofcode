package pl.mpanfil.adventofcode.year2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day14 {

    public String solve1(int count) {
        List<Integer> recipes = new ArrayList<>(Arrays.asList(3, 7));
        makeRecipes(count, recipes);
        StringBuilder sb = new StringBuilder();
        recipes.subList(count, count + 10).forEach(sb::append);
        return sb.toString();
    }

    public int solve2(String count) {
        List<Integer> recipes = new ArrayList<>(Arrays.asList(3, 7));
        makeRecipes(Integer.parseInt(count) * 200, recipes);
        StringBuilder sb = new StringBuilder();
        recipes.forEach(sb::append);
        char[] result = sb.toString().toCharArray();
        int length = count.length();
        for (int i = 0; i < result.length - length; i++) {
            int equal = 0;
            for (int j = 0; j < length; j++) {
                if (result[i + j] == count.charAt(j)) {
                    equal++;
                } else {
                    break;
                }
            }
            if (equal == length) {
                return i;
            }
        }
        return 0;
    }

    private List<Integer> makeRecipes(int count, List<Integer> recipes) {
        int elf1 = 0;
        int elf2 = 1;
        for (int i = 0; i < count + 10; i++) {
            int current1 = recipes.get(elf1);
            int current2 = recipes.get(elf2);
            int sum = current1 + current2;
            if (sum > 9) {
                recipes.add(sum / 10);
                recipes.add(sum % 10);
            } else {
                recipes.add(sum);
            }
            elf1 = (elf1 + 1 + current1) % recipes.size();
            elf2 = (elf2 + 1 + current2) % recipes.size();
        }
        return recipes;
    }

}
