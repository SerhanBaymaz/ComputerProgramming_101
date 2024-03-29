package Week9_101L;

import java.util.Arrays;
import java.util.Scanner;

public class Week9_101L {

    //0. Write display methods for
    //a. Write a method that displays the given array in a single line, tab separated
    //b. Write a method that displays two-dimensional array, each row in a new line
    public static void display1DimensionArray(int[] array){
        //System.out.println("One Dimensional array :    ");
        System.out.print("["+array[0]+"    ");
        for (int i = 1; i <array.length-1 ; i++) {
            System.out.print(array[i]+"    ");
        }
        System.out.println(array[array.length-1]+"]\n");
    }
    public static void display2DimensionArray(int[][] array){
        //System.out.println("Two Dimensional array ;");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print("    "+array[i][j]+"    ");
            }
            System.out.println("]");
        }

    }




    //1. Write a method that returns the sum of all the elements in a specified
    //a. Column
    //b. Row
    public static int sumColumn(int[][] matrix, int columnIndex){
        int sum = 0;
        for (int i = 0; i <matrix.length ; i++) {
            sum=sum+matrix[i][columnIndex];
        }

        return  sum;
    }
    public static int sumRow(int[][] matrix, int rowIndex){
        int sum = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            sum=sum+matrix[rowIndex][i];
        }

        return sum;
    }




    //2a. Write a method that generates a random char between any given two characters
    public static char random(char start, char end){
        int random = (int)(Math.random()*(end-start+1)+start);
        return (char)random;
    }
    //2c. Generate an answer array that represents the correct answers of questions according to
    //number of questions.
    public static char[] answerArray(int numberOfQuestions){
        char[] ansArr = new char[numberOfQuestions];
        for (int i = 0; i < numberOfQuestions; i++) {
            ansArr[i] = random('A','E');
        }
        return ansArr;
    }
    //2.d
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    //2.e
    public static int[] grade(char[][] studentAnswers, char[] correctAnswers){
        int grade = 0;
        int studentNumber = studentAnswers.length;

        int[] gradeList = new int[studentNumber];
        for (int i = 0; i < studentNumber; i++) {
            for (int j = 0; j < correctAnswers.length; j++) {
                if (studentAnswers[i][j] == correctAnswers[j]) {
                    grade+=10;
                }
            }
            gradeList[i]=grade;
            grade=0;
        }
        Arrays.sort(gradeList);

        return gradeList;
    }




    //3.a Overload the random method for int data type.
    public static int[][] addMatrix(int[][] matrixA, int[][] matrixB){
        int maxROW = Math.max(matrixA.length,matrixB.length);
        int maxCOLUMN = Math.max(matrixA[0].length,matrixB[0].length);

        int[][] result = new int[maxROW][maxCOLUMN];
        for (int i = 0; i < maxROW; i++) {
            for (int j = 0; j < maxCOLUMN; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j] ;
            }
        }

        return result;
    }
    //3.b. Write a method that generates a random matrix given its dimensions
    public static int[][] generateMatrix(int m, int n){
        int[][] array2d = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2d[i][j]=(int) (10+Math.random()*39);
            }
        }

        return array2d;
    }




    //4.a Write a method that returns the index of the point which is closest to a given point from an array
    //of points in three-dimensional coordinate space. Use a two-dimensional array to represent
    //points.
    public static int getClosestPoint(int[][] points, int pointIndex){
        int closestPoint = 0;
        int distance = 0;
        int minDistance = 0;
        for (int i = 0; i < points.length; i++) {
            if (i!=pointIndex){
                distance = (int) Math.sqrt(Math.pow(points[pointIndex][0]-points[i][0],2)+Math.pow(points[pointIndex][1]-points[i][1],2)+Math.pow(points[pointIndex][2]-points[i][2],2));
                if (i==1){
                    minDistance = distance;
                }
                if (distance<minDistance){
                    minDistance = distance;
                    closestPoint = i;
                }
            }
        }
        return closestPoint;
    }
    //4.b Write a round method that rounds any given double to given amount of int decimal
    //places
    public static double round(double value, int places){
        double result = 0;
        double temp = 0;
        temp = value*Math.pow(10,places);
        result = Math.round(temp);
        result = result/Math.pow(10,places);
        return result;
    }




    //5. Write a method that generates a matrix randomly filled with 0s and 1s, displays the matrix and
    //returns the row and column indexes with the most 1s as a pair of two.
    public static int[] locateMostOnes(int m, int n){
        int[][] arr =new int[m][n];
        int maxRow=0;
        int indexR=0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random()*2);
            }
        }

        for (int i = 0; i < m; i++) {
            if (maxRow<sumRow(arr,i)){
                maxRow=sumRow(arr,i);
                indexR=i;
            }
        }

        display2DimensionArray(arr);

        return arr[indexR];
    }





    public static void main(String[] args) {

        int[] array1D = {5,6,7,8,9,10,11,19,85,196};
        int[][] array2D = {{45,12,69},{14,56,48},{32,69,42},{10,11,12}};
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the question number ---->");
        int question = input.nextInt();
        System.out.println("----------------------------------------------");


        switch (question){
            case 0:
                //Q0
                display1DimensionArray(array1D);
                display2DimensionArray(array2D);
                System.out.println("----------------------------------------------");

                break;
            case 1:
                //Q1
                System.out.println("Sum of the column is : " + sumColumn(array2D,0));
                System.out.println("Sum of the row is : " + sumRow(array2D,1));
                System.out.println("----------------------------------------------");
                break;

            case 2:
                //Q2
                System.out.println("Random char between 'A' and 'Z' is : " + random('A','Z'));//Q2a

                //Q2b
                System.out.print("Enter the number of students : ");
                int numberOfStudents = input.nextInt();
                System.out.print("Enter the number of questions : ");
                int numberOfQuestions = input.nextInt();

                char[][] answers = new char[numberOfStudents][numberOfQuestions];
                for (int i = 0; i < numberOfStudents; i++) {
                    for (int j = 0; j < numberOfQuestions; j++) {
                        answers[i][j] = random('A','E');
                    }
                }


                //Q2c
                char[] answerArray=answerArray(numberOfQuestions);
                System.out.print("Answer array is :");
                for (int i = 0; i < numberOfQuestions; i++) {
                    System.out.print(answerArray[i]+",  ");
                }

                System.out.println("\n");
                //Q2d
                //Write a method that given an array and two indexes, swaps elements at those indexes
                //according to given method header
                int[] arraySwap = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
                System.out.println("Array before swap :");
                display1DimensionArray(arraySwap);
                swap(arraySwap,4,12);
                System.out.println("Array after swap :");
                display1DimensionArray(arraySwap);

                int[] sonuc =grade(answers,answerArray);
                System.out.print("Final grades of students : ");
                display1DimensionArray(sonuc);

                System.out.println("----------------------------------------------");
                break;

            case 3:
                int[][] matrixA = generateMatrix(3,6);
                int[][] matrixB = generateMatrix(3,6);
                System.out.println("MatrixA :");
                display2DimensionArray(matrixA);
                System.out.println("MatrixB :");
                display2DimensionArray(matrixB);

                System.out.println("");
                System.out.println("matrixA+matrixB =");
                display2DimensionArray(addMatrix(matrixA,matrixB));
                System.out.println("----------------------------------------------");

                break;


            case 4:
                int[][] points = {{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
                System.out.println("Points :");
                display2DimensionArray(points);
                System.out.println();
                System.out.println("Closest point to point 0 is : " + getClosestPoint(points,0));
                System.out.println("Closest point to point 1 is : " + getClosestPoint(points,1));
                System.out.println("Closest point to point 2 is : " + getClosestPoint(points,2));
                System.out.println("Closest point to point 3 is : " + getClosestPoint(points,3));
                System.out.println("Closest point to point 4 is : " + getClosestPoint(points,4));
                System.out.println();


                System.out.println("Round 3.1415926535 to 2 decimal places : " + round(3.1415926535,2));
                System.out.println("Round 3.1415926535 to 3 decimal places : " + round(3.1415926535,3));
                System.out.println("Round 3.1415926535 to 4 decimal places : " + round(3.1415926535,4));
                System.out.println("Round 3.1415926535 to 5 decimal places : " + round(3.1415926535,5));
                System.out.println("Round 3.1415926535 to 6 decimal places : " + round(3.1415926535,6));

                System.out.println("----------------------------------------------");
                break;


             case 5:
                 System.out.println("2D array and most 1s are : ");
                    display1DimensionArray(locateMostOnes(5,5));
                    System.out.println("----------------------------------------------");

                 break;


            default:
                System.out.println("  Yanlış seçim ! \nLütfen 0,1,2,3,4,5 sayılarından birini tuşlayınız.");
                break;
        }


    }
}
