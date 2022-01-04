package fop.w4fish;


public class Penguin{

    public static void printWorld(int[][] world, int pinguRow, int pinguColumn) {


        String[][] map = getWorldString(world, pinguRow, pinguColumn);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[1].length; j++) {
                if (i == pinguRow && j == pinguColumn) {
                    if (j == 0)
                        System.out.print(map[i][j] + "(P)");
                    else
                        System.out.print("\t" + map[i][j] + "(P)");
                } else if (j == 0)
                    System.out.print(map[i][j] + "\t");
                else if (j == 5)
                    System.out.print("\t" + map[i][j]);
                else
                    System.out.print("\t" + map[i][j] + "\t");

            }
            System.out.println("");
        }

    }

    public static String[][] getWorldString(int[][] world, int pinguRow, int pinguColumn) {
        String[][] map = new String[world.length][world[0].length];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world[0].length; j++) {
                switch (world[i][j]) {
                    case 0 -> map[i][j] = "L";
                    case 1 -> map[i][j] = "I";
                    case 2 -> map[i][j] = "W";
                    case 3 -> map[i][j] = "S";
                    case 4 -> map[i][j] = "F";
                }
            }
        }
        return map;
    }

    public static boolean isFishReachable(int[][] world, int pinguRow, int pinguColumn)
    {
        String[][] map = getWorldString(world, pinguRow, pinguColumn);
        switch (map[pinguRow][pinguColumn]) {
            case "S" ->{
                return false;
            }
            //START OF  L BLOCK
            case "L" -> {
                // middle part of map
                if ((pinguRow != 0 && pinguColumn != 0) && (pinguRow != map.length - 1 && pinguColumn != map[1].length - 1)) {
                    for (int i = pinguRow - 1; i <= pinguRow + 1; i++) {
                        for (int j = pinguColumn - 1; j <= pinguColumn + 1; j++) {
                            if (map[i][j].equals("F"))
                                return true;
                        }
                    }
                    return false;
                }
                if (pinguRow == 0) {
                    if (pinguColumn == 0) {
                        for (int i = 0; i <= pinguRow + 1; i++) {
                            for (int j = 0; j <= pinguColumn + 1; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    } else if (pinguColumn == map[0].length - 1) {
                        for (int i = 0; i <= pinguRow + 1; i++) {
                            for (int j = pinguColumn - 1; j <= pinguColumn; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    } else {
                        for (int i = 0; i <= pinguRow + 1; i++) {
                            for (int j = pinguColumn - 1; j <= pinguColumn + 1; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    }
                } else if (pinguRow == map.length - 1) {
                    if (pinguColumn == 0) {
                        for (int i = pinguRow - 1; i <= pinguRow; i++) {
                            for (int j = 0; j <= pinguColumn + 1; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    } else if (pinguColumn == map[0].length - 1) {
                        for (int i = pinguRow - 1; i <= pinguRow; i++) {
                            for (int j = pinguColumn - 1; j <= pinguColumn; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    } else {
                        for (int i = pinguRow - 1; i <= pinguRow; i++) {
                            for (int j = pinguColumn - 1; j <= pinguColumn + 1; j++) {
                                if (map[i][j].equals("F"))
                                    return true;
                            }
                        }
                        return false;
                    }
                } else if (pinguColumn == 0) {
                    for (int i = pinguRow - 1; i <= pinguRow + 1; i++) {
                        for (int j = 0; j <= pinguColumn + 1; j++) {
                            if (map[i][j].equals("F"))
                                return true;
                        }
                    }
                    return false;
                } else if (pinguColumn == map[1].length) {
                    for (int i = pinguRow - 1; i <= pinguRow + 1; i++) {
                        for (int j = pinguColumn - 1; j <= pinguColumn; j++) {
                            if (map[i][j].equals("F"))
                                return true;
                        }
                    }
                    return false;
                }
            }

            //START OF I BLOCK
            case "I" -> {
                if (pinguRow != 0 && pinguColumn != 0 && pinguRow != map.length - 1 && pinguColumn != map[1].length - 1) {
                    for (int i = pinguRow - 1; i <= pinguRow + 1; i++) {
                        for (int j = pinguColumn - 1; j <= pinguColumn + 1; j++) {
                            if ((i == pinguRow - 1 || i == pinguRow + 1) && (j == pinguColumn - 1 || j == pinguColumn + 1))
                                if (map[i][j].equals("F"))
                                    return true;
                        }
                    }
                }
                if (pinguRow == 0) {
                    if (pinguColumn == 0) {
                        return map[pinguRow + 1][pinguColumn + 1].equals("F");
                    } else if (pinguColumn == map[0].length - 1) {
                        return map[pinguRow + 1][pinguColumn - 1].equals("F");
                    } else
                        return (map[pinguRow + 1][pinguColumn - 1].equals("F") || map[pinguRow + 1][pinguColumn + 1].equals("F"));
                } else if (pinguRow == map.length - 1) {
                    if (pinguColumn == 0)
                        return map[pinguRow - 1][pinguColumn + 1].equals("F");
                    else if (pinguColumn == map[0].length - 1)
                        return map[pinguRow - 1][pinguColumn - 1].equals("F");
                    else
                        return (map[pinguRow - 1][pinguColumn - 1].equals("F") || map[pinguRow - 1][pinguColumn + 1].equals("F"));
                } else if (pinguColumn == 0)
                    return map[pinguRow - 1][pinguColumn + 1].equals("F") || map[pinguRow + 1][pinguColumn + 1].equals("F");

                else if (pinguColumn == map[0].length - 1)
                    return map[pinguRow - 1][pinguColumn - 1].equals("F") || map[pinguRow + 1][pinguColumn - 1].equals("F");
            }

            //START OF W BLOCK
            case "W" -> {
                for (int i = -3; i <= 3; i++) {
                    for (int j = -3; j <= 3; j++) {
                        if (i % 3 != 0 && j % 3 != 0)
                            continue;
                        try {
                            if (map[pinguRow - i][pinguColumn - j] != null)
                                if (map[pinguRow - i][pinguColumn - j].equals("F"))
                                    return true;
                        } catch (ArrayIndexOutOfBoundsException ignored) {
                        }
                    }
                }
                return false;
            }
        }
    return false;
    }
    public static int[][] generateExampleWorldOne() {
        return new int[][]{
                {2,3,3,3,3,3},
                {3,0,3,3,4,3},
                {3,3,3,3,3,1},
                {3,3,3,0,1,3},
                {3,3,3,3,3,3}
        };
    }
    public static int[][] generateExampleWorldTwo()
    {
        return new int[][]
                {
                        {0, 0, 0, 2},
                        {0, 0, 1, 1},
                        {0, 1, 3, 4},
                        {3, 4, 3, 3}};
    }
    public static void main(String[] args)
    {
        int pinguRow = 0;
        int pinguColumn = 3;
        int[][] world = generateExampleWorldTwo();
        printWorld(world, pinguRow, pinguColumn);
        System.out.println("" + isFishReachable(world, pinguRow, pinguColumn));
    }
}
