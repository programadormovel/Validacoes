import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Digite seu cpf (somente números): ");
        Scanner tcd = new Scanner(System.in);
        String cpf = tcd.nextLine();

        if (Util.validaCPF(cpf)) {
            System.out.println("CPF OK");
        } else {
            System.out.println("CPF Inválido!");
        }

        tcd.close();
    }
}

class Util {
    public static boolean validaCPF(String cpf) {
        int numero = 0;
        int indice = 1;
        int digito1 = 0;
        int digito2 = 0;
        int digito1Original = 0;
        int digito2Original = 0;

        try {
            if (cpf.length() == 11) {
                digito1Original = Integer.parseInt(String.valueOf(cpf.charAt(9)));
                digito2Original = Integer.parseInt(String.valueOf(cpf.charAt(10)));

                for (int i = 8; i >= 0; i--) {
                    int itemCpf = Integer.parseInt(String.valueOf(cpf.charAt(i)));
                    indice = indice + 1;
                    numero = numero + (indice * itemCpf);
                }
                int resto = numero % 11;

                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                if (digito1 == digito1Original) {
                    numero = 0;
                    indice = 1;
                    for (int i = 9; i >= 0; i--) {
                        int itemCpf = Integer.parseInt(String.valueOf(cpf.charAt(i)));
                        indice = indice + 1;
                        numero = numero + (indice * itemCpf);
                    }
                    resto = numero % 11;
                    if (resto < 2)
                        digito2 = 0;
                    else
                        digito2 = 11 - resto;

                    if (digito2 == digito2Original)
                        return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
        }

        return false;
    }
}