Arrays of arrays

 

public class ArraysOfArrays {
  public static void main( String[] args ) {
    // creates an array of integer arrays
    // note that the column sizes are jagged, that is,
    // of different sizes
    int[][] matrix =
        {
          {1, 2, 4},
          {2, 4},
          {5, 6, 7, 8, 9}
        };

    // cycle through the array, and output its contents
    for( int i = 0; i < matrix.length; i++ ) {
      for( int j = 0; j < matrix[i].length; j++ ) {
        System.out.println( "matrix[" + i + "][" + j + "] = " + matrix[i][j] );
      }
    }

    // specify array of strings
    String[][] anotherMatrix =
        {
          {"hello"},
          new String[]{"hello", "world"}, /* note, embed new arrays here */
          {"the", "quick", "brown", "fox"}, /* note, comma can be added here */
        };
  }
}
