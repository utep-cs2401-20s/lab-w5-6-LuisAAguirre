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
        int length = 0;
        int[] tailPosition = new int[3];
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[i].length; j++){
                exhaustiveChecks++;
                if(game[i][j] == true){
                    length++;

                    //count neighbors
                    //if 1 neighbor == tail or head
                    //if head keep going
                    //
                }
            }
        }
        return tailPosition;
    }

    public int[] findTailRecursive(){
        resetCounters();
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
