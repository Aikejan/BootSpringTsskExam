package peaksoft.exception;

import org.springframework.stereotype.Controller;

@Controller
public class MyException extends Exception{
    public void myException(String message){

        System.out.println("It is not right");
    }
}
