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
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[0].length; j++){
                game[i][j] = array[i][j];
            }

        }

        headPosition= new int[2];
        headPosition[0] = x;
        headPosition[1] = y;
    }

    public int[] findTailExhaustive(){
        resetCounters();
        int neighbors;
        int length = 0;
        int[] tailPosition = new int[3];    // Array contains tail position at indexes 0 and 1 (x, y) and snake length at index 2
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                // exhaustiveChecks will be increased until the tail position is found
                if(tailPosition[0] == 0 && tailPosition[1] == 0){
                    exhaustiveChecks++;
                }
                if(game[i][j] == true){
                    length++;
                    neighbors = 0;

                    // Nested for-loop finds the body of the snake in the array
                    for(int k = -1; k <= 1; k++){
                        for(int l = -1; l <= 1; l++){

                            // If statement ignores diagonal checks
                            if((k == -1 && l == -1) || (k == - 1 && l == 1) || (k == 1 && l == -1) || (k ==1 && j == 1)){
                                continue;
                            }

                            //If statement prevents out of bounds error by omitting negative indexes and indexes greater than board's length
                            if(i + k < 0 || i + k > game.length - 1 || j + l < 0 || j + l > game[i].length - 1){
                                continue;
                            }

                            // If statement increments neighbors to check. Cell with 1 neighbor might be tail
                            if(game[i + k][j + l] == true){
                                neighbors++;
                            }
                        }
                    }
                    neighbors -= 1;     // Removes count for game[i][j]
                    if(neighbors == 1 && (i != headPosition[0] || j != headPosition[1])){
                        tailPosition[0] = i;
                        tailPosition[1] = j;
                    }
                }
            }
        }
        tailPosition[2] = length;
        System.out.println(exhaustiveChecks);
        return tailPosition;
    }

    public int[] findTailRecursive(){
        resetCounters();
        //look at head position
        //chech for neighbors
        //go to the next true cell
        //make sure the neighbor we want to check is not where we came from
        //saving tal
        //count checks
        //snake length
        int length = 0;
        findTailRecursive(headPosition, headPosition);
        int[] tailPosition = new int[3];
        return tailPosition;
    }

    private int[] findTailRecursive(int[] currPosition, int[] previousPosition){
        int[] tailPosition = new int[3];

        return tailPosition;
    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){
        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){
        return exhaustiveChecks;
    }

}
