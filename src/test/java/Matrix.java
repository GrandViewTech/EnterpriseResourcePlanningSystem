import java.util.StringJoiner;

public class Matrix
	{
		
		public static void main(String[] args)
			{
				int[][] outerMatrix =
					{
							{ 1, 2, 3, 4, 5 },
							{ 6, 7, 8, 9, 10 },
							{ 11, 12, 13, 14, 15 },
							{ 16, 17, 18, 19, 20 },
							{ 21, 22, 23, 24, 25 } };
				int outerMatrixLenght = outerMatrix.length;
				StringJoiner joiner = new StringJoiner(" ");
				for (int i = (outerMatrixLenght - 1); i > 0; i--)
					{
						int[] innerMatrix = outerMatrix[i];
						int innerMatrixLenght = innerMatrix.length;
						for (int j = 0; j < innerMatrixLenght; j++)
							{
								joiner.add("" + innerMatrix[j]);
							}
					}
				System.out.println(joiner.toString());
			}
			
	}
