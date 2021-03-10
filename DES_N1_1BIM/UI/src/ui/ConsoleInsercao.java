/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import challenge.Domain.Color;
import challenge.Domain.Size;
import challenge.Domain.Dress;
import challenge.business.BusinessFactory;
import challenge.business.DressBusiness;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class ConsoleInsercao extends BaseConsole {

    @Override
    public boolean execute() {

        try {
            BusinessFactory<DressBusiness> factory = new BusinessFactory<DressBusiness>(DressBusiness.class);
            DressBusiness business = factory.getInstante();
            Dress model = business.getInstance();

            this.draw(model);
            business.insert(model);

            System.out.println("Roupa incluída com sucesso!!!");
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }

        return false;
    }

    protected void draw(Dress model) throws IOException {
        //code...
        System.out.println("Informe o código: ");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setCode(Integer.parseInt(reader.readLine()));

        //entry date...
        System.out.println("Informe a data de entrada (dd/mm/yyyy): ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));

        String buffer = reader.readLine();

        model.setEntryDate(new Date(
                Integer.parseInt(buffer.substring(6)),
                Integer.parseInt(buffer.substring(3, 5)),
                Integer.parseInt(buffer.substring(0, 2))));

        //buy local...
        System.out.println("Informe o local de compra: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setBuyLocal(reader.readLine());

        //type...
        System.out.println("Informe o tipo: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setType(reader.readLine());

        //brand...
        System.out.println("Informe a marca: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setBrand(reader.readLine());

        //description...
        System.out.println("Informe a descrição (detalhes): ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setDescription(reader.readLine());

        //size...
        System.out.println("Informe o tamanho (P,M,G): ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setSize(Size.valueOf(reader.readLine()));

        //color...
        System.out.println("Informe a cor (White, Yellow, Red, Black): ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setColor(Color.valueOf(reader.readLine()));

        //tag value...
        System.out.println("Informe o preço na etiqueta: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setTagValue(Double.parseDouble(reader.readLine()));

        //pay value...
        System.out.println("Informe o valor pago: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setPayValue(Double.parseDouble(reader.readLine()));

        //suggested price...
        System.out.println("Informe o preço sugerido: ");
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        model.setSuggestedPrice(Double.parseDouble(reader.readLine()));
    }
}
