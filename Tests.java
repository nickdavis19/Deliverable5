import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;
import org.mockito.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;



public class Tests {

  // Test the generateExhaustive function with a valid but on the edge number of 2
  @Test
  public void generateExhaustive_test1(){

    //create a Deliverable4 object
    Pairwise pw = new Pairwise();

    //create the arraylist that is supposed to come of the function
    ArrayList<int[]> t = new ArrayList<int[]>();
    int[] tt = {0,0};
    int[] t3 = {0,1};
    int[] t4 = {1,0};
    int[] t5 = {1,1};
    t.add(tt);
    t.add(t3);
    t.add(t4);
    t.add(t5);

    for (int i=0; i < t.size(); i++){
      Assert.assertArrayEquals(t.get(i),pw.generateExhaustive(2).get(i));
    }

  }

  // Test the generateExhaustive function with an invalid number 0
  @Test
  public void generateExhaustive_test2(){

    //create a Deliverable4 object
    Pairwise pw = new Pairwise();

    //create the arraylist that is supposed to come of the function
    ArrayList<int[]> t = new ArrayList<int[]>();
    int[] tempArray = new int[0];
    t.add(tempArray);

    ArrayList<int[]> tt = pw.generateExhaustive(0);

    Assert.assertArrayEquals(tempArray,tt.get(0));

  }

  // Test the generatePairwiseTT function, has no input so just check the output is correct

  @Test
  public void generatePairwiseTT_test1(){

      //create a Deliverable4 object
      Pairwise pw = new Pairwise();

      //create the arraylist that is supposed to come of the function
      ArrayList<int[]> t = new ArrayList<int[]>();
      int[] tt = {0,0};
      int[] t3 = {0,1};
      int[] t4 = {1,0};
      int[] t5 = {1,1};
      t.add(tt);
      t.add(t3);
      t.add(t4);
      t.add(t5);

      for (int i=0; i < t.size(); i++){
        Assert.assertArrayEquals(t.get(i),pw.generatePairwiseTT().get(i));
      }

}
      //Test the generateInteractions method with a valid number input of 2
      @Test
      public void generateInteractions_test1(){

          //create a Deliverable4 object
          Pairwise pw = new Pairwise();

          //create the arraylist that is supposed to come of the function
          ArrayList<int[]> t = new ArrayList<int[]>();
          int[] t3 = {0,1};

          t.add(t3);

          for (int i=0; i < t.size(); i++){
            Assert.assertArrayEquals(t.get(i),pw.generateInteractions(2).get(i));
          }

        }

        //Test the generateInteractions method with a valid number input of 3
        @Test
        public void generateInteractions_test2(){

            //create a Deliverable4 object
            Pairwise pw = new Pairwise();

            //create the arraylist that is supposed to come of the function
            ArrayList<int[]> t = new ArrayList<int[]>();
            int[] t3 = {0,1};
            int[] t5 = {0,2};
            int[] t6 = {1,2};



            t.add(t3);
            t.add(t5);
            t.add(t6);


            for (int i=0; i < t.size(); i++){
              Assert.assertArrayEquals(t.get(i),pw.generateInteractions(3).get(i));
            }

          }


          //Test the generateInteractions method with an invalid number input of 0
          @Test
          public void generateInteractions_test3(){

              //create a Deliverable4 object
              Pairwise pw = new Pairwise();

              //create the arraylist that is supposed to come of the function
              ArrayList<int[]> t = new ArrayList<int[]>();

              for (int i=0; i < t.size(); i++){
                Assert.assertArrayEquals(t.get(i),pw.generateInteractions(0).get(i));
              }

            }


            //Test the generateInteractions method with an valid input of 1
            @Test
            public void generateInteractions_test4(){

                //create a Deliverable4 object
                Pairwise pw = new Pairwise();

                //create the arraylist that is supposed to come of the function
                ArrayList<int[]> t = new ArrayList<int[]>();

                for (int i=0; i < t.size(); i++){
                  Assert.assertArrayEquals(t.get(i),pw.generateInteractions(1).get(i));
                }

              }


        //Test the truncateParameters method with two valid parameters
        @Test
        public void truncateParameters_test1(){

            //create a Deliverable4 object
            Pairwise pw = new Pairwise();

            //create the String[] that is supposed to come of the function
            String[] t = new String[2];
            t[0] = "dog";
            t[1] = "cat";

            for (int i=0; i < t.length; i++){
              assertEquals(t[i], pw.truncateParameters(t, 2)[i]);
            }

          }

          //Test the truncateParameters method with three valid parameters
          @Test
          public void truncateParameters_test2(){

              //create a Deliverable4 object
              Pairwise pw = new Pairwise();

              //create the String[] that is supposed to come of the function
              String[] t = new String[3];
              t[0] = "dog";
              t[1] = "cat";
              t[2] = "bird";

              for (int i=0; i < t.length; i++){
                assertEquals(t[i], pw.truncateParameters(t, 3)[i]);
              }

            }

            //Test the truncateParameters method with one invalid parameter
            @Test
            public void truncateParameters_test3(){

                //create a Deliverable4 object
                Pairwise pw = new Pairwise();

                //create the String[] that is supposed to come of the function
                String[] t = new String[3];
                t[0] = "dogddsfdfdsff";
                t[1] = "cat";
                t[2] = "bird";

                String[] t2 = new String[3];
                t2[0] = "dogddsfdfd";
                t2[1] = "cat";
                t2[2] = "bird";


                for (int i=0; i < t.length; i++){
                  assertEquals(t2[i], pw.truncateParameters(t, 3)[i]);
                }

              }

              //Test the truncateParameters method with two invalid parameter
              @Test
              public void truncateParameters_test4(){

                  //create a Deliverable4 object
                  Pairwise pw = new Pairwise();

                  //create the String[] that is supposed to come of the function
                  String[] t = new String[3];
                  t[0] = "dogddsfdfdsff";
                  t[1] = "cat";
                  t[2] = "bird";

                  String[] t2 = new String[3];
                  t2[0] = "dogddsfdfd";
                  t2[1] = "cat";
                  t2[2] = "bird";


                  for (int i=0; i < t.length; i++){
                    assertEquals(t2[i], pw.truncateParameters(t, 3)[i]);
                  }

                }

                //Test the generateCovering method with valid input
                @Test
                public void generateCovering_test(){

                    //create a Deliverable4 object
                    Pairwise pw = new Pairwise();

                    //create the arraylist that is supposed to come of the function
                    ArrayList<int[]> t = new ArrayList<int[]>();
                    int[] tt = {0,0};
                    int[] t3 = {1,0};
                    t.add(tt);
                    t.add(t3);

                    //create the arraylist that is supposed to come of the function
                    ArrayList<int[]> t2 = new ArrayList<int[]>();
                    int[] t8 = {0,1};
                    t2.add(t8);

                    assertTrue(pw.generateCovering(t2,t) != null);

                  }

}
