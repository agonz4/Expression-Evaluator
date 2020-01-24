/**
 * Arranges for the evaluation of an arithmetic expression
 *
 * @author (Anthony Gonzalez)
 * @version (December 2019)
 */
public class ExpressionEvaluator
{

    public int evaluate(Expression infix)
    {
        //Instantiate an InfixToPostfixConverter
        InfixToPostfixConverter itop = new InfixToPostfixConverter(infix);

        //Convert infix to postfix
        itop.convertToPostfix();
        Expression postfix = itop.getPostfix();

        //Print the postfix
        System.out.println
                ("Postfix Expression:     "+postfix.toString());

        //Instantiate a PostfixEvaluator
        PostfixEvaluator peval = new PostfixEvaluator(postfix);

        //Evaluate the postfix expression
        int value = peval.eval();

        //Return the calculated value
        return value;

    }
}
