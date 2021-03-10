/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge.repository;

import challenge.Domain.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class DressRepository extends BaseRepository<Dress> {

    private final String _path;

    public DressRepository() {
        super(Dress.class);
        this._path = "dresses.txt";
    }

    public void insert(Dress model) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<Dress> items = this.list();

        if (items == null) {
            items = new ArrayList<Dress>();
        }

        items.add(model);

        //refresh file...
        this.refreshFile(items);
    }

    public List<Dress> list() throws FileNotFoundException, InstantiationException, IllegalAccessException {
        File myObj = new File(this._path);

        if (!myObj.exists()) {
            return null;
        }

        ArrayList<Dress> items;
        try (Scanner myReader = new Scanner(myObj)) {
            items = new ArrayList<Dress>();

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Dress model = super.getInstance();
                String[] parts = data.split("[|]");

                model.setCode(Integer.parseInt(parts[0]));

                model.setEntryDate(
                        new Date(
                                Integer.parseInt(parts[1].substring(0, 4)),
                                Integer.parseInt(parts[1].substring(4, 6)),
                                Integer.parseInt(parts[1].substring(6))));
                model.setBuyLocal(parts[2]);
                model.setType(parts[3]);
                model.setBrand(parts[4]);
                model.setDescription(parts[5]);
                model.setSize(Size.valueOf(parts[6]));
                model.setColor((Color.valueOf(parts[7])));
                model.setTagValue(Double.parseDouble(parts[8]));
                model.setPayValue(Double.parseDouble(parts[9]));
                model.setSuggestedPrice(Double.parseDouble(parts[10]));

                items.add(model);
            }
        }

        return items;
    }

    public void update(Dress dress) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<Dress> items = this.list();

        if (items != null && items.size() > 0) {
            for (Dress item : items) {
                if (item.getCode() == dress.getCode()) {
                    item.setBrand(dress.getBrand());
                    item.setBuyLocal(dress.getBuyLocal());
                    item.setCalculatedValue(dress.getCalculatedValue());
                    item.setColor(dress.getColor());
                    item.setDescription(dress.getDescription());
                    item.setEntryDate(dress.getEntryDate());
                    item.setPayValue(dress.getPayValue());
                    item.setSize(dress.getSize());
                    item.setSuggestedPrice(dress.getSuggestedPrice());
                    item.setTagValue(dress.getTagValue());
                    item.setType(dress.getType());

                    break;
                }
            }

            this.refreshFile(items);
        }
    }

    private void refreshFile(List<Dress> items) throws IOException {
        FileWriter writer = new FileWriter(this._path, false);

        if (items.size() > 0) {
            for (Dress item : items) {
                String dateStr = item.getEntryDate().getYear() + "";

                if (item.getEntryDate().getMonth() < 10) {
                    dateStr += "0" + item.getEntryDate().getMonth();
                } else {
                    dateStr += item.getEntryDate().getMonth();
                }

                if (item.getEntryDate().getDay() < 10) {
                    dateStr += "0" + item.getEntryDate().getDay();
                } else {
                    dateStr += item.getEntryDate().getDay();
                }

                String line
                        = Integer.toString(item.getCode()) + "|"
                        + dateStr + "|"
                        + item.getBuyLocal() + "|"
                        + item.getType() + "|"
                        + item.getBrand() + "|"
                        + item.getDescription() + "|"
                        + item.getSize() + "|"
                        + item.getColor() + "|"
                        + item.getTagValue() + "|"
                        + item.getPayValue() + "|"
                        + item.getSuggestedPrice() + "|"
                        + "\r\n";

                writer.write(line);
            }
        }

        writer.flush();
    }

    public void delete(Dress model) throws FileNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<Dress> itens = this.list();

        if (itens != null && itens.size() > 0) {
            for (Dress item : itens) {
                if (item.getCode() == model.getCode()) {
                    itens.remove(item);
                    break;
                }
            }

            this.refreshFile(itens);
        }
    }
}
