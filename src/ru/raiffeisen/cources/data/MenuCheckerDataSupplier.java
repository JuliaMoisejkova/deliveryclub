package ru.raiffeisen.cources.data;

import java.util.ArrayList;
import java.util.List;

public class MenuCheckerDataSupplier {
    public static List<MenuChoiseTestPair> getTestData(){
        List<MenuChoiseTestPair> pairList =
                new ArrayList<>();

        MenuChoiseTestPair pair1 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tDelivery Club - заказ и доставка еды. Все службы доставки: еда на дом и в офис в Москве - удобно, круглосуточно и бесплатно!\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                                        "",
                                        "Все рестораны");
        MenuChoiseTestPair pair2 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tДоставка пиццы в Москве, круглосуточный онлайн заказ пиццы на дом или в офис - Delivery Club\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                        "Пицца",
                        "Пицца");
        MenuChoiseTestPair pair3 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tДоставка суши на дом в Москве, онлайн заказ суши и роллов, заказать роллы в Москве с бесплатной доставкой в Delivery Club\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                        "Суши",
                        "Суши");
        MenuChoiseTestPair pair4 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tГорячие шашлыки с доставкой на дом в Москве — Delivery Club\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                        "Шашлыки",
                        "Шашлыки");
        MenuChoiseTestPair pair5 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tОсетинские пироги с доставкой на дом, заказ и бесплатная доставка в Москве от Delivery Club\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                        "Пироги",
                        "Пироги");
        MenuChoiseTestPair pair6 =
                new MenuChoiseTestPair("\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t\tДоставка бургеров и гамбургеров от Delivery Club Москва\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t \n" +
                        "\t",
                        "Бургеры",
                        "Бургеры");

        pairList.add(pair1);
        pairList.add(pair2);
        pairList.add(pair3);
        pairList.add(pair4);
        pairList.add(pair5);
        pairList.add(pair6);

        return pairList;
    }
}
