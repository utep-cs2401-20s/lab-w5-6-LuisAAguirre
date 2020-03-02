import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SnakeGameTester {

    /*------------------- findTailExhaustive method test cases -------------------*/

    @Test
    /*
    First exhaustive test will be a simple test to check if method works as intended.
    Array given will be 5 x 5 board. Snake will be of length 3 and will be placed in the middle of the board.
    Head position will be game [2][1] and tail position will be game[2][3].
     */
    public void exhaustiveTest1() {

        boolean[][] A = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};

        SnakeGame test = new SnakeGame(A, 2, 1);

        int[] tail = {2, 3, 3};

        assertArrayEquals(tail, test.findTailExhaustive());
    }
    /*
    Results:
    Test 1 passed. Tail was found at game[2][3] and snake body was of length 3
     */

    @Test
    /*
    This test case will test how the method performs when the tail is found before the head in the array.
    Array given will be a 5 x 5 board. The length of the snake will be 5 cells long with head position will at game[4][4]
        and tail at game[3][1].
     */
    public void exhaustiveTest2() {

        boolean[][] A = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, true},
                {false, false, false, false, true}};
        SnakeGame test = new SnakeGame(A, 4, 4);

        int[] tail = {3, 1, 5};

        assertArrayEquals(tail, test.findTailExhaustive());
    }
    /*
    Test passed. Tail was found at game[3][1] with a length of 5.
     */

    @Test
    /*
    This test will ensure method performs well when handling a snake that is at the edges of the board.
    Test will ensure method does not find any out of bounds exceptions when looking for neighboring cells.
    AArray given will be a 5 x 5 board. The length of the snake will be 10 cells long and will lay along the left, bottom,
        and right edger of the board with head position at game[0][2] and tail at game[1][4].
     */
        public void exhaustiveTest3() {

        boolean[][] A = {{false, false, false, false, false},
                {false, false, false, false, true},
                {true, false, false, false, true},
                {true, false, false, false, true},
                {true, true, true, true, true}};
        SnakeGame test = new SnakeGame(A, 2, 0);

        int tail[] = {1, 4, 10};

        assertArrayEquals(tail, test.findTailExhaustive());
    }
    /*
    Test passed. Tail was found at game[1][4]. No out of bounds exceptions encountered when looking for neighbors.
     */

    @Test
    /*
    This test case will test if exhaustiveChecks variable is counted correctly.
    Array given will be a 5 x 5 board. The length of the snake will be 8 cells long with head at game[0][0] and tail at game[3][2].
    exhaustiveChecks has to stop counting once tail is found.
     */
    public void exhaustiveTest4() {
        boolean[][] A = {{true, true, false, false, false},
            {false, true, true, true, false},
            {false, false, false, true, false},
            {false, false, false, true, true},
            {false, false, false, false, false}};
        SnakeGame test = new SnakeGame(A, 0, 0);

        test.findTailExhaustive();
        assertEquals(20, SnakeGame.getExhaustiveChecks());
    }
    /*
    Test passed. exhaustiveChecks was increased by one until tail was found.
     */

    @Test
    /*
    This test case will test if exhaustiveChecks variable is counted correctly.
    In this test case, the tail will be found before the head. exhaustiveChecks counts needs to stop once tail is found.
    Array given will be a 5 x 5 board. The length of the snake will be 8 cells long with head at game[3][3] and tail at game[1][1].
    exhaustiveChecks has to stop counting once tail is found.
     */
    public void exhaustiveTest5 () {
        boolean[][] A = {{false, false, false, false, false},
            {true, true, false, false, false},
            {true, false, false, false, false},
            {true, true, true, true, true},
            {false, false, false, false, false}};
        SnakeGame test = new SnakeGame(A, 3, 3);

        test.findTailExhaustive();
        assertEquals(7, SnakeGame.getExhaustiveChecks());
    }
    /*
    Test was passed. exhaustiveChecks was increased by one until tail was found even if the method kept being tested.
     */


    /*------------------- findTailExhaustive method test cases -------------------*/

    @Test
    /*
    This test case will test if the length is counted correctly.
    In this method, the length counted not by checking every cell for a true value, but by checking if a cell has a neighbor
    and is not the previous cell that was being checked.
    Array given will be a 5 x 5 board. The length of the snake will be 5 cells long with head at game[4][2] and tail at game[3][2].
    exhaustiveChecks has to stop counting once tail is found.
     */
    public void recursiveTest1() {
        boolean[][] A = {{false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, true, true, true},
                {false, true, true, false, false},
                {false, false, false, false, false}};
        SnakeGame test = new SnakeGame(A, 4, 2);

        int[] x = test.findTailRecursive();

        assertEquals(5, x[2]);
    }
    /*
    Test passed. Length was found to be 5
     */

    @Test
    /*
    First exhaustive test will be a simple test to check if method works as intended.
    Array given will be 5 x 5 board. Snake will be of length 3 and will be placed in the middle of the board.
    Head position will be game [1][2] and tail position will be game[3][2].
     */
    public void recursiveTest2() {

        boolean[][] A = {{false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false}};

        SnakeGame test = new SnakeGame(A, 1, 2);

        int[] tail = {3, 2, 3};

        assertArrayEquals(tail, test.findTailRecursive());
    }
    /*
    Results:
    Test 1 passed. Tail was found at game[3][2] and snake body was of length 3
     */

    @Test
    /*
    This test case will test how the method deals with the body of the finds neighbors when the body of the snake is at
    the edges of the board. Even if the method finds the next cell of the body recursively, it still needs to find the next
    cell by subtracting from index or adding to the index.
    Array given will be a 5 x 5 board. Snake's length will be 10 cells long. Head will be at game[0][3] and tail will be at game[2][1].
     */
    public void recursiveTest3() {

        boolean[][] A = {{false, false, false, true, true},
                {false, false, false, false, true},
                {false, false, false, false, true},
                {false, true, false, false, true},
                {false, true, true, true, true}};
        SnakeGame test = new SnakeGame(A, 0, 3);

        int[] tail = {3, 1, 10};

        assertArrayEquals(tail, test.findTailRecursive());
    }
    /*
    Test passed. Tail was found at game[2][1] with a length of 5 and no out of bounds exceptions.
     */

    @Test
    /*
    This test will ensure recursiveChecks are counted correctly. The number of checks in this method will equal the length,
    as the board is checked only when a cell is found.
    Array given will be a 5 x 5 board. The length of the snake will be 10 cells long. Head position will be game[0][2]
     and tail will be at game[3][2]
     */
    public void recursiveTest4() {

        boolean[][] A = {{true, true, true, false, false},
                {true, false, false, false, false},
                {true, false, false, false, false},
                {true, false, true, false, false},
                {true, true, true, false, false}};
        SnakeGame test = new SnakeGame(A, 0, 2);

        test.findTailRecursive();

        assertEquals(10, SnakeGame.getRecursiveChecks());
    }
    /*
    Test passed. recursiveChecks is 10
     */

    @Test
    /*
    This test case will test how the method handles a long snake. Since this method's way of finding the body of the snake
    is more complex than findTailExhaustive(), a long snake will test if everything works correctly.
    Array given will be 6 x 5 Head will be at game[0][4] and tail will be at game[6][0].
     */
    public void recursiveTest5() {
        boolean[][] A = {{true, true, true, true, true},
                {true, false, false, false, false},
                {true, false, true, true, true},
                {true, false, true, false, true},
                {true, true, true, false, true},
                {false, false, false, false, true},
                {true, true, true, true, true}};
        SnakeGame test = new SnakeGame(A, 0, 4);

        int[] tail = {6, 0, 23};

        assertArrayEquals(tail, test.findTailRecursive());
    }
    /*
    Test was passed. Tail was found at game[6][0].
     */

}
