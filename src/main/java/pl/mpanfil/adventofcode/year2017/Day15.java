package pl.mpanfil.adventofcode.year2017;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Day15 {

    int solve1(long startA, long startB, long factorA, long factorB) {
        int totalCount = 0;
        for (int i = 0; i < 40000000; i++) {
            long a = BigInteger.valueOf(startA).multiply(BigInteger.valueOf(factorA))
                    .mod(BigInteger.valueOf(2147483647)).longValue();
            long b = BigInteger.valueOf(startB).multiply(BigInteger.valueOf(factorB))
                    .mod(BigInteger.valueOf(2147483647)).longValue();
            short aBit = (short) a;
            short bBit = (short) b;
            if (aBit == bBit) {
                totalCount++;
            }
            startA = a;
            startB = b;
        }
        return totalCount;
    }

    int solve2(long startA, long startB, long factorA, long factorB) {
        int totalCount = 0;
        List<Short> toJudgeA = new ArrayList<>();
        List<Short> toJudgeB = new ArrayList<>();
        while (true) {
            if (toJudgeA.size() < 5000001) {
                long a = BigInteger.valueOf(startA).multiply(BigInteger.valueOf(factorA))
                        .mod(BigInteger.valueOf(2147483647)).longValue();
                short aBit = (short) a;
                if ((a % 4) == 0) {
                    toJudgeA.add(aBit);
                }
                startA = a;
            }
            if (toJudgeB.size() < 5000001) {
                long b = BigInteger.valueOf(startB).multiply(BigInteger.valueOf(factorB))
                        .mod(BigInteger.valueOf(2147483647)).longValue();
                short bBit = (short) b;
                if ((b % 8) == 0) {
                    toJudgeB.add(bBit);
                }
                startB = b;
            }
            if (toJudgeA.size() >= 5000000 && toJudgeB.size() >= 5000000) {
                break;
            }
        }

        for (int i = 0; i < 5000000; i++) {
            short a = toJudgeA.get(i);
            short b = toJudgeB.get(i);
            if (a == b) {
                totalCount++;
            }
        }

        return totalCount;
    }

}
