public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    SnakeGame(){
        game = new boolean[1][1];
    }

    SnakeGame(boolean[][] array, int x, int y){

        game = new boolean[array.length][array[0].length];

        // Copies array's values into the game variable
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                game[i][j] = array[i][j];
            }
        }

        // Head position of snake will always be given
        headPosition= new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){

        resetCounters();
        int neighbors;
        int length = 0;
        boolean foundTail = false;

        int[] tailPosition = new int[3];    // Array contains tail position at indexes 0 and 1 (x, y) and snake length at index 2
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){

                if(!foundTail){     // exhaustiveChecks will be increased until the tail position is found
                    exhaustiveChecks++;
                }

                if(game[i][j]){     // Body of snake found at i and j
                    length++;
                    neighbors = 0;

                    // Nested for-loop finds the body of the snake in the array
                    for(int k = -1; k <= 1; k++){

                        if(i + k < 0 || i + k > game.length - 1){       // Prevents out of bounds excepctions
                            continue;
                        }

                        if(game[i + k][j]){       // Looks for vertical neighbors
                            neighbors++;
                        }
                    }

                    for(int l = -1; l <= 1; l++){

                        if(j + l < 0 || j + l > game[i].length - 1){        // Prevents out of bounds exceptions
                            continue;
                        }

                        if(game[i][j + l]){     // Looks for horizontal neighbors
                            neighbors++;
                        }
                    }

                    neighbors -= 2;     // Removes count for game[i][j] for horizontal and vertical neighbors checks

                    if(neighbors == 1 && (i != headPosition[0] || j != headPosition[1])){
                        tailPosition[0] = i;
                        tailPosition[1] = j;
                        foundTail = true;
                    }
                }
            }
        }
        tailPosition[2] = length;
        return tailPosition;
    }

    public int[] findTailRecursive(){
        resetCounters();
        return findTailRecursive(headPosition, headPosition);
    }

    private int[] findTailRecursive(int[] currPosition, int[] previousPosition){

        recursiveChecks++;  // Number of recursive checks to find tail must also be snake's length

        int[] tailPosition = new int[3];
        tailPosition[0] = currPosition[0];
        tailPosition[1] = currPosition[1];

        //Looks for vertical neighbors at headPosition[0] - n
        if(tailPosition[0] - 1 >= 0){         // Prevents out of bounds exceptions
            if(game[tailPosition[0] - 1][tailPosition[1]] && (tailPosition[0] - 1 != previousPosition[0])){     // Checks if neighbor is found and is not the previous position checked
                previousPosition[0] = tailPosition[0];
                previousPosition[1] = tailPosition[1];
                tailPosition[0] = tailPosition[0] -1;
                return findTailRecursive(tailPosition, previousPosition);
            }
        }

        // Looks for horizontal neighbors at headPosition[1] - n
        if(tailPosition[1] - 1 >= 0){         // Prevents out of bounds exceptions
            if(game[tailPosition[0]][tailPosition[1] - 1] && (tailPosition[1] - 1 != previousPosition[1])){     // Checks if neighbor is found and is not the previous position checked
                previousPosition[0] = tailPosition[0];
                previousPosition[1] = tailPosition[1];
                tailPosition[1] = tailPosition[1] -1;
                return findTailRecursive(tailPosition, previousPosition);
            }
        }

        // Looks for vertical neighbors at headPosition[0] + n
        if(tailPosition[0] + 1 <= game.length - 1){         // Prevents out of bounds exceptions
            if(game[tailPosition[0] + 1][tailPosition[1]] && (tailPosition[0] + 1 != previousPosition[0])){     // Checks if neighbor is found and is not the previous position checked
                previousPosition[0] = tailPosition[0];
                previousPosition[1] = tailPosition[1];
                tailPosition[0] = tailPosition[0] + 1;
                return findTailRecursive(tailPosition, previousPosition);
            }
        }

        // Looks for horizontal neighbors at headPosition[1] + n
        if(tailPosition[1] + 1 <= game.length - 1){         // Prevents out of bounds exceptions
            if(game[tailPosition[0]][tailPosition[1] + 1] && (tailPosition[1] + 1 != previousPosition[1])){     // Checks if neighbor is found and is not the previous position checked
                previousPosition[0] = tailPosition[0];
                previousPosition[1] = tailPosition[1];
                tailPosition[1] = tailPosition[1] + 1;
                return findTailRecursive(tailPosition, previousPosition);
            }
        }


        tailPosition[2] = recursiveChecks;
        return tailPosition;
}

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    static int getRecursiveChecks(){
        return recursiveChecks;
    }

    static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

}