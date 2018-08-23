package pl.mpanfil.adventofcode.year2017;

class Day3 {

    int solve1(int number) {
        int position = getPositionFromMiddle(number);
        int size = (2 * position - 1);
        int endX = (size - 1) / 2;
        int endY = -(size - 1) / 2;
        int startNumber = (int) (Math.pow(size - 2, 2) + 1);
        int endNumber = (int) Math.pow(size, 2);
        int posX = 0, posY = 0;

        if (number > (endNumber - size)) {
            posY = endY;
            posX = endX - (endNumber - number);
        } else if (number > (endNumber - 2 * size + 1)) {
            posX = -endX;
            posY = endY + 1 + (endNumber - number - size);
        } else if (number > (endNumber - 3 * size + 2)) {
            posX = -endX + (endNumber - number - size - size + 1) + 1;
            posY = -endY;
        } else if (number <= (endNumber - 3 * size + 2)) {
            posX = endX;
            posY = endY + (number - startNumber) + 1;
        }

        return calculateDistance(posX, posY);
    }

    int solve2(int number) {
        Data data = new Data(number);
        data.setData(data.posX, data.posY, 1);
        data.posX++;
        data.setData(data.posX, data.posY, 1);

        navigateLeft(data);
        navigateDown(data);
        navigateRight(data);

        while (number > data.getValue(data.posX, data.posY)) {
            data.size = data.size + 2;
            navigateUp(data);
            navigateLeft(data);
            navigateDown(data);
            navigateRight(data);
        }

        System.out.println("posX " + data.posX + " posY" + data.posY);

        return data.getResult();
    }

    private void navigateLeft(Data data) {
        data.posY++;
        data.setData(data.posX, data.posY, data.getValue(data.posX - 1, data.posY - 1)
                + data.getValue(data.posX, data.posY - 1));

        for (int i = 0; i < data.size; i++) {
            data.posX--;
            data.setData(data.posX, data.posY, data.getValue(data.posX - 1, data.posY - 1)
                    + data.getValue(data.posX, data.posY - 1) + data.getValue(data.posX + 1, data.posY - 1)
                    + data.getValue(data.posX + 1, data.posY));
        }

        data.posX--;
        data.setData(data.posX, data.posY, data.getValue(data.posX + 1, data.posY - 1)
                + data.getValue(data.posX + 1, data.posY));
    }

    private void navigateDown(Data data) {
        for(int i = 0; i< data.size; i++) {
            data.posY--;
            data.setData(data.posX, data.posY, data.getValue(data.posX, data.posY + 1)
                    + data.getValue(data.posX + 1, data.posY + 1) + data.getValue(data.posX + 1, data.posY)
                    + data.getValue(data.posX + 1, data.posY - 1));
        }
    }

    private void navigateRight(Data data) {
        data.posY--;
        data.setData(data.posX, data.posY, data.getValue(data.posX + 1, data.posY + 1)
                + data.getValue(data.posX, data.posY + 1));
        for (int i = 0; i < data.size; i++) {
            data.posX++;
            data.setData(data.posX, data.posY, data.getValue(data.posX - 1, data.posY + 1)
                    + data.getValue(data.posX, data.posY + 1) + data.getValue(data.posX + 1, data.posY + 1)
                    + data.getValue(data.posX - 1, data.posY));
        }

        data.posX++;
        data.setData(data.posX, data.posY, data.getValue(data.posX - 1, data.posY + 1)
                + data.getValue(data.posX - 1, data.posY) + data.getValue(data.posX, data.posY + 1));
    }

    private void navigateUp(Data data) {
        data.posX++;
        data.setData(data.posX, data.posY, data.getValue(data.posX - 1, data.posY + 1)
                + data.getValue(data.posX - 1, data.posY));

        for (int i = 0; i < data.size - 1; i++) {
            data.posY++;
            data.setData(data.posX, data.posY, data.getValue(data.posX, data.posY - 1)
                    + data.getValue(data.posX - 1, data.posY - 1) + data.getValue(data.posX - 1, data.posY)
                    + data.getValue(data.posX - 1, data.posY + 1));
        }

    }

    private int getPositionFromMiddle(int number) {
        int power = 1;
        int position = 1;
        while (Math.pow(power, 2) < number) {
            power += 2;
            position++;
        }
        return position;
    }

    private int calculateDistance(int x, int y) {
        return Math.abs(0 - x) + Math.abs(0 - y);
    }

    private class Data {

        int posX = 0;
        int posY = 0;
        int size = 1;

        private int[][] data = new int[1001][1001];
        private int middle = 500;
        private int number;
        private int result = -1;

        Data(int number) {
            this.number = number;
        }

        int getValue(int x, int y) {
            return data[middle + x][middle + y];
        }

        void setData(int x, int y, int value) {
            data[middle + x][middle + y] = value;
            if(value > number && result == -1) {
                result = value;
            }
        }

        int getResult() {
            return result;
        }

    }


}
