/**
 * Tester class for ExpressionEvaluator
 *
 * @author Anthony Gonzalez
 * @version Dec 2019
 */
public class ExpressionEvaluatorTester
{
    public static void main(String[] args)
    {

        Expression [] testerExpressions = {
               new Expression("1 < A"),
                new Expression("1 == 2"),
                new Expression("1 != B"),
                new Expression("1 > 2"),
                new Expression("1 >= 2"),
                new Expression("1 <= 2"),
                new Expression("1 && 0 "),
                new Expression(" 1 || 0"),
                new Expression(" 0 || 0"),
                new Expression("-1 && -2 "),
                new Expression("-2 || 0 "),
                new Expression("25 || 26 "),
                new Expression(" 25 || 0 "),
                new Expression("25 && 26 "),
                new Expression("25 || 26 && 0 "),
                new Expression("( 25 || 26 ) && 0"),
                new Expression("1 < 2 && 2 < 3"),
                new Expression("1 < 2 && 2 > 3"),
                new Expression("1 < 2 || 2 < 3"),
                new Expression("1 < 2 || 2 > 3"),
                new Expression(" 1 > 2 || 2 > 3 "),
                new Expression("1 < 2 < 3"),
                new Expression("1 < 2 > 3"),
                new Expression("1 < 2 + 5"),
                new Expression("( 1 < 2 ) + 5"),
                new Expression("2 < 3 * 5 + 4"),
                new Expression("( 2 < 3 ) * ( 5 + 4 )"),
                new Expression("( 2 <  3 * 5 ) + 4"),
                new Expression("( 25 + ( 10 > 5 ) * 3 ) % 6"),
                new Expression("( 25 < 8 < 9 ) + ( 8 * 3 > 2 ) "),
                new Expression("2 + 3 != 5 < 6 > 4 || 8 && 9 * 4 / 2"),
                new Expression("25 + 45 "),
                new Expression("10 * ( 5 + 3 )  "),
                new Expression("20 "),
                new Expression("A * 5 + 3"),
                new Expression("A * ( B + ( 12 - 9 ) + D ) / 10 "),
                new Expression("100 % ( ( 3 + 2 ) + 3 ) / 4 "),





        };

        ExpressionEvaluator e = new ExpressionEvaluator();

        for (int i = 0; i < testerExpressions.length; i++)
        {
            System.out.println
                    ("Infix Expression:       "+testerExpressions[i]);

            System.out.println
                    ("Value of Expression:" + " "
                            + e.evaluate(testerExpressions[i])+"\n\n");
        }


    }
}
