package org.example.view;

import lombok.experimental.Accessors;
import org.example.entity.MenuModel;
import org.example.helper.Helper;
import org.example.helper.InitializeMenu;
import org.example.helper.exception.InputException;
import org.example.util.ValidationUtil;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


@Accessors(chain = true)
public class MenuView {
    Scanner scan = new Scanner(System.in);
    Map<String, MenuModel> menu = new InitializeMenu().getMenu();

    public void displayMenu() {

        int i = 0;
        Set<String> keyset = menu.keySet();
        Iterator<String> iterator = keyset.iterator();
        System.out.println(new Helper().headerMenu("Selamat Datang Di BinarFud" + "\nSilahkan Pilih Makanan:"));


        while (iterator.hasNext()) {
            String key = iterator.next();
            i += 1;
            MenuModel menuModel = menu.get(key);
            System.out.println(i + ". " + new Helper().formatString(menuModel));
        }

        String stringBuilder = "99. Pesan Dan Bayar\n" +
                "0. Keluar aplikasi";

        System.out.println(stringBuilder);

        boolean triggered = false;

        do {
            System.out.print("=> ");
            String optionMenu = scan.next();
            try {
                new ValidationUtil().inputValidate(optionMenu);
                triggered = true;
            } catch (InputException inputException) {
                String messageOption = """
                        \"""(Y) untuk lanjut
                        (n) untuk keluar""";

                System.out.println(inputException.getMessage() + messageOption);

                String optionValidate = scan.next();
                if (optionValidate.equals("n")) {
                    System.out.println("Berhasil Keluar");
                    System.exit(0);
                }
            }
        } while (!triggered);

    }

    public int insertQuantity(String name, int price) {
        StringBuilder header = new Helper().headerMenu("Berapa Pesana Anda")
                        .append(String.format("\n%-16s |%d",name,price));

        System.out.println(header);
        System.out.print("=> ");
        return scan.nextInt();
    }

    public void viewPayment(){
        new Helper().headerMenu("Konfirmasi Dan Pembayaran");

    }
}
