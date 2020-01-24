
import stack.*;


import java.util.*;

/**
 * Evaluates postfix expression
 *
 * @author Anthony Gonzalez
 *
 */
public class PostfixEvaluator
{
    //Input expression
    private Expression postfixExpression;
    private int valueOfExpression;

    public String [] varNames = {"A", "B","C","D","E"};
    public String [] values =      {"10",   "5", "8",  "9",  "3"};


    /**
     * Constructor: assigns parameter to the instance variable
     */
    //------------------------------------------------------------
    public PostfixEvaluator(Expression postfix)
    {
        postfixExpression = postfix;
    }

    /**
     * Evaluates the postfixExpression
     */
    //-----------------------------------------------------------
    public int eval()
    {
        //Starts with an empty operand stack
        IStack<Token> operandStack = new ArrayListStack<Token>();

        //Temp variable
        Token thisToken;
        ArrayList<Token> postfix = postfixExpression.getExpression();
        //Main Loop: Parse the postfix expression
        for (int k = 0; k < postfix.size(); k++)
        {
            //Get the next token from postfix
            thisToken = postfix.get(k);

            //If it is an operand, push it into stack
            if (thisToken.isOperand())
            {
                operandStack.push(thisToken);
                //System.out.println(operandStack);
            }
            //If it is an operator,
            else if (thisToken.isOperator())
            {
                //Get two operands out of the stack
                if (operandStack.isEmpty())
                {
                    System.out.println
                            ("Error in PostfixEvaluator.eval() "+
                                    "-- Input expression was probably wrong");
                    return Integer.MIN_VALUE;
                }
                Token operand2 = operandStack.pop();

                if (operandStack.isEmpty())
                {
                    System.out.println
                            ("Error in PostfixEvaluator.eval() "+
                                    "-- Input expression was probably wrong");
                    return Integer.MIN_VALUE;
                }
                Token operand1 = operandStack.pop();


                //Perform the operation2
                Token result =
                        calculate(thisToken, operand1, operand2);

                //Push the result back into the stack
                operandStack.push(result);
                //System.out.println(operandStack);
            }
        }

        //At the end, if only one element is left in the stack
        if (operandStack.isEmpty())
        {
            System.out.println("Error in PostfixEvaluator.eval() "+
                    "-- Input expression was probably wrong");
            return Integer.MIN_VALUE;
        }

        //Get the operand out of the stack, and convert it into
        //an integer
        Token topToken = operandStack.pop();
        valueOfExpression = Integer.parseInt(topToken.getBody());

        if (operandStack.isEmpty())
            return valueOfExpression;
        else
        {
            System.out.println("Error in PostfixEvaluator.eval() "+
                    "-- Input expression was probably wrong");
            return Integer.MIN_VALUE;
        }

    }

    /**
     * Performs an arithmetic operation
     */
    //---------------------------------------------------------------
    private Token calculate(Token opr, Token opd1, Token opd2)
    {
        // Get the first char from opr, it is the operator: +, -, ...



            String s = opr.getBody().toString();

        //Get the two operands by converting from String to int

        int op2 = 0;
        int op1 = 0;


        if (opd1.toString().equals("A")){
            op1 = Integer.parseInt(values[0]);
            op2 = Integer.parseInt(opd2.getBody());
        }else if (opd2.toString().equals("A")){
            op2 = Integer.parseInt(values[0]);
            op1 = Integer.parseInt(opd1.getBody());
        }else if (opd1.toString().equals("B")){
            op1 = Integer.parseInt(values[1]);
            op2 = Integer.parseInt(opd2.getBody());
        }else if (opd2.toString().equals("B")){
            op2 = Integer.parseInt(values[1]);
            op1 = Integer.parseInt(opd1.getBody());
        } else if (opd1.toString().equals("C")){
            op1 = Integer.parseInt(values[2]);
            op2 = Integer.parseInt(opd2.getBody());
        } else if (opd2.toString().equals("C")){
            op2 = Integer.parseInt(values[2]);
            op1 = Integer.parseInt(opd1.getBody());
        } else if (opd1.toString().equals("D")){
            op2 = Integer.parseInt(values[3]);
            op1 = Integer.parseInt(opd1.getBody());
        }else if (opd2.toString().equals("D")){
            op2 = Integer.parseInt(values[3]);
            op1 = Integer.parseInt(opd1.getBody());
        }else if (opd1.toString().equals("E")){
            op1 = Integer.parseInt(values[4]);
            op2 = Integer.parseInt(opd2.getBody());
        }else if (opd2.toString().equals("E")){
            op2 = Integer.parseInt(values[4]);
            op1 = Integer.parseInt(opd1.getBody());
        }
        else{
             op1 = Integer.parseInt(opd1.getBody());
             op2 = Integer.parseInt(opd2.getBody());
        }

        //Default return value, in case an error occurs
        int res = Integer.MAX_VALUE;

        //Perform the operation, and set a value for res
        switch (s)
        {

            case "+" : res = op1+op2;break;
            case "-" : res = op1-op2;break;
            case "*" : res = op1*op2;break;
            case "/" : if (op2 != 0)
                res = op1/op2;
            else
                System.out.println("Division by zero error in"+
                        " PostfixEvaluator.calculate().");
                break;
            case "%" : if (op2 != 0)
                res = op1%op2;
            else
                System.out.println("Division by zero error in"+
                        " PostfixEvaluator.calculate().");
                break;

            case "<" : if (op1 < op2)
                res = 1;
            else
                res = 0;
                break;

            case "<=": if (op1 <= op2)
                res = 1;
            else
                res = 0;
                break;
            case ">" : if (op1 > op2)
                res = 1;
            else
                res = 0;
                break;

            case ">=" : if (op1 >= op2)
                    res = 1;
            else
                res = 0;
                break;

            case "==" : if (op1 == op2)
                res = 1;
            else
                res = 0;
                break;

            case "!=" : if (op1 != op2)
                res = 1;
            else
                res = 0;
                break;
            case "&&" : if ((op1 < 1 && op2 < 1) || (op1 > 0 && op2 > 0))
                res = 1;
            else
                res = 0;
                break;

            case "||" : if ((op1 != 0 || op2 != 0))
                res = 1;
            else
                res = 0;
                break;

            default: System.out.println("Illegal Operator in "+
                    "PostfixEvaluator.calculate()");
        }
        //Convert res into a Token and return it.
        return new Token(""+res);
    }
}
