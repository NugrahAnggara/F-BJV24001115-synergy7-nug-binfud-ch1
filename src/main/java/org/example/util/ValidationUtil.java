package org.example.util;

public class ValidationUtil
{
    public void validateConfirm(String input)
    {
        System.out.println("(Y) untuk lanjut\n(n) untuk keluar");
        if (input.equals("n")) {
            System.exit(0);
        }
    }

}
